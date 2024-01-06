package Tutorial;

public class DeleteOperation {
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
	public void delete_First() {
		if(head==null)
			return ;
		System.out.println(head.data+" Data Node deleted");
		head=head.next;
	}
	
	public void delete_Last() {
		if(head==null)
			return ;
		if(head.next==null)
			return;
		Node temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		System.out.println(temp.next.data+" Data Node deleted");
		temp.next=null;
	}
	
	public void delete_position(int pos) {
		if(pos==1) {
			System.out.println(head.data+" Data Node deleted");
			head=head.next;
		}
		int count=1;
		Node temp=head;
		Node prev=head;
		while(temp.next!=null && pos>count) {
			prev=temp;
			temp=temp.next;
			count++;
		}
		prev.next=temp.next;
		
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
	public static void main(String[] args) {
		DeleteOperation list=new DeleteOperation();
		list.delete_First();
		list.insert_First( 0);
		list.insert_First(2);
		list.insert_First(3);
		list.insert_First(4);
		list.insert_First(5);
		list.display();
		System.out.println();
		list.delete_position(5);
		System.out.println();
		list.display();
		list.delete_position(2);
		System.out.println();
		list.display();
		list.delete_position(2);
		System.out.println();
		list.display();
		
		

	}

}
