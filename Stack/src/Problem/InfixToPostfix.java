package Problem;

import java.util.Stack;

public class InfixToPostfix {
	public int getPriority(char c) {
		if(c == '^')/* exponent operator, highest precedence*/
		{
			return(3);
		}
		else if(c == '*' || c == '/')
		{
			return(2);
		}
		else if(c == '+' || c == '-')          
		{
			return(1);
		}
		else
		{
			return(0);
		}
	  }

	public String solve(String A) {
        Stack<Character> st = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        char ch[] = A.toCharArray();
        for(char c: ch) {
        	//if any operand then add in Postfix expression  
            if(c!='^' && c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
                 sb.append(c) ;
            } 
            // if character come opening bracket then add to that bracket sign to stack.
            else if (c == '(') {
                st.push(c);
            }
            //if character is closing bracket then pop element from stack and add that element to postfix expression until got opening bracket.
            else if (c == ')') {
                while(!st.isEmpty()) {
                    char t = st.pop();
                    if(t != '(') {
                    	 sb.append(t) ;
                    } else {
                        break;
                    }
                 }
            }
            //if character is operator
            else if(c == '+' ||c == '-' ||c == '*' ||c == '/' || c=='^') {
            	//-3
                if(st.isEmpty()) {
                	st.push(c);
                }
                else {
                	//iterate stack until stack empty
                  while(!st.isEmpty()) {
                	  char t = st.pop();
                	  //if stack top element is opening bracket(which push earlier)
                	  if(t == '(') {
                		  st.push(t);
                		  break;
                	  } 
                	  //Check stack top operator precedence < expression character operator precedence then push that operator into stack(+ < *)
                	  //then push * ( that is character of expression.Otherwise that pop element operator add to postfix expression
                	  else if(t == '+' || t == '-' || t == '*' || t == '/' || t=='^') {
                		  if(getPriority(t) <  getPriority(c)) {
                			  	st.push(t);
                			  	break;
                		  } else {
                			  sb.append(t) ;
                		  }
                	  }
              
                  }
                  st.push(c);
                }
            }
        }
        while(!st.isEmpty()) {
        	 sb.append(st.pop()) ;
        }

        
        return sb.toString();
    }
	public static void main(String[] args) {
		InfixToPostfix exp=new InfixToPostfix();
		String s1 = exp.solve("a+b*(c^d-e)^(f+g*h)-i");
	    System.out.println(s1);
	    String s2=exp.solve("x^y/(a*z)+b");
	    System.out.println(s2);
		String s3 = exp.solve("3*(4+5)-6/(1+2)");
	    System.out.println(s3);

	}

}
