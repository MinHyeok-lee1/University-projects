package backjoon_basic03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberofNums {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		br.close();
		StringBuilder sb = new StringBuilder();
		int [] arr = new int[10];
	/*	int X = A*B*C;
		while(true) {
			arr[(X%10)]++;
			X /= 10;
			if(X <= 0) break;
		}  */
		String X = Integer.toString(A*B*C);
		for(int i = 0; i < X.length(); i++) {
			arr[(X.charAt(i) - '0')]++;
		}
		
		for(int i : arr) {
			sb.append(i).append('\n');
		}
		System.out.print(sb);

	}

}


/* 다른방법 1)
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int value = (in.nextInt() * in.nextInt() * in.nextInt());
		String str = Integer.toString(value);
		in.close();
		
		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if ((str.charAt(j) - '0') == i) {
					count++;
				}
			}
			System.out.println(count);
		}
		
	}
}

다른방법 2)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int[] arr = new int[10];
 
		int val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
 
		String str = String.valueOf(val);
 
		for (int i = 0; i < str.length(); i++) {
			arr[(str.charAt(i) - 48)]++;
		}
 
		for (int v : arr) {
			System.out.println(v);
		}
 
	}
}

다른방법 3)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int val = Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		
		while(val!=0) {
			arr[val%10]++;
			val/=10;
		}
		
		for(int result : arr) {
			System.out.println(result);
		}
	}
}

*/
