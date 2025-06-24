package backjoon_basic04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starchopping13 {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
	
		for(int i = 1; i <= N; i++) {
			int j = i;
			while(true) {
				sb.append('*');
				j--;
				if(j == 0) break;
			}
			sb.append('\n');
		}
		
		for(int i = N-1; i > 0; i--) {
			int j = i;
			while(j != 0) {
				sb.append('*');
				j--;
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

}

/*
 다른 풀이 1)
 import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
 
		for (int i = 1; i <= N; i++) {	// 1 ~ N
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
 
		for (int i = N - 1; i > 0; i--) {	// N+1 ~ 2N-1
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
 
	}
 
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		for (int i = 1; i <= N; i++) {	// 1 ~ N
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
 
		for (int i = N - 1; i > 0; i--) {	// N+1 ~ 2N-1
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
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
 
		int N = Integer.parseInt(br.readLine());
 
		StringBuilder sb = new StringBuilder();
 
		for (int i = 1; i <= N; i++) {	// 1 ~ N
			for (int j = 0; j < i; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
 
		for (int i = N - 1; i > 0; i--) {	// N+1 ~ 2N-1
			for (int j = 0; j < i; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
 
		System.out.println(sb);
 
	}
 
}
 */
