from flask import Flask, render_template, request, redirect

from users import User


app = Flask(__name__)    

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



if __name__==("__main__"):      
    app.run(debug=True)    

