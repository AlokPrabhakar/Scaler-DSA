package Problem;

import Tutorial.ReverseLinkedList.Node;

public class RemoveDuplicate {
	static Node head=null;
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
	public void duplicate() {
		Node temp=head;
		if(head.next==null) {
			if(head.data==head.next.data)
				head.next=null;
			return;
		}
		Node temp2=head.next;
		while(temp!=null && temp2!=null) {
			if(temp.data==temp2.data) {
				temp.next=temp2.next;
				temp2=temp2.next;
			}else {
				temp=temp2;
				temp2=temp2.next;
			}
		}
	}
	public static void main(String[] args) {
		RemoveDuplicate list=new RemoveDuplicate();
		list.insert_First(1);
		list.insert_First(2);
		list.insert_First(2);
		list.insert_First(3);
		list.insert_First(3);
		list.insert_First(3);
		list.insert_First(3);
		list.insert_First(4);
		list.insert_First(4);
		list.display();
		System.out.println();
		list.duplicate();
		list.display();
		System.out.println();

	}

}
