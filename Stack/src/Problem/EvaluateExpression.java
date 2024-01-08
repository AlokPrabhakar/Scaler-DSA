package Problem;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
	public int evalRPN(ArrayList<String> A) {
		Stack<Integer> st=new Stack<> ();
		for(int i = 0 ; i < A.size() ; i++)
        {
            if(A.get(i).equals("+") || A.get(i).equals("-") || A.get(i).equals("*") || A.get(i).equals("/") )
            {
                int x = st.pop() ;                
                int y = st.pop() ;
               
                int result = 0 ;
                char ch=A.get(i).charAt(0);
                switch(ch)
                {
                    case '+' : result = y + x ; break ;
                    case '-' : result = y - x ; break ;
                    case '*' : result = y * x ; break ;
                    case '/' : result = y / x ; break ;
                }

                st.push(result) ;                
            }
            else
            {
                int num = Integer.parseInt(A.get(i));
                st.push(num) ;
            }
}

        return st.pop() ;
	}
	
	public static void main(String[] args) {
		

	}

}
