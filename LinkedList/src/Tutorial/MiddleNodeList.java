package Tutorial;

import Tutorial.InsertOperation.Node;

public class MiddleNodeList {
	Node head=null;
	public class Node{
		int data;
		Node next;
		Node(int val){
			data=val;
			next=null;
		}
	}
	
	Node insert_First(int val) {
		Node node=new Node(val);
        node.next=head; 
        head=node;
        return head;
	}
	public void display() {
		// Run loop from head upto last node which next part is null
		System.out.print("The List : - ");
		Node temp=head;
		while(temp.next!=null) {
			System.out.print(temp.data+" -> ");
			temp=temp.next;
		}
		System.out.print(temp.data);
	}
	/*
	 * Middle node of list 
	 * Concept - A bus cover 200km 
	 * 	fast bus cover in 2hrs
	 * slow bus cover in 4hrs
	 * fast cover in half time total distance.
	 */
	public void middleNode() {
		Node slow=head;
		Node fast=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		System.out.println("The middle node data is : "+slow.data);
	}
	public static void main(String[] args) {
		MiddleNodeList list=new MiddleNodeList();
		list.insert_First(0);
		list.insert_First(1);
		list.insert_First(2);
		list.insert_First(3);
		list.insert_First(4);
		list.insert_First(5);
		list.display();
		System.out.println();
		list.middleNode();
	}

}
