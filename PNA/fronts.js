class Node {
    constructor(val) {
        this.value = val;
        this.next = null;              
    }
}

class SLL {
    constructor() {
        this.head = null;
    }

    addFront(val) {
    var new_node = new Node(val);
    if(!this.head) {
        new_node.next = this.head;
        this.head = new_node;
        return this;
    }
}



    removeFront() {
    if (this.head === null) {
        return null;
    }
    var newHead = this.head; 
    this.head = newHead.next;
    newHead.next = null; 
    return this.head;
    }

    getHeadValue(){
    if (this.head === null) {
        return null;
    }
    else {
    return this.head.value
    }
}
}