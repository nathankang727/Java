package ACSL20_21;
import java.util.*;
import java.io.*;
public class AllStar2_Sentences {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> dictionary = new ArrayList<String>();
		for(int i = 0; i < n; i++)
			dictionary.add(br.readLine());
		String sentences = br.readLine();
		System.out.println(generateSentences(dictionary, sentences));
		br.close();
	}
	public static String generateSentences(List<String> dictionary, String sentences) {
        String answer = "";
        Map<Character, String[]> map = new HashMap<Character, String[]>();
        Map<Character, Integer> index = new HashMap<Character, Integer>();
        for(int i = 0; i < dictionary.size(); i++) {
            char pos = dictionary.get(i).charAt(0);
            String[] input = dictionary.get(i).substring(2).split(" ");
            map.put(pos, input);
            index.put(pos, 0);
        }
        String[] sent = sentences.split(" ");
        for(int i = 0; i < sent.length; i++) {
            String sentence = "";
            char type = sent[i].charAt(0);
            if(type == 'Q')
                sentence += "What ";
            for(int j = 1; j < sent[i].length(); j++) {
                char c = sent[i].charAt(j);
                String word = "";
                if(c == 'T')
                    word = "the";
                else if(c == 'A') {
                    char nextChar = sent[i].charAt(j + 1);
                    String temp = map.get(nextChar)[index.get(nextChar)];
                    char charTemp = temp.charAt(0);
                    if(charTemp == 'a' || charTemp == 'e' || charTemp == 'i' || charTemp == 'o' || charTemp == 'u')
                        word = "an";
                    else
                        word = "a";
                }
                else {
                    word = map.get(c)[index.get(c)];
                    index.put(c, ((index.get(c) + 1) % map.get(c).length));
                }
                if(j == 1 && type != 'Q')
                    word = word.substring(0, 1).toUpperCase() + word.substring(1);
                sentence += word + " ";
            }
            sentence = sentence.trim();
            if(type == 'Q')
                sentence += "?";
            else if(type == 'E')
                sentence += "!";
            else
                sentence += ".";
            answer += sentence + " ";
        }
        answer = answer.trim();
        return answer;
    }
}