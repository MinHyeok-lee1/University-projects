package backjoon_basic02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MultiplicationTable {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int n = 1;
		br.close();
		StringBuilder sb = new StringBuilder();
		do {
			sb.append(N + " * " + n + " = " + N * n + "\n");
			n++;
		} while (n < 10);

		System.out.print(sb);
	}

}

/* 다른방법 1)

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);	
		int a = in.nextInt();
		
		in.close();		
		
		for(int i = 1; i<10;i++) {
			System.out.println(a+" * "+i+" = "+(a*i));
		}
	}
}

다른방법 2)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());	
		br.close();
        
		for(int i = 1; i<10;i++) {
			System.out.println(a+" * "+i+" = "+(a*i));
		}
	}
}

다른방법 3)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());	
		br.close();
		
		StringBuilder sb = new StringBuilder();
        
		for(int i = 1; i<10;i++) {
			sb.append(a).append(' ').append('*').append(' ').append(i);
			sb.append(' ').append('=').append(' ').append(a*i).append('\n');
		}
		System.out.print(sb);
	}
}

다른방법 4)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());	
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		for(int i = 1; i<10;i++) {
			bw.write(a+" * "+i+" = "+a*i+"\n");
		}
		bw.flush();
		bw.close();
	}
}

*/

