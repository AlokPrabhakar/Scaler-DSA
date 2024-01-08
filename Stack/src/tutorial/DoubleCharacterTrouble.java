package tutorial;

import java.util.Stack;

public class DoubleCharacterTrouble {
	 public static String solve(String A) {
		 Stack<Character> stack=new Stack<> ();
		 
	        for(int i=0;i<A.length();i++) {
	        	char ch=A.charAt(i);
	        	if(stack.empty()) {
	        		stack.push(ch);
	        	}
	        	else if(stack.peek()==(ch)) {
	        		stack.pop();
	        	}else {
	        		stack.push(ch);
	        	}
	        }
	        StringBuilder sb = new StringBuilder();
	        while(stack.isEmpty() == false){
	            sb.append(stack.pop());
	        }
	        return sb.reverse().toString();
	    }
	public static void main(String args[]) {
		System.out.println(solve("ABBS"));
		
	}
}
