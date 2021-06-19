package DataStructures;
import java.util.*;
import java.io.*;
public class RandomProblem1 {
	 public static void main(String[] args) throws IOException {
         BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));
         String input = in.readLine();
         String bomb = in.readLine();
         Stack<Character> stack = new Stack<Character>();
         for(int i = input.length() - 1; i >= 0;  i--) {
             stack.push(input.charAt(i));  
             if(stack.size() >= bomb.length() && stack.peek() == bomb.charAt(0)){
 
                 boolean isBomb = true;
 
                 for(int j = 1; j < bomb.length(); j++){
 
                     if(stack.get(stack.size()-j-1) != bomb.charAt(j)){
                              isBomb = false;
                         break;
                     }
                 }
 
                 if(isBomb){  
                     for(int j = 0; j < bomb.length(); j++) 
                         stack.pop();
                 }
 
             }
 
         }
         
         int size = stack.size();
         StringBuilder sb = new StringBuilder();
         if(stack.isEmpty()){
                System.out.println("FRULA");
         }else{
                for(int i = 0; i < size; i++) 
                    sb.append(stack.pop());
         }
         System.out.println(sb);
 
     }
}