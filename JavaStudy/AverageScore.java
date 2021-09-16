package backjoon_basic04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AverageScore {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int avg = 0;
		for (int i = 0; i < 5; i++) {
			int N = Integer.parseInt(br.readLine());
			avg += N < 40 ? 40 : N;
		}
		sb.append(avg / 5);
		System.out.print(sb);
	}
}


/*
다른방법 1)
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		
		int sum = 0 ;
		for(int i = 0; i < 5; i++) {
        
			int val = in.nextInt();
			
			sum += val > 40 ? val : 40;
			
			
		}
		System.out.println(sum/5);
	}
 
}

다른방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0 ;
		for(int i = 0 ; i < 5 ; i ++) {
			int val = Integer.parseInt(br.readLine());
			
			sum += val > 40 ? val : 40;
			
		}
		System.out.println(sum/5);
	}
 
}
*/

