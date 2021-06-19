public class ReplacePractice {
	public static void main(String[] args) {
		String s = "abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*() ";
		s = s.replaceAll("[^a-z^A-Z^0-9]", "");
		int n = 0;
		for(int i = 0; i < s.length(); i++)
			if('a' <= s.charAt(i) && s.charAt(i) <= 'z')
				n++;
		System.out.println(s);
		System.out.println(n);
	}
}