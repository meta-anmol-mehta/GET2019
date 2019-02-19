class Node { 
    constructor(value){ 
        this.data = value; 
        this.next = null;
    } 
} 
class LinkedList { 
    constructor() { 
        this.head = null; 
        this.size = 0; 
    }    
} 
var linkedlist = new LinkedList();
function addNode() { 
	var inputValue = document.getElementById("input").value;
	//node to be added
	if(inputValue==""){
				
				window.alert("enter valid value");
				return;
				
				}
	var node = new Node(inputValue); 
    // to store current Node  
    var currentNode;  
    // if list is Empty add the element and make it head 
    if (linkedlist.head == null){
        linkedlist.head = node; 
    }
    else { 
        currentNode = linkedlist.head;  
        // iterate to the end of the list 
        while (currentNode.next) { 
            currentNode = currentNode.next; 
        }
        // add node 
        currentNode.next = node;
    } 
	displayNode();
    linkedlist.size++; 
} 

function deleteNode(){
    var element = document.getElementById('input').value;
    var currentNode = linkedlist.head; 
    var previousNode = null; 
    while (currentNode != null) { 
        // comparing element with currentNode data if found then remove     
        if (currentNode.data === element) { 
            if (previousNode == null) { 
                linkedlist.head = currentNode.next; 
            } else { 
                previousNode.next = currentNode.next; 
            } 
            linkedlist.size--; 
			displayNode();
            return 1;
        } 
        previousNode = currentNode; 
        currentNode = currentNode.next; 
    } 
    window.alert("Element not found!");
    return -1; 
}

function displayNode(){
	document.getElementById("screen").innerHTML="";
    if(linkedlist.head == null){
		document.getElementById("showList").style.display = "none";
        window.alert("EMPTY LIST");
        return -1;
    }
	document.getElementById("showList").style.display = "block";
	var currentNode = linkedlist.head; 
    while(currentNode.next){
        document.getElementById("screen").innerHTML += currentNode.data +"&nbsp;";
		currentNode = currentNode.next;
    }
	document.getElementById("screen").innerHTML += currentNode.data;
    return 1;
}