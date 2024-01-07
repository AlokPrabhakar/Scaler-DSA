package Tutorial;

public class MergeTwoList {
	static Node head1=null;
	static Node head2=null;
	public class Node{
		int data;
		Node next;
		Node(int val){
			data=val;
			next=null;
		}
	}
	
	Node insert_First_list1(int val) {
		Node node=new Node(val);
        node.next=head1;
        head1=node;
        return head1;
	}
	Node insert_First_list2(int val) {
		Node node=new Node(val);
        node.next=head2;
        head2=node;
        return head2;
	}
	public void display(Node head) {
		// Run loop from head upto last node which next part is null
		System.out.print("The List : - ");
		Node temp=head;
		while(temp.next!=null) {
			System.out.print(temp.data+" -> ");
			temp=temp.next;
		}
		System.out.print(temp.data);
	}
	public Node merge(Node head1,Node head2) {
		Node head=null,temp=null;
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		
		if(head1.data<head2.data) {
			head=head1;
			head1=head1.next;
		}else {
			head=head2;
			head2=head2.next;
		}
		temp=head;
		while(head1!=null && head2!=null) {
			if(head1.data<head2.data) {
				temp.next=head1;
				head1=head1.next;
			}else {
				temp.next=head2;
				head2=head2.next;
			}
			temp=temp.next;
		}
		if(head1!=null) {
			temp.next=head1;
		}else {
			temp.next=head2;
		}
		
		return head;
	}
	public static void main(String[] args) {
		MergeTwoList list1=new MergeTwoList();
		list1.insert_First_list1(7);
		list1.insert_First_list1(6);
		list1.insert_First_list1(4);
		list1.insert_First_list1(3);
		
		MergeTwoList list2=new MergeTwoList();
		list2.insert_First_list2(9);
		list2.insert_First_list2(8);
		list2.insert_First_list2(7);
		list2.insert_First_list2(2);
		
		list1.display(head1);
		System.out.println();
		list1.display(head2);
		
		Node temp=list1.merge(head1, head2);
		System.out.println();
		list1.display(temp);

	}

}
