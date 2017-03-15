import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class week2_prob1_redo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		
		File file = new File("input.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
		String N = br.readLine();
		//System.out.println(N);
		String line;
		int val=0;
		String action;
		Stack a = new Stack();
		StringBuilder sb = new StringBuilder();
		
		while ((line = br.readLine()) != null){
			//System.out.println(line);
			StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
			//System.out.println(stringTokenizer.countTokens());
			
			if(stringTokenizer.countTokens()>1){
				action = stringTokenizer.nextElement().toString();
				val = Integer.parseInt(stringTokenizer.nextElement().toString());
				//System.out.println("action " + action + " val " + val);
				a.push(val);
			}else if(stringTokenizer.countTokens() == 1){
				String popped = a.pop().toString();
				sb.append(popped + "\n");
			}
		}
		
		//System.out.println(a);
		//System.out.println(sb);
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
	    writer.println(sb);
	    writer.close();
	    
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		//System.out.println(totalTime);
	}

}
