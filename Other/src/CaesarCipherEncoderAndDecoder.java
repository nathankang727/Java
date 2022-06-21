//import java.io.*;
//public class CaesarCipherEncoder {
//	public static void main(String[] args) throws IOException {
//		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Welcome to the Caesar Encoder. Please type in the message you want to encrypt.");
//		String command = input.readLine().toLowerCase();
//		if(command.equals("e")) {
//			System.out.println("Please enter the message you want to encode.");
//			String message = input.readLine();
//			System.out.println("Please enter the key shift (number from 1 to 25).");
//			try {
//				int key = Integer.parseInt(input.readLine());
//				if(key < 1 || key > 25) {
//					System.out.println("Error - unknown key. Please try again.");
//				}
//				else {
//					System.out.println("Thank you! Your encrypted message is:");
//					System.out.println(encode(message, key));
//				}
//			}
//			catch(Exception e) {
//				System.out.println("Error - unknown key. Please try again.");
//			}
//		}
//		else if(command.equals("d")) {
//			System.out.println("Please enter the message you want to decode.");
//			String message = input.readLine();
//			System.out.println("Please enter the key.");
//			String key = input.readLine();
//			System.out.println("Thank you! Your encrypted message is:");
//			System.out.println(encode(message, key));
//		}
//		else {
//			System.out.println("Unknown command. Please rerun the program and input a correct command.");
//		}
//		input.close();
//	}
//}