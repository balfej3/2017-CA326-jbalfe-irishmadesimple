import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Extractor {
    public static void main(String[] args) {
		String arr [] = new String [20];
        String[] verbs = new String[]{"bhi", "ta", "nil"};
        ArrayList<String> sentences = new ArrayList<String>();
        String line = "";
		try{
			System.out.print("Enter the file name: ");
			Scanner sc = new Scanner(System.in);
			File file = new File(sc.nextLine());
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				sentences.add(line);
			}
			sc.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		String[] convert = sentences.toArray(new String[0]);
		String [] answers = new String [convert.length];
		int k = 0;
        for (int i = 0; i < convert.length; i++) {
            line = convert[i];
			for(int j = 0; j < verbs.length; j++){
				if(line.substring(0, line.indexOf(' ')).equals(verbs[j])){
					String x = arr[0];
					answers[k] = verbs[j];
					k++;
				}
			}
		}
		
		for(int r = 0; r < convert.length; r++){
			String s = convert[r];
			String [] split = s.split("\\s");
			for(int l = 0; l < split.length; l++){
				if(split[l].equals(answers[r])){
					System.out.print(" - ");
				}
				else System.out.print(split[l] + " ");
			}
			System.out.println();
		}
		
		
		

    }
}
