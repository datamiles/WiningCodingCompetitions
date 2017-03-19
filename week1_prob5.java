import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class week1_prob5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("input.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		Double[] a = new Double[3];
		Double[] halves = new Double[3];
		String line;
		line = br.readLine();
		StringTokenizer nums = new StringTokenizer(line);
		Double Sum = 0.0;
		Double Avg = 0.0;
		
		for(int i=0; i<a.length; i++){
			Double num = Double.parseDouble(nums.nextElement().toString());
			a[i] = num;
			halves[i] = num/2;
			Sum = Sum + num/2;
		}
		
		//System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(halves));
		Avg = Sum/3;
		//System.out.println(Avg);
		
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
	    writer.println(Avg);
	    writer.close();
		
		
		
	}

}