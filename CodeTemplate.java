package week1_prob6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CodeTemplate {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();

		File file = new File("input.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
	    String line1 = br.readLine();
	    StringTokenizer dims = new StringTokenizer(line1);
	    int width = Integer.parseInt(dims.nextElement().toString());
	    int height = Integer.parseInt(dims.nextElement().toString());
	    
	    //System.out.println("Dims are :"  + width + " " + height);
	    String lines;

	    String[][] keys = new String[height][width];
	    int count =0;
	    char[] array = new char[width];
	    int rows = 0;
	    //System.out.println(Arrays.deepToString(keys));
	    while ((lines = br.readLine()) != null && rows < height) {
	    	array = lines.toCharArray();
	    	for(int cols=0; cols<array.length; cols++){
	    		keys[rows][cols] = Character.toString(array[cols]);
	    		//System.out.println(Arrays.deepToString(keys));
	    	}
	    	br.mark(1000);
	    	rows++;

	    }
	    
	    //String langName = lines.toString();
	    //System.out.println(langName);
	    StringBuilder sb = new StringBuilder();
	    int sum =0;
	    String langName = "";
	    boolean startToken = false;
	    boolean endToken = false;
	    br.reset();
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    TreeMap<Integer, String> tmap = 
	             new TreeMap<Integer, String>();
	    
	    List<String> listWords = new ArrayList<String>();
	    List<Integer> listNumbers = new ArrayList<Integer>();
	    
	    while((lines = br.readLine()) != null){
	    	lines = lines.trim();
	    	lines = lines.replaceAll("\\s", "");
	    	String temp = lines;
	    	//System.out.println(temp);

	    	sb.append(temp);

	    	if(temp.equals("%TEMPLATE-END%")){
	    		//System.out.println("sb at tempend is  :" + sb);
	    		
	    		String match = "%TEMPLATE-START%";
	    		int position = sb.indexOf(match); // position = 10
	    		//System.out.println(position);

	    		//System.out.println("sb is " + sb.length());
	    		
	    		//extract language name
	    		//langName = sb.substring(0, sb.indexOf("%"));
	    		langName = sb.substring(0, position);
	    		System.out.println("langname is " + langName);
	    		
	    		//remove lang and start and end tags
	    		int frontChop = langName.length() + 16;
	    		int backChop = 14;
	    		
	    		String tempstr = sb.substring(frontChop, sb.length());
	    		//System.out.println("frontchopped :" +tempstr);
	    		
	    		//chop off ending tag
	    		tempstr = tempstr.substring(0, tempstr.length()-backChop);
	    		//System.out.println("backchopped :" +tempstr);
	    		
	    		//reload sb with clean string of the language
	    		sb.setLength(0);
	    		sb.append(tempstr);
	    		
	    		//convert sb to char array
	    		char[] a = new char[sb.length()];
	    		sb.getChars(0, sb.length(), a, 0);
	    		//System.out.println(a);
	    		
	    		//with char array now we can calculate the distances
	    		for(int cols=0; cols<a.length-1; cols++){
	    			char f = a[cols];
		    		char b = a[cols+1];
		    		
		    		//System.out.println("chars are " + Character.toString(f) + " " + Character.toString(b));
		    		int x1,y1 =0;
		    		int x2,y2 =0;
		    		int maxDiff =0 ;
		    		int[] coordinates = new int[4];
		    		
		    		//load coordinates for each char into the coordinates array
		    		for(int i=0; i<height; i++){
		    			for(int j=0; j<width; j++){
		    				if(keys[i][j].equals(Character.toString(f))){
		    					//x1=i;
		    					//y1=j;
		    					//System.out.println("f " + f + " matched " + keys[i][j]);
		    					coordinates[0] = i+1;
		    					coordinates[1] = j+1;
		    				}
		    				if(keys[i][j].equals(Character.toString(b))){
		    					//x2=i;
		    					//y2=j;
		    					//System.out.println("b " + b + " matched " + keys[i][j]);
		    					coordinates[2]=i+1;
		    					coordinates[3]=j+1;
		    				}
		    				
		    			}

		    		}
		    		maxDiff = Math.max(Math.abs(coordinates[0]-coordinates[2]), Math.abs(coordinates[1] - coordinates[3]));
		    		//System.out.println(Arrays.toString(coordinates));
		    		//System.out.println("max diff is " + maxDiff);
		    		sum = sum + maxDiff;
	    		}
	    		
	    		//System.out.println("sum for " + langName + " is " + sum);
	    		//map.put(langName, sum);
	    		//tmap.put(sum, langName);
	    		listWords.add(langName);
	    		listNumbers.add(sum);
	    		sb.setLength(0);
	    		sum=0;
	    		/*System.out.println("----");
	    		System.out.println(tmap);
	    		System.out.println(map);
	    		System.out.println("----");*/

	    		
	    		
	    	}
	    	

	    }
	   
	   //System.out.println(listNumbers);
	   // generates a series of elements, one at a time
       //System.out.println(tmap);
       //int k = (int)tmap.keySet().toArray()[0];
       //String value = tmap.get(k);
       
	   int min = 0;
       String val = "";
       String[] langs = new String[listWords.size()];
       int[] sums = new int[listNumbers.size()];
       //System.out.println("tmap size is" + tmap.size());
       
       /*for(int i=0; i<tmap.size(); i++){
    	   int tk = (int)tmap.keySet().toArray()[i];
    	   String tValue = tmap.get(tk);
    	   System.out.println("populating langs and sums array with " + tk+tValue);
    	   
    	   langs[i] = tValue;
    	   sums[i] = tk;
       }*/

       int[] arr = listNumbers.stream().mapToInt(i -> i).toArray();
       String[] stockArr = new String[listWords.size()];
       stockArr = listWords.toArray(stockArr);
       //String[] arr2 = (String[]) listWords.stream().m(i -> i).toArray();
       
       System.out.println(Arrays.toString(arr));
       for(String s : stockArr)
    	    System.out.println(s);
       
       System.out.println(stockArr[0]);
       min = arr[0];
       val = stockArr[0];
       for(int p=1; p<arr.length; p++){
    	   int v = arr[p];
    	   String l = stockArr[p];
    	   
    	   if (min>v){
    		   min = v;
    		   val = l;
    	   }
       }
       
       System.out.println("min is" + min + "lang is " + val);
       
       //System.out.println(k+value);
       //System.out.println(tmap);
       //System.out.println(map);
	    

       
       PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
	   writer.println(val);
	   writer.println(min);
	   writer.close();
	   
	   long endTime   = System.currentTimeMillis();
	   long totalTime = endTime - startTime;
	   System.out.println(totalTime);

        
        //System.out.println(tmap);

	    
	    
	    //System.out.println(sb);
	    
	    //System.out.println(sum);
	    
	    //System.out.println(Arrays.deepToString(keys));
	    
	    /*int count =0;
		while ((line = br.readLine()) != null){
			StringTokenizer nums = new StringTokenizer(line);
			//System.out.println(line);
			
			for(int i=0; i<a.length; i++){
					a[count][i] = Integer.parseInt(nums.nextElement().toString());
				}
			count++;
			
		}	*/
	}

}
