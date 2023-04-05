import React, {useState} from 'react';

const Form = (props) => {
    const [todoText, setTodoText] = useState("")
    const {todoList, setTodoList} = props; 
    
const submitHandler = (e) => {
    e.preventDefault();
    setTodoList([...todoList, {text: todoText, markedDelete: false, id: Math.floor(Math.random() * 10000000)}])
    setTodoText(""); 
}
    return ( 
        <div>
            <form onSubmit = {submitHandler}>
                <input value = {todoText} onChange = {(e) => setTodoText(e.target.value)} type="text"> Add a Task Here..</input>
                <button>Add</button>
            </form>
        </div>
    )
};

export default Form;