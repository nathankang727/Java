package ACSL14_15;
import java.util.*;
import java.io.*;
public class AllStar2_MailDelivery {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1415AllStar2.in")));
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<String> odd = new ArrayList<String>();
			ArrayList<String> even = new ArrayList<String>();
			int originalNumber = Integer.parseInt(st.nextToken());
			for(int j = 0; j < originalNumber; j++) {
				String s = st.nextToken();
				String zeroes = "";
				for(int k = 0; k < 5 - s.length(); k++)
					zeroes += "0";
				s = s.charAt(0) + zeroes + s.substring(1);
				if(Integer.parseInt(s.substring(1)) % 2 == 1)
					odd.add(s);
				else
					even.add(s);
			}
			for(int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				int newHousesNumber = Integer.parseInt(st.nextToken());
				for(int k = 0; k < newHousesNumber; k++) {
					String s = st.nextToken();
					String zeroes = "";
					for(int l = 0; l < 5 - s.length(); l++)
						zeroes += "0";
					s = s.charAt(0) + zeroes + s.substring(1);
					if(Integer.parseInt(s.substring(1)) % 2 == 1)
						odd.add(s);
					else
						even.add(s);
				}
				Collections.sort(odd);
				Collections.sort(even);
				char startingGate1 = st.nextToken().charAt(0);
				char startingGate2 = startingGate1;
				int ansIndex = Integer.parseInt(st.nextToken()) - 1;
				int startIndex1 = -1;
				int startIndex2 = -1;
				boolean foundIndex1 = false;
				boolean foundIndex2 = false;
				while(!foundIndex1 || !foundIndex2) {
					for(int k = 0; k < odd.size(); k++) {
						if(odd.get(k).charAt(0) == startingGate1) {
							startIndex1 = k;
							foundIndex1 = true;
							break;
						}
					}
					if(!foundIndex1) {
						if(startingGate1 == 'A')
							startingGate1 = 'B';
						else if(startingGate1 == 'B')
							startingGate1 = 'C';
						else if(startingGate1 == 'C')
							startingGate1 = 'D';
						else
							startingGate1 = 'A';
					}
					for(int k = 0; k < even.size(); k++) {
						if(even.get(k).charAt(0) == startingGate2) {
							startIndex2 = k;
							foundIndex2 = true;
							break;
						}
					}
					if(!foundIndex2) {
						if(startingGate2 == 'A')
							startingGate2 = 'B';
						else if(startingGate2 == 'B')
							startingGate2 = 'C';
						else if(startingGate2 == 'C')
							startingGate2 = 'D';
						else
							startingGate2 = 'A';
					}
				}
				String answer = "";
				if(ansIndex < odd.size())
					answer += odd.get((startIndex1 + ansIndex) % odd.size());
				else
					answer += even.get((startIndex2 - odd.size() + ansIndex) % even.size());
				if(answer.substring(1, 4).equals("000"))
					System.out.println(answer.charAt(0) + answer.substring(4));
				else if(answer.substring(1, 3).equals("00"))
					System.out.println(answer.charAt(0) + answer.substring(3));
				else if(answer.substring(1, 2).equals("0"))
					System.out.println(answer.charAt(0) + answer.substring(2));
				else
					System.out.println(answer);
			}
		}
		br.close();
	}
}