class Node {
    constructor(data) {
        this.data = data;
        this.next = null;              
    }
}
class LinkedList {
    constructor() {
        this.head = null;
    }
    displayAll() {
        let runner = this.head;
        let sum = 0;
        let myList = [];
        while (runner !== null) {
            myList.push(runner.data);
            runner = runner.next;
        }
        console.log(myList);
    }
}

