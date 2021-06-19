import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Prob19 {
    private static final String INPUT_FILE_NAME = "Prob19.in.txt";
    
    public static void main(String[] args) {
        try {
            File inFile = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            String inLine = null;
            int[][][] rotors = {
                    {{1, 2, 4, -3, 1, -1, 2, 0, 1, -7}, {3, -1, 7, -2, 1, -1, -4, 0, -2, -1}}, 
                    {{0, 2, 3, -1, 2, 4, -5, -3, 0, -2}, {0, 5, 1, -2, 3, -3, -2, 2, 0, -4}}, 
                    {{5, 8, -1, 4, -1, 3, -6, -5, -4, -3}, {6, 1, 5, 1, 4, -5, 3, -4, -3, -8}}, 
                    {{1, 5, 3, -1, 5, -5, 1, -3, -5, -1}, {5, -1, 1, 5, 3, -3, -5, -1, 1, -5}}};
            
            int[] reflector = {3, 5, 6, -3, 1, -1, -5, 2, -6, -2};            

            int T = Integer.parseInt(br.readLine());
            
            while (T-- > 0) {
                
                int[][] currentMachine = new int[7][];
                
                int[] rotorOffsets = new int[7];
                Arrays.fill(rotorOffsets, 0);
                
                int[] initialPositions = new int[3];
                
                for (int i=0; i<3; i++) {
                    inLine = br.readLine();
                    String[] tokens = inLine.split(" ");
                    
                    int rotorNumber = Integer.parseInt(tokens[0]) - 1;
                    int rotorOffset = Integer.parseInt(tokens[1]);
                    
                    initialPositions[i] = rotorOffset;
                    
                    currentMachine[i] = rotors[rotorNumber][0];
                    rotorOffsets[i] = rotorOffset;
                    
                    currentMachine[6-i] = rotors[rotorNumber][1];
                    rotorOffsets[6-i] = rotorOffset;
                }


                
                currentMachine[3] = reflector;
                
                inLine = br.readLine();
                
                for (int i=0; i<inLine.length(); i++) {
                    int currentIndex = Integer.parseInt(inLine.substring(i, i+1));
                    System.out.println(currentIndex);
                    for (int step=0; step<7; step++) {
                        int nextWireIndex = currentIndex - rotorOffsets[step];
                        if (nextWireIndex < 0) nextWireIndex += 10;
                        
                        currentIndex += currentMachine[step][nextWireIndex];
                        
                        if (currentIndex < 0) currentIndex += 10;
                        if (currentIndex > 9) currentIndex -= 10;
                    }
                    
                    System.out.print(currentIndex);
                    
                    rotorOffsets[2]++;
                    rotorOffsets[4]++;
                    if (rotorOffsets[2] > 9) {
                        rotorOffsets[2] = 0;
                        rotorOffsets[4] = 0;
                    }
                    
                    if (rotorOffsets[2] == initialPositions[2]) {
                        rotorOffsets[1]++;
                        rotorOffsets[5]++;
                        if (rotorOffsets[1] > 9) {
                            rotorOffsets[1] = 0;
                            rotorOffsets[5] = 0;
                        }
                        
                        if (rotorOffsets[1] == initialPositions[1]) {
                            rotorOffsets[0]++;
                            rotorOffsets[6]++;
                            if (rotorOffsets[0] > 9) {
                                rotorOffsets[0] = 0;
                                rotorOffsets[6] = 0;
                            }
                        }
                    }
                }
                
                System.out.println();            
            }
            
            br.close();
            fr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
