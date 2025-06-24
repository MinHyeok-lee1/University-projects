package backjoon_basic05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Constatnt {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(reverseString(st.nextToken()));
		int B = Integer.parseInt(reverseString(st.nextToken()));
		
		System.out.print(A > B ? A : B);
	}
	
	public static String reverseString(String s) {
		return (new StringBuffer(s)).reverse().toString();
	}

}

/* 
다른방법 1)
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
        
		int A = in.nextInt();
		int B = in.nextInt();
        
        in.close();
        
		A = Integer.parseInt(new StringBuilder().append(A).reverse().toString());
		B = Integer.parseInt(new StringBuilder().append(B).reverse().toString());
		
		System.out.print(A > B ? A : B);
	
	}
}

다른방법 2)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
		int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		
		System.out.print(A > B ? A:B);
		
	}
}

다른방법 3)
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		int A = 0;
		int B = 0;
		
		A += System.in.read() - 48;
		A += (System.in.read() - 48)*10;
		A += (System.in.read() - 48)*100;
		
		System.in.read();	// 공백
		
		B += System.in.read() - 48;
		B += (System.in.read() - 48)*10;
		B += (System.in.read() - 48)*100;
		
		System.out.println(A > B ? A : B);
	}
}

*/
