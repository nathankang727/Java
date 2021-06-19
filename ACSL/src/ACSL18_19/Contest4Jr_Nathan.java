/*
Nathan 7
2018-2019 ACSL Contest 4 Junior Division
ABCobot
*/
package ACSL18_19;
import java.util.*;
import java.io.*;
public class Contest4Jr_Nathan {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1819c4jr.in")));
		for(int i = 0; i < 5; i++) {
			ArrayList<String> equation = new ArrayList<String>();
			String s = br.readLine().replace(" ", "");
			for(int j = 0; j < s.length(); j++)
				equation.add(s.substring(j, j + 1));
			while(equation.size() > 1) {
				for(int j = 0; j < equation.size() - 2; j++) {
					if((equation.get(j).equals("+") || equation.get(j).equals("-") || equation.get(j).equals("*"))
							&& isNumber(equation.get(j + 1)) && isNumber(equation.get(j + 2))) {
						equation.add(j, operators123(equation.get(j), equation.get(j + 1), equation.get(j + 2)));
						for(int k = 0; k < 3; k++)
							equation.remove(j + 1);
						break;
					}
					else if(equation.get(j).equals("@") && isNumber(equation.get(j + 1)) &&
							isNumber(equation.get(j + 2)) && isNumber(equation.get(j + 3))) {
						equation.add(j, operator4(equation.get(j), equation.get(j + 1), equation.get(j + 2),
								equation.get(j + 3)));
						for(int k = 0; k < 4; k++)
							equation.remove(j + 1);
						break;
					}
				}
			}
			System.out.println(equation.get(0));
		}
		br.close();
	}
	public static boolean isNumber(String s) {
		boolean b = true;
		try {
			int test = Integer.parseInt(s);
			if(test == 0 || test != 0)
				test++;
		}
		catch(NumberFormatException test) {
			b = false;
		}
		return b;
	}
	public static String operators123(String operator, String operand1, String operand2) {
		int op1 = Integer.parseInt(operand1);
		int op2 = Integer.parseInt(operand2);
		int res = 0;
		if(operator.equals("+"))
			res = op1 + op2;
		else if(operator.equals("-"))
			res = op1 - op2;
		else
			res = op1 * op2;
		return String.valueOf(res);
	}
	public static String operator4(String operator, String operand1, String operand2, String operand3) {
		if(Integer.parseInt(operand1) > 0)
			return operand2;
		else
			return operand3;
	}
}