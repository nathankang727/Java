import java.util.*;
import java.io.*;
import java.math.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class code {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = in.nextLine();
		System.out.println("Hi " + name + "!! My name is Bordy the Birdbot. What do you want me to do today?");
		System.out.println("+-----------------------------------------------------+");
    System.out.println("|             DIVISION C - TEAM #_TM_ID_              |");
    System.out.println("+-----------------------------------------------------+");
    System.out.println("| 1. I will make you a nametag!                       |");
    System.out.println("| 2. Drawing some staircases!                         |");
    System.out.println("| 3. Convert a number to binary                       |");
    System.out.println("| 4. Guess the number: the game                       |");
    System.out.println("| 5. I'll find all *cool* numbers between two numbers |");
    System.out.println("| 6. Find the worm!                                   |");
    System.out.println("| 7. Did your birthday happen on a weekend?           |");
    System.out.println("+-----------------------------------------------------+");
    System.out.println("\nPick a number:");
    boolean validInput = false;
    while(!validInput) {
    	int number = Integer.parseInt(in.nextLine());
    	if(number == 1) {
      	validInput = true;
      	nametag(name);
    	}
    	else if(number == 2) {
      	validInput = true;
      	
    	}
    	else if(number == 3) {
      	validInput = true;
      	convertToBinary();
    	}
    	else if(number == 4) {
      	validInput = true;
      	guessingGame();
    	}
    	else if(number == 5) {
      	validInput = true;
      	
    	}
    	else if(number == 6) {
      	validInput = true;
      	
    	}
    	else if(number == 7) {
      	validInput = true;
      	input7();
    	}
    	else {
      	System.out.println("That's not a valid option! Please pick a different number:");
    	}
      System.out.println("\nThanks for talking to me <3 See you again!");
			in.close();
		}
  }
  public static void nametag(String name) {
		String nameCopy = name;
		Scanner in = new Scanner(System.in);
		System.out.println("                                 8");
		System.out.println("                              .;8^8;. ");
		System.out.println("                        _.o888'  *  '888o._ ");
		System.out.println("^--______....*-*-*-*-^`          *          `^-*-*-*-*....______--^ ");
		System.out.println("\\                                                                 / ");
		System.out.println(" |                          My name is:                          | ");
		//System.out.println(" |                                                               | ");
		if(name.length() > 55) {
			nameCopy = name.substring(0, 55);
		}
		String nameLine = " |";
		int firstSpace = (63 - nameCopy.length()) / 2;
		int lastSpace = firstSpace;
		if(nameCopy.length() % 2 == 0)
			firstSpace++;
		for(int i = 0; i < firstSpace; i++)
			nameLine += " ";
		nameLine += nameCopy;
		for(int i = 0; i < lastSpace; i++)
			nameLine += " ";
		System.out.println(nameLine + "|");
		System.out.println(" |                                                               | ");
		System.out.println("/__-*-*-*....________                         ________....*-*-*-__\\");
		System.out.println("                     `^-.        *        .-^` ");
		System.out.println("                         `888o.  *  .o888` ");
		System.out.println("                              `^888^`");
		System.out.println("\nHere\'s a nametag for you!");
		in.close();
	}
	public static void convertToBinary() {
		Scanner in = new Scanner(System.in);
		System.out.println("What number do you want me to convert?");
    boolean validInput = false;
    int n = 0;
    while(!validInput) {
      try {
        n = Integer.parseInt(in.nextLine());
        if(n < 1 || n > 2048) {
            System.out.println("Please enter a number between 1 and 2048:");
            continue;
        }
        validInput = true;
      }
      catch(Exception e) {
        System.out.println("Please enter a number between 1 and 2048:");
      }
    }
		System.out.println(n + " in binary is " + Integer.toString(n, 2) + ".");
    in.close();
	}
  public static void guessingGame() {
		Scanner in = new Scanner(System.in);
		int randomNum = (int)(Math.floor(Math.random() * (900) + 100));
		System.out.println("I'm thinking of a random 3 digit integer. Can you take a guess as to what it is?");
		int guess = 0;
		while(guess != randomNum) {
			System.out.println("Please enter a new guess between 100 and 999:");
			try {
				guess = Integer.parseInt(in.nextLine());
				if(guess < 100 || guess > 999) {
					continue;
				}
				else if(guess < randomNum) {
					System.out.println("TOO LOW: Your guess was too low!");
				}
				else if(guess > randomNum) {
					System.out.println("TOO HIGH: Your guess is too high!");
				}
				else if(guess == randomNum) {
					System.out.println("\nYou guessed it! The number was " + randomNum + ".");
				}
			}
			catch(Exception e) {
				continue;
			}
		}
		in.close();
	}
  
  static void input7() {
		Scanner in = new Scanner(System.in);
    	System.out.println("Did your birthday happen on a weekend? Please give me a date (YYYY-MM-DD) to find out what day of the week it was on:");
        String date = in.nextLine();
        if (dayName(date, "YYYY-MM-DD").equals("Saturday") || dayName(date, "YYYY-MM-DD").equals("Sunday")) {
        	System.out.println(date.replace("-", "") + " was a " + dayName(date, "YYYY-MM-DD") + "! That's a weekend! Yay!");
        }
        else {
        	System.out.println(date.replace("-", "") + " was a " + dayName(date, "YYYY-MM-DD") + "! That's not a weekend : (");
        }
	}
	
	static String dayName(String inputDate, String format){
		Date date = null;
	    try {
			date = new SimpleDateFormat(format).parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return new SimpleDateFormat("EEEE").format(date);
	}
}