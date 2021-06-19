package ACSL18_19;
import java.util.*;
import java.io.*;
public class AllStar1_ACSL_Patience {
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("1819AllStar1.in")));
    	for(int i = 0; i < 13; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		ArrayList<ArrayList<Card>> piles = new ArrayList();
    		while(st.hasMoreTokens()) {
    			String input = st.nextToken();
    			String valueString = input.substring(0, 1);
    			valueString = valueString.replace("A", "1").replace("T", "10").replace("J", "11").replace("Q", "12").replace("K", "13");
    			int value = Integer.parseInt(valueString);
    			char suit = input.charAt(1);
    			boolean foundPile = false;
    			for(int j = 0; j < piles.size(); j++) {
    				int prevValue = piles.get(j).get(piles.get(j).size() - 1).v;
    				char prevSuit = piles.get(j).get(piles.get(j).size() - 1).s;
    				if((value < prevValue || prevValue == 1 && value == 13) && suit != prevSuit) {
    					foundPile = true;
    					piles.get(j).add(new Card(value, suit));
    					break;
    				}
    			}
    			if(!foundPile) {
    				piles.add(new ArrayList<Card>());
    				piles.get(piles.size() - 1).add(new Card(value, suit));
    			}
    		}
    		int maxPile = 0;
    		int minSum = Integer.MIN_VALUE;
    		for(int j = 0; j < piles.size(); j++) {
    			if(piles.get(j).size() > maxPile) {
    				maxPile = piles.get(j).size();
    				minSum = 0;
    				for(int k = 0; k < piles.get(j).size(); k++)
    					minSum += piles.get(j).get(k).v;
    			}
    			else if(piles.get(j).size() == maxPile) {
    				int sum = 0;
    				for(int k = 0; k < piles.get(j).size(); k++)
    					sum += piles.get(j).get(k).v;
    				if(sum < minSum)
    					minSum = sum;
    			}
    		}
    		System.out.println(minSum);
    	}
    	br.close();
    }
    static class Card {
    	public int v;
    	public char s;
    	public Card(int value, char suit) {
    		this.v = value;
    		this.s = suit;
    	}
    }
}