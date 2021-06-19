public class convertBases {
	public static void main(String[] args) {
		//base 10 --> base 2
		String a = Integer.toString(10, 2);
		System.out.println(a);
		//base 2 --> base 10
		System.out.println(Integer.parseInt("101", 2));
	}
}