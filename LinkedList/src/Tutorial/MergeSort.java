package Tutorial;


public class MergeSort {
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
	public Node middleNode(Node head) {
		Node slow=head;
		Node fast=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
		
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
	public Node mergeSort(Node head) {
		if(head==null || head.next==null)
			return head;
		Node mid=middleNode(head);
		Node head2=mid.next;
		mid.next=null;
		head=mergeSort(head);
		head2=mergeSort(head2);
		Node h=merge(head,head2);
		return h;
		
	}
	public static void main(String[] args) {
		MergeSort list2=new MergeSort();
		list2.insert_First(9);
		list2.insert_First(3);
		list2.insert_First(7);
		list2.insert_First(2);
		list2.insert_First(5);
		list2.insert_First(1);
		list2.insert_First(6);
		list2.insert_First(4);
		
		list2.display(head);
		System.out.println();
		
		Node temp=list2.mergeSort(head);
		list2.display(temp);

	}

}
