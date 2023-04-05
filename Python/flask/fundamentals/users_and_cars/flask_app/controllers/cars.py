from flask import Flask, render_template, session, redirect, request
from flask_app import app
from flask_app.models.user import User
from flask_app.models.car import Car
from flask import flash

@app.route("/main")
def main():
    if "user_id" not in session:
        flash("You must be logged in to access the dashboard.")
        return redirect("/")
    
    user = User.get_by_id(["user_id"])
    cars = Car.get_all()

    return render_template("main.html", user=user, cars=cars)

@app.route("/detail/<int:car_id>")
def detail(car_id):
    user = User.get_by_id(session["user_id"])
    car = Car.get_by_id(car_id)
    return render_template("detail.html", user=user, car=car)

@app.route("/edit/<int:car_id>")
def car_edit_page(car_id):
    car = Car.get_by_id(car_id)
    return render_template("edit.html", car=car)

@app.route("/create")
def create_page():
    return render_template("create.html")

@app.route("/createcar", methods=["POST"])
def create():
    valid_car = Car.create(request.form)
    if valid_car:
        return redirect(f"/detail/{valid_car.id}")
    if not valid_car:
        return redirect(f'/create')

@app.route("/detail/<int:car_id>", methods=["POST"])
def update(car_id):

    valid_car = Car.update(request.form, session["user_id"])

    if not valid_car:
        return redirect(f"/detail/{car_id}")
        
    return redirect(f"/detail/{car_id}")

@app.route("/detail/delete/<int:car_id>")
def destroy(car_id):
    Car.destroy(car_id)
    return redirect("/main")