package backjoon_basic04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneNumber {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
        	if(d(i)) cnt++;
        }
        System.out.print(cnt);   
	}
	
	public static boolean d(int number){
		String str = Integer.toString(number);
		if(number < 100) {
			return true;
		}else {
			for(int i = -9; i < 10; i++) {
				if(str.length() == 3) {
					if(str.charAt(0) + i == str.charAt(1) && str.charAt(1) + i == str.charAt(2)) {
						return true;
					}
				}else if(str.length() == 4) {
					if(str.charAt(0) + i == str.charAt(1) && str.charAt(1) + i == str.charAt(2) && str.charAt(2) + i == str.charAt(3)) {
						return true;
					}
			}
		}
	  }
		return false;
	}
}


/*
다른방법 1)
 import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print(arithmetic_sequence(in.nextInt()));
		in.close();
 
		
	}
 
	public static int arithmetic_sequence(int num) {
		int cnt = 0; // 한수 카운팅
 
		if (num < 100) {
			return num;
		}
 
		else {
			cnt = 99;
			if (num == 1000) { // 예외처리 필수
				num = 999;
			}
 
			for (int i = 100; i <= num; i++) {
				int hun = i / 100; // 백의 자릿수
				int ten = (i / 10) % 10; // 십의 자릿수
				int one = i % 10;
 
				if ((hun - ten) == (ten - one)) { // 각 자릿수가 수열을 이루면
					cnt++;
				}
			}
		}
 
		return cnt;
	}
 
}

다른방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print(arithmetic_sequence(Integer.parseInt(br.readLine())));
		
	}
 
	public static int arithmetic_sequence(int num) {
		int cnt = 0; // 한수 카운팅
 
		if (num < 100) {
			return num;
		}
 
		else {
			cnt = 99;
			if (num == 1000) { // 예외처리 필수
				num = 999;
			}
 
			for (int i = 100; i <= num; i++) {
				int hun = i / 100; // 백의 자릿수
				int ten = (i / 10) % 10; // 십의 자릿수
				int one = i % 10;
 
				if ((hun - ten) == (ten - one)) { // 각 자릿수가 수열을 이루면
					cnt++;
				}
			}
		}
 
		return cnt;
	}
 
}

*/

