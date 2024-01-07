package tutorial;

public class ImplementationUsingArray {
	static int stack[]=new int[5];
	int top=-1;
	public void push(int x) {
		if(!isEmpty()) {
			System.out.println("Stack Overflow, So data "+x+" not inserted into stack.");
		}else {
			top++;
			stack[top]=x;
		}
			
		
	}
	public int pop() {
		if(top==-1) {
			System.out.println("Stack Underflow, So No Pop operation performed");
			return -1;
		}
		int val=stack[top];
		top--;
		return val;
	}
	public int peek() {
		if(top==-1)
			return -1;
		return stack[top];
	}
	public boolean isEmpty() {
		if(top+1==stack.length)
			return false;
		return true;
	}
	public static void main(String[] args) {
		ImplementationUsingArray stk=new ImplementationUsingArray();
		System.out.println(stk.peek());
		stk.push(3);
		stk.push(4);
		System.out.println(stk.peek());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		

	}

}
