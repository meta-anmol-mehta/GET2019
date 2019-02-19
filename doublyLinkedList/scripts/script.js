class Node { 
    constructor(element){ 
        this.element = element; 
        this.next = null;
        this.prev = null;
    } 
}
class DoublyLinkedList { 
    constructor(){ 
        this.head = null; 
        this.tail = null;
    }    
} 
var linkedlist = new DoublyLinkedList();

function addNode() { 
  var element = document.getElementById("input").value;
  if(element==""){
				
				window.alert("enter valid value");
				return;
				
				}
    let node = new Node(element); 
    // if list is empty
    if (linkedlist.head == null) {
        linkedlist.head = node;
        linkedlist.tail = node;
    }
    else { 
        node.prev = linkedlist.tail;
        linkedlist.tail.next = node;
        linkedlist.tail = node;
    } 
	displayNode();
} 

function deleteNode(){
    var element = document.getElementById('input').value;
    var currentNode = linkedlist.head; 
    var prev = null; 
    // iterate over the list 
    while (currentNode) {          
        if (currentNode.element === element) { 
			// if only that element is there
            if (currentNode == linkedlist.head && currentNode == linkedlist.tail) { 
                linkedlist.head = null;
                linkedlist.tail = null; 
            } else if(currentNode == linkedlist.head) {
                linkedlist.head = linkedlist.head.next;
                linkedlist.head.prev = null;
            } else if(currentNode == linkedlist.tail) {
                linkedlist.tail = linkedlist.tail.prev;
                linkedlist.tail.next = null;
            } else {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
            }
            displayNode();
            return 1;
        } 
        currentNode = currentNode.next; 
    } 
    window.alert("Element not found!");
    return -1; 
}

function displayNode(){
	document.getElementById("screen").innerHTML="";
    if(linkedlist.head == null){
        document.getElementById("showList").style.display = "none";
        window.alert("LIST IS EMPTY NOW");
		return -1;
    }
	document.getElementById("showList").style.display = "block";
    var currentNode = linkedlist.head;
    var array = [];
	while(currentNode.next){
		document.getElementById("screen").innerHTML += currentNode.element +"&nbsp;";
		currentNode = currentNode.next;
    }
	document.getElementById("screen").innerHTML += currentNode.element;
    return 1;
}