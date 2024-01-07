package Tutorial;

import Tutorial.DetectCycle.Node;

public class RemoveCycle {
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
	/*
	 * Check Cycle exist or not
	 * take slow and fast pointer and if both intersect then cycle exist
	 * 
	 */
	public boolean remove() {
		Node slow=head;
		Node fast=head;
		Boolean cycle=false;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				cycle=true;
				break;
			}
		}
		if(cycle==false)return false;
		Node temp=head;
		Node temp2=slow;
		Node end=null;
		while(temp!=temp2) {
			temp=temp.next;
			end=temp2;
			temp2=temp2.next;
		}
		end.next=null;
		return true;
	}
	
	
	
	public static void main(String[] args) {
		RemoveCycle list=new RemoveCycle();
		list.insert_First(5);
		list.insert_First(4);
		list.insert_First(3);
		list.insert_First(2);
		list.insert_First(1);
		/*
		 *  1--> 2 --> 3---> 4--> 5--
		 *  			^			|
		 *  			|-----------
		 *  
		 */
		head.next.next.next.next.next=head.next.next;
		System.out.println(list.remove());
		
		list.display();

	}

}
