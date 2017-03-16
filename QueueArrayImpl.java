package week2_prob2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QueueArrayImpl {

	StringBuilder s = new StringBuilder();
	private int capacity;
	int queueArr[];
	int front = 0;
	int rear = -1;
	int currentSize = 0;
	String popped;
	
	public QueueArrayImpl(int queueSize){
		this.capacity = queueSize;
		queueArr = new int[this.capacity];
		System.out.println(Arrays.toString(queueArr));
	}
	
	public void enqueue(int n){
		int v = n;
		rear++;
		queueArr[rear] = v;
	}
	
	public void dequeue(){
		front++;
		s.append(queueArr[front-1]+"\n");
		//System.out.println((queueArr[front-1]));
		//System.out.println(front);
		
	}
	
	public static void main(String args[]) throws IOException{
		File file = new File("input.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
		int n = Integer.parseInt(br.readLine());
		QueueArrayImpl q = new QueueArrayImpl(n);
		//System.out.println(N);
		String line;
		int val=0;
		String action;
		
		while((line=br.readLine())!= null){
			StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
			
			if(stringTokenizer.countTokens()>1){
				action = stringTokenizer.nextElement().toString(); //enqueue in this case +
				val = Integer.parseInt(stringTokenizer.nextElement().toString());
				//System.out.println("action " + action + " val " + val);
				q.enqueue(val);
			}else{
				//dequeue
				q.dequeue();
			}
		}
		
		System.out.println(Arrays.toString(q.queueArr));
		System.out.println(q.s);
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
	    writer.println(q.s);
	    writer.close();
		
	}
	
}
