package backjoon_basic04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starchopping9 {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
	    int cnt = 0;
		for(int i = 2*N-1; i > 1; i-=2) {
			int j = i;
			while(j != 0) {
				sb.append('*');
				j--;
			}
			sb.append('\n');
			cnt++;
			for(int x = 0; x < cnt; x++) sb.append(' ');
		}
		
		for(int i = 1; i <= (2*N - 1); i+=2) {
			int j = i;
			while(true) {
				sb.append('*');
				j--;
				if(j == 0) break;
			}
			sb.append('\n');
			cnt--;
			for(int x = cnt; x > 0; x--) sb.append(' ');
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
 
		// 역삼각형 코드
		for (int i = 0; i < N; i++) {	// 1 ~ N
 
			// 공백
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
 
			// 별
			for (int k = 0; k < (2 * N - 1) - (2 * i); k++) {
				System.out.print("*");
			}
 
			System.out.println();
		}
 
		// 삼각형 코드
		for (int i = 0; i < N - 1; i++) {	// N+1 ~ 2N-1
        
			// 공백
			for (int j = 1; j < (N - 1) - i; j++) {	
				System.out.print(" ");
			}
 
			// 별
			for (int k = 0; k < 3 + 2 * i; k++) {
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
 
		// 역삼각형 코드
		for (int i = 0; i < N; i++) {	// 1 ~ N
 
			// 공백
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
 
			// 별
			for (int k = 0; k < (2 * N - 1) - (2 * i); k++) {
				System.out.print("*");
			}
 
			System.out.println();
		}
 
		// 삼각형 코드
		for (int i = 0; i < N - 1; i++) {	// N+1 ~ 2N-1
        
			// 공백
			for (int j = 1; j < (N - 1) - i; j++) {	
				System.out.print(" ");
			}
 
			// 별
			for (int k = 0; k < 3 + 2 * i; k++) {
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
 
 
		// 역삼각형 코드
		for (int i = 0; i < N; i++) {	// 1 ~ N
 
			// 공백
			for (int j = 0; j < i; j++) {
				sb.append(' ');
			}
 
			// 별
			for (int k = 0; k < (2 * N - 1) - (2 * i); k++) {
				sb.append('*');
			}
 
			sb.append('\n');
		}
 
 
		// 삼각형 코드
		for (int i = 0; i < N - 1; i++) {	// N+1 ~ 2N-1
        
			// 공백
			for (int j = 1; j < (N - 1) - i; j++) {
				sb.append(' ');
			}
 
			// 별
			for (int k = 0; k < 3 + 2 * i; k++) {
				sb.append('*');
			}
			sb.append('\n');
		}
        
        
		System.out.println(sb);
	}
 
}
 */

