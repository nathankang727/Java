import java.util.*;
public class Stacks {
	public static void main(String[] args) {
		 Stack<Integer> st = new Stack<Integer>();
	     st.add(10);
	     st.add(20);
	     st.add(30);
	     st.add(40);
	     System.out.println(st);
	     st.push(50);
	     st.push(60);
	     System.out.println(st);
         System.out.println(st.peek());
         st.pop();
	     System.out.println(st);
	}
}