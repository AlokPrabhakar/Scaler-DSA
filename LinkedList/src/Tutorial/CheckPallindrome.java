package Tutorial;

import Tutorial.ReverseLinkedList.Node;

public class CheckPallindrome {
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
	public Node middleNode() {
		Node slow=head;
		Node fast=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		System.out.println("The middle node data is : "+slow.data);
		return slow;
	}
	public Node reverse(Node head) {
		Node nHead=null;
		Node current=head;
		Node prev=null;
		while(current!=null) {
			Node nextNode=current.next;
			current.next=prev;
			prev=current;
			current=nextNode;
		}
		nHead=prev;
		return nHead;
		
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
	
	public boolean isPallindrome() {
		Node mid=middleNode();
		Node head2=reverse(mid.next);
		Node temp=head;
		Node temp2=head2;
		while( temp2!=null) {
			if(temp.data!=temp2.data)
				return false;
			temp=temp.next;
			temp2=temp2.next;
			
		}
		return true;
	}
	public static void main(String[] args) {
		CheckPallindrome list=new CheckPallindrome();
		list.insert_First(1);
		list.insert_First(2);
		list.insert_First(3);
		list.insert_First(3);
		list.insert_First(2);
		list.insert_First(1);
		list.display();
		System.out.println();
		System.out.println(list.isPallindrome());
		list.display();
		System.out.println();

	}

}
