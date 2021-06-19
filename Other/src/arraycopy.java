
public class arraycopy {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		int[] b = new int[4];
		for(int i = 0; i <  4; i++)
			b[i] = a[i];
		System.out.println(b[2]);
		b[1] = 3;
		System.out.println(a[1]); 
	}
}