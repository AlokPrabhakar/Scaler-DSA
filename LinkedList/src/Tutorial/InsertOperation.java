package Tutorial;

public class InsertOperation {
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
		/*head pointing to 2
		 * 2-->3-->4
		 * 
		 * Create a new node
		 *  * ---------
		 * | 1 |null|     ----> node
		 * ---------
		 */
		Node node=new Node(val);
        node.next=head;
        /*
        *  * ---------
		 * | 1 |next|     ----> node
		 * ---------
		 * here next pointing to node 2
		 */
        head=node;
        return head;
	}
	
	void insert_Back(int val) {
		//if no any node present in list / head pointing to null pointer
		if(head==null) {
			head=new Node(val);
			return;
		}
		// Run loop from head upto last node which next part is null
		Node temp=head;
		
		while(temp.next!=null) {
			temp=temp.next;
		}
		/*
		 * 1 --> 2--> 3-->4
		 * temp pointing to node 4 
		 * ---------
		 * | 4 |null|     ----> temp
		 * ---------
		 */
		temp.next=new Node(val);
				
	}
	
	void insert_Position(int pos,int val) {
		Node node=new Node(val);
		//insert as first node
		if(pos==1) {
			node.next=head;
			head=node;
			return;
		}
		/*
		 * 1 --> 2 --> 4 --> 5 --> 6
		 *  //insert at position 3
		 *  run loop until 2nd position as temp pointer
		 * ---------
		 * | 2 |next|     ----> temp   and temp.next pointing to 4 node
		 * ---------
		 * 
		 * ---------
		 * | 3 |next|     ----> node    node.next= pointing to node which temp node pointing i.e 4
		 * ---------
		 */
		int count=1;
		Node temp=head;
		while(temp.next!=null && pos-1>count) {
			temp=temp.next;
			count++;
		}
		node.next=temp.next;
		temp.next=node;
		
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
		InsertOperation list=new InsertOperation();
		list.insert_Back(1);
		list.insert_First( 0);
		list.insert_First(2);
		list.insert_First(3);

		list.insert_Back(5);
		list.insert_Back(6);
		list.insert_Position(2, 8);
		list.display();
		
	}

}
