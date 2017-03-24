package week1_prob8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WinCompetition {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("input.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
		int line1 = Integer.parseInt(br.readLine());
		System.out.println(line1);
		
		int[] seconds = new int[line1];
		
		String line2 = br.readLine();
		System.out.println(line2);
		
		StringTokenizer stringTokenizer = new StringTokenizer(line2, " ");
		//System.out.println(stringTokenizer.countTokens());
		
		if(stringTokenizer.countTokens()>0){
			for(int i=0; i<seconds.length; i++){
				seconds[i] = Integer.parseInt(stringTokenizer.nextElement().toString());
			}
			
		}
		
		System.out.println(Arrays.toString(seconds));
		
		int maxTimeInSecs = 18000;
		int numProblems = 0;
		int timeSumInSecs = 0;
		
		Arrays.sort(seconds);
		System.out.println(seconds);
		for(int i=0; i<seconds.length; i++){
			int pTime = seconds[i];
			int currTimeElapsed = timeSumInSecs;
			int timeThreshold = currTimeElapsed + pTime;
			System.out.println(pTime + " "+ currTimeElapsed);
			
			if(timeThreshold <= 18000){
				timeSumInSecs = timeSumInSecs + pTime;
				numProblems = numProblems + 1;
			}else{
				timeSumInSecs = timeSumInSecs;
				numProblems = numProblems;
			}
			/*if(seconds[i] <= 18000 && timeSumInSecs <=18000){
				numProblems = numProblems+1;
				timeSumInSecs = timeSumInSecs + seconds[i];
			}*/
		}
		
		System.out.println(numProblems);
		System.out.println(timeSumInSecs);
		
       PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
	   writer.println(numProblems);
	   writer.close();
		
		
	}

}
