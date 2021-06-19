import java.io.*;
public class prob21 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] date = br.readLine().split("-");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		if(month == 3 && day >= 21 || month == 4 && day <= 19)
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Aries.");
		else if(month == 4 && day >= 20 || month == 5 && day <= 20)
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Taurus.");
		else if(month == 5 && day >= 21 || month == 6 && day <= 20)
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Gemini.");
		else if(month == 6 && day >= 21 || month == 7 && day <= 22)
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Cancer.");
		else if(month == 7 && day >= 23 || month == 8 && day <= 22)
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Leo.");
		else if(month == 8 && day >= 23 || month == 9 && day <= 22)
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Virgo.");
		else if(month == 9 && day >= 23 || month == 10 && day <= 22)
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Libra.");
		else if(month == 10 && day >= 23 || month == 11 && day <= 21)
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Scorpio.");
		else if(month == 11 && day >= 22 || month == 12 && day <= 21)
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Sagittarius.");
		else if(month == 12 && day >= 22 || month == 1 && day <= 19)
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Capricorn.");
		else if(month == 1 && day >= 20 || month == 2 && day <= 18)
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Aquarius.");
		else
			System.out.println("If you were born on " + convert(month, day) + ", your sign is Pisces.");
		if(year % 12 == 4)
			System.out.println(year + " is the year of the Rat.");
		else if(year % 12 == 5)
			System.out.println(year + " is the year of the Ox.");
		else if(year % 12 == 6)
			System.out.println(year + " is the year of the Tiger.");
		else if(year % 12 == 7)
			System.out.println(year + " is the year of the Rabbit.");
		else if(year % 12 == 8)
			System.out.println(year + " is the year of the Dragon.");
		else if(year % 12 == 9)
			System.out.println(year + " is the year of the Snake.");
		else if(year % 12 == 10)
			System.out.println(year + " is the year of the Horse.");
		else if(year % 12 == 11)
			System.out.println(year + " is the year of the Sheep.");
		else if(year % 12 == 0)
			System.out.println(year + " is the year of the Monkey.");
		else if(year % 12 == 1)
			System.out.println(year + " is the year of the Rooster.");
		else if(year % 12 == 2)
			System.out.println(year + " is the year of the Dog.");
		else
			System.out.println(year + " is the year of the Pig.");
		br.close();
	}
	public static String convert(int month, int day) {
		if(month == 1)
			return "January " + String.valueOf(day);
		else if(month == 2)
			return "February " + String.valueOf(day);
		else if(month == 3)
			return "March " + String.valueOf(day);
		else if(month == 4)
			return "April " + String.valueOf(day);
		else if(month == 5)
			return "May " + String.valueOf(day);
		else if(month == 6)
			return "June " + String.valueOf(day);
		else if(month == 7)
			return "July " + String.valueOf(day);
		else if(month == 8)
			return "August " + String.valueOf(day);
		else if(month == 9)
			return "September " + String.valueOf(day);
		else if(month == 10)
			return "October " + String.valueOf(day);
		else if(month == 11)
			return "November " + String.valueOf(day);
		else
			return "December " + String.valueOf(day);
	}
}