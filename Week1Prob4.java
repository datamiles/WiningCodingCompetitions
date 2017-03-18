import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class Week1Prob4{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("input.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
	    int[][] a = new int[3][3];
	    String line;

	    int count =0;
		while ((line = br.readLine()) != null){
			StringTokenizer nums = new StringTokenizer(line);
			//System.out.println(line);
			
			for(int i=0; i<a.length; i++){
					a[count][i] = Integer.parseInt(nums.nextElement().toString());
				}
			count++;
			
		}	    
		
		/*for(int[] row : a) {
        printRow(row);
    	}*/
		//System.out.println("==========");
		
		
		
	    
	    StringBuilder s = new StringBuilder();
	    Double[] combs = new Double[6];
	    Double max = 0.0;
	    
	    for(int i0=0; i0<3; ++i0){
	    	for(int i1=0; i1<3; ++i1){
	    		if(i0 != i1){
	    			int i2 = 3-i0-i1;
	    			/*System.out.println("io="+i0+ " i1="+ i1 + " i2=" +i2);
	    			System.out.print(a[0][i0]);
	    			System.out.print(a[1][i1]);
	    			System.out.print(a[2][i2] + "\n");*/
	    			Double result = Math.sqrt(Math.pow(a[0][i0], 2) + Math.pow(a[1][i1],2) + Math.pow(a[2][i2],2));
	    			//System.out.println(result);
	    			s.append(result + " ");
	    			if(result>= max){
	    				max = result;
	    			}
	    		}
	    	}
	    }
	    
	    //System.out.println(max);
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
	    writer.println(max);
	    writer.close();
	}
	
	
	public static void printRow(int[] row) {
		for (int i : row) {
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.println();
	}

}
