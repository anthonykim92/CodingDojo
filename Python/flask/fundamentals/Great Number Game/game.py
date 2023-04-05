from flask import Flask, render_template, session, redirect, request
app = Flask(__name__)    
import random 

app.secret_key="greatnumbergamegreatnumbergame."

@app.route('/')          
def index():
    if "number" not in session: 
        session['num']= random.randint(1,100)

    return render_template("game.html")

@app.route('/guess',methods=['POST'])
def guess():
    session['guess'] = int(request.form['guess'])
    return redirect('/')

@app.route('/reset')
def reset():
    session.clear()
    return redirect('/')

if __name__==("__main__"):   
    app.run(debug=True)    

