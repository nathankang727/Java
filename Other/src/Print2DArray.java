
public class Print2DArray {
	public static void print2D(String[][] a) {
		for(int r = 0; r < a.length; r++) {
			for(int  c = 0; c < a[0].length; c++) {
				System.out.print(a[r][c] + " ");
			}
			System.out.println();
		}
	}
} 