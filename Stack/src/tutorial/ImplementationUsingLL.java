package tutorial;

public class ImplementationUsingLL {
	Node head=null;
	public class Node{
		int val;
		Node next;
		Node(int x){
			val=x;
			next=null;
		}
	}
	public void push(int x) {
		Node stack=new Node(x);
		stack.next=head;
		head=stack;
	}
	public int pop() {
		if(head==null)
			return -1;
		int val=head.val;
		head=head.next;
		return val;
		
	}
	public Node peek() {
		return head;
	}
	public static void main(String[] args) {
		ImplementationUsingLL stack=new ImplementationUsingLL();
		stack.push(4);
		System.out.println(stack.peek().val);
		stack.push(6);
		stack.push(2);
		System.out.println(stack.peek().val);
		stack.pop();
	}

}
