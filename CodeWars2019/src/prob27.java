import java.util.*;
import java.io.*;
public class prob27 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		sc.next();
		int temp = sc.nextInt();
		sc.next();
		String owner = sc.next();
		sc.next();
		String ai = sc.next();
		sc.nextLine();
		while(sc.hasNextLine()) {
			String command = sc.nextLine().replace("Hey " + ai + ", ", "");
			command = command.substring(0, 1).toUpperCase() + command.substring(1);
			String[] command2 = command.replaceAll("[^0-9 ]", "").replace("  ", " ").split(" ");
			int[] command3 = new int[2];
			int index = 0;
			for(int i = 0; i < command2.length; i++) {
				try {
					command3[index] = Integer.parseInt(command2[i]);
					++index;
				}
				catch(Exception e) {
					continue;
				}
			}
			if(command.contains("plus") || command.contains("added to"))
				System.out.println(command3[0] + " plus " + command3[1] + " is " + (command3[0] + command3[1]) + ", " + owner);
			else if(command.contains("times") || command.contains("multiplied by"))
				System.out.println(command3[0] + " times " + command3[1] + " is " + (command3[0] * command3[1]) + ", " + owner);
			else if(command.contains("to the") || command.contains("raised to the"))
				System.out.println(command3[0] + " to the power of " + command3[1] + " is " + (int)(Math.pow(command3[0], command3[1]))
						+ ", " + owner);
			else if(command.equals("I'm cold") || command.equals("I'm still cold") || command.equals("Turn up the heat")) {
				System.out.println("Temperature has been raised, " + owner);
				++temp;
			}
			else if(command.equals("I'm hot") || command.equals("I'm still hot") || command.equals("Turn up the AC")) {
				System.out.println("Temperature has been lowered, " + owner);
				--temp;
			}
			else if(command.equals("What's the current temp?") || command.equals("What's the current temperature?"))
				System.out.println("The current temperature is " + temp + ", " + owner);
			else if(command.length() > 11 && command.substring(0, 7).equals("Call me") && command.substring(command.length() - 11)
					.equals("from now on")) {
				owner = command.substring(8, command.length() - 12);
				System.out.println("Okay, I'll call you " + owner + " from now on");
			}
			else if(command.equals("What's your name?"))
				System.out.println("My name is " + ai + ", " + owner);
			else if(command.length() > 15 && command.substring(0, 14).equals("Can I call you")) {
				ai = command.substring(15, command.length() - 1);
				System.out.println("Okay, you can call me " + ai + " from now on");
			}
			else if(command.equals("Tell me a joke"))
				System.out.println("So this guy, a squirrel, and a dog walk into a bar...");
			else if(command.equals("Tell me a better joke"))
				System.out.println("No");
			else if(command.equals("Open the pod bay doors"))
				System.out.println("I can't do that, " + owner);
			else
				System.out.println("I don't understand you, " + owner);
		}
		sc.close();
	}
}