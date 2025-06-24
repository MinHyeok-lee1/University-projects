package backjoon_basic04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starchopping {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int x = N;
		while (x != 0) {
			for (int i = 1; i <= N; i++) {
				if (i % 2 != 0) {
					sb.append('*');
				} else {
					sb.append(' ');
				}
			}
			sb.append('\n');
			for (int i = 1; i <= N; i++) {
				if (i % 2 != 0) {
					sb.append(' ');
				} else {
					sb.append('*');
				}
			}
			
			sb.append('\n');
			x--;
		}
		System.out.print(sb);
	}

}

/*
다른방법 1)
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
		in.close();
 
		for(int i = 1; i <= 2*N; i++){
 
			// 홀수 행
			if(i % 2 == 1){
				for(int j = 1; j <= N; j++){
					// 홀수 번째
					if(j % 2 == 1){
						System.out.print("*");
					}
					// 짝수 번째
					else{
						System.out.print(" ");
					}
				}
			}
 
			// 짝수 행
			else{
				for(int j = 1; j <= N; j++){
					// 홀수 번째
					if(j % 2 == 1){
						System.out.print(" ");
					}
					// 짝수 번째
					else{
						System.out.print("*");
					}
				}
			}
			System.out.print("\n");
 
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
		int N = Integer.parseInt(br.readLine());
 
 
		for(int i = 1; i <= 2*N; i++){
 
			// 홀수 행
			if(i % 2 == 1){
				for(int j = 1; j <= N; j++){
					// 홀수 번째
					if(j % 2 == 1){
						System.out.print("*");
					}
					// 짝수 번째
					else{
						System.out.print(" ");
					}
				}
			}
 
			// 짝수 행
			else{
				for(int j = 1; j <= N; j++){
					// 홀수 번째
					if(j % 2 == 1){
						System.out.print(" ");
					}
					// 짝수 번째
					else{
						System.out.print("*");
					}
				}
			}
			System.out.print("\n");
 
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
		
		// 첫 번째 행
		for(int i = 0 ; i < N ; i++) {
			if(i%2 == 0) {
				sb.append('*');
			}
			else {
				sb.append(' ');
			}
		}
		sb.append('\n');
 
		// 두 번째 행
		for(int i = 0; i < N ; i++) {
			if(i%2!=0) {
				sb.append('*');
			}
			else {
				sb.append(' ');
			}
		}
		sb.append('\n');
		
 
		// sb 에 저장된 문자열을 String 변수에 저장
		String str = sb.toString();
        
		// sb 에 str 을 N-1 번 반복 저장
		for(int i = 1; i < N ; i++) {
			sb.append(str);
		}
		
		System.out.println(sb);
	}
 
}
*/
