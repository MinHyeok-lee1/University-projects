package backjoon_basic04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class OXQuiz {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			int x = 0;
	        int y = 0;
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == 'O') {
					y++;
					x += y;
				}else y = 0;
			}
			sb.append(x).append('\n');
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
 
		String arr[] = new String[in.nextInt()];
 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.next();
		}
		
		in.close();
		
		for (int i = 0; i < arr.length; i++) {
			
			int cnt = 0;	// 연속횟수
			int sum = 0;	// 누적 합산 
			
			for (int j = 0; j < arr[i].length(); j++) {
				
				if (arr[i].charAt(j) == 'O') {
					cnt++;
				} 
				else {
					cnt = 0;
				}
				sum += cnt;
			}
			
			System.out.println(sum);
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
 
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());	//테스트 케이스
		
		String arr[] = new String[test_case];
 
		for (int i = 0; i < test_case; i++) {
			arr[i] = br.readLine();
		}
 
		
		for (int i = 0; i < test_case; i++) {
			
			int cnt = 0;	// 연속횟수
			int sum = 0;	// 누적 합산 
			
			for (int j = 0; j < arr[i].length(); j++) {
				
				if (arr[i].charAt(j) == 'O') {
					cnt++;
				} else {
					cnt = 0;
				}
				sum += cnt;
			}
			
			sb.append(sum).append('\n');
		}
		
		System.out.print(sb);
	}
}

다른방법 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringBuilder sb = new StringBuilder();
 
		int test_case = Integer.parseInt(br.readLine()); // 테스트 케이스
 
		for (int i = 0; i < test_case; i++) {
 
			int cnt = 0; // 연속횟수
			int sum = 0; // 누적 합산
 
			for (byte value : br.readLine().getBytes()) {
				
				if (value == 'O') {
					cnt++;
					sum += cnt;
				} 
				else {
					cnt = 0;
				}
			}
			
			sb.append(sum).append('\n');
 
		}
		System.out.println(sb);
 
	}
}

*/
