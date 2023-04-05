from flask import render_template, request, redirect
from flask_app import app

from flask_app.models.users import User
@app.route('/')
def index():
    return redirect('/users')

@app.route('/users')
def users():
    return render_template("Readall.html", users=User.get_all())

@app.route('/user/new')
def newuser():
    return render_template("create.html")



@app.route('/user/create', methods=['POST'])
def submit():
    print(request.form)
    User.save(request.form)
    return redirect('/users')


@app.route('/user/edit/<int:id>')
def edit(id):
    data = { "id":id}
    return render_template("edituser.html", user=User.edit(data))

@app.route('/user/show/<int:id>')
def show(id):
    data = { "id":id}
    return render_template("show.html", user=User.show(data))

@app.route('/user/update', methods=['POST'])
def update(): 
    User.update(request.form)
    return redirect('/')


@app.route('/user/destroy/<int:id>')
def destroy(id):
    data = { 'id' : id}
    User.destroy(data)
    return redirect('/')

@app.route('/create', methods=["POST"])
def create():
    user_info = request.form
    if User.is_valid_user(user_info):
        User.save(user_info)
        print("PASS")
        return redirect('/')
    print("FAIL")
    return redirect('/users/new')