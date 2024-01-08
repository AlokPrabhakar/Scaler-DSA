package tutorial;

import java.util.Stack;

public class BalanceParenthesis {
	public static int solve(String A) {
        Stack<Character> stack=new Stack<> ();
        for(int i=0;i<A.length();i++) {
        	char ch=A.charAt(i);
        	
        	
        	if((ch=='(')||(ch=='{')||(ch=='[')) {
        		stack.push(ch);
        		
        	//example - }(){
        	}else if(stack.empty()) {
        		return 0;
        	}
        	//check next parenthesis and top of stack parenthesis
        	else if((ch==')')&& (stack.peek()=='(')) {
        		
        		stack.pop();
        	}
        	else if((ch=='}')&& (stack.peek()=='{')) {
        		stack.pop();
        	}
        	else if((ch==']')&& (stack.peek()=='[')) {
        		stack.pop();
        	}
        	else 
        		return 0;
        }
        //Example : {}()(
        if(stack.empty())
        	return 1;
        else
        	return 0;
    }
	public static void main(String[] args) {
		String A="{";
		System.out.println(solve(A));

	}

}
