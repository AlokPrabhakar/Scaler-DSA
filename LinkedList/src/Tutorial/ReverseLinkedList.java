package Tutorial;


public class ReverseLinkedList {
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
	public void display_ReverseList(Node head) {
		System.out.print("The Reverse List : - ");
		Node temp=head;
		while(temp.next!=null) {
			System.out.print(temp.data+" -> ");
			temp=temp.next;
		}
		System.out.print(temp.data);
	}
	public static void main(String[] args) {
		ReverseLinkedList list=new ReverseLinkedList();
		list.insert_First( 0);
		list.insert_First(2);
		list.insert_First(3);
		list.insert_First(4);
		list.insert_First(5);
		list.display();
		System.out.println();
		Node rev=list.reverse(head);
		list.display_ReverseList(rev);
		
	}

}
