const Display = (props) => {
    const {todoList, setTodoList} = props;
    const handleCompleted = (todo) => {
        todo.markedDelete = !todo.markedDelete; 
        setTodoList([...todoList]); 


    }
const styled = (markedDelete) => {
    if(markedDelete === true) {
        return "completed"
    }
    else{
        return "notCompleted"
    }

}

const  deleteButton = (idFromBelow) =>{
    setTodoList(
        todoList.filter((todo,index)=>{
            return todo.id !== idFromBelow; 

        })
    )
}
    return(
        <div>
            {
                todoList.map((todo, index)=>(
                    <div className = {styled(todo.markedDelete)}key = {index}>
                        <p>{todo.text}</p>
                        <input onChange ={(e) => handleCompleted(todo)} type="checkbox" />
                        <button onClick ={(e)=> deleteButton(todo.id)}>Delete</button>
                    </div>
                ))
            }
        </div>
    )
}
export default Display; 