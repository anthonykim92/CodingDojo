from flask_app import app
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_bcrypt import Bcrypt
from flask_app.models import user
import re

class Car:
    
    def __init__(self, car):
        self.id = car["id"]
        self.carmodel = car["carmodel"] 
        self.make= car["make"]
        self.year= car["year"]
        self.seller =car["seller"]
        self.description = car["description"]
        self.price = car["price"]
        self.created_at = car["created_at"]
        self.updated_at = car["updated_at"]
        self.car = None 
        

    @classmethod
    def create_valid_car(cls, data):
        if not cls.is_valid(data):
            return False
        
        query = "INSERT INTO cars (model,make,year,seller,description,price) VALUES (%(model)s,%(make)s,%(year)s,%(seller)s,%(descriptioin)s,%(price)s);"
        result = connectToMySQL('users_and_cars').query_db(query,data)
        car = cls.get_by_id("car_id")

        return car

    @classmethod
    def get_one(cls,data):
        query  = "SELECT * FROM users WHERE id = %(id)s;"
        result = connectToMySQL('users_and_cars').query_db(query,data)
        return cls(result[0])

    @classmethod
    def update(cls,data):
        query = "UPDATE users SET model=%(model)s,make=%(make)s,year=%(year)s,seller=%(seller)s,description=%(description)s,price=%(price)s updated_at=NOW() WHERE id = %(id)s;"
        return connectToMySQL('users_and_cars').query_db(query,data)

    @classmethod
    def destroy(cls,data):
        query  = "DELETE FROM users WHERE id = %(id)s;"
        return connectToMySQL('users_and_cars').query_db(query,data)


    @classmethod
    def get_by_id(cls):
        query = """SELECT * FROM cars 
                JOIN users WHERE users.id = cars.users_id;"""
        
        car_data = connectToMySQL('users_and_cars').query_db(query)
        cars = []


        for car in car_data:


            car_obj = cls(car)

            car_obj.user = user.User(
            {
                "id": car["id"],
                "model": car["model"],
                "make": car["make"],
                "year": car["year"],
                "seller": car["seller"],
                "description": car["description"],
                "price": car["price"],
                "created_at": car["created_at"],
                "updated_at": car["updated_at"]
                }
            )
            cars.append(car_obj)


        return cars




    @staticmethod
    def is_valid(car_dict):
        valid = True
        flash_string = " Required and must be at least 3 characters."
        if len(car_dict["name"]) < 3:
            flash("Name " + flash_string)
            valid = False
        if len(car_dict["Network"]) < 3: 
            flash ("Network" + flash_string)
        if len(car_dict["description"]) < 3:
            flash("Description " + flash_string)
            valid = False
        if len(car_dict["release_date"]) <= 0:
            flash("Date required.")
            valid = False
        return valid