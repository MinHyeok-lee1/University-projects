package backjoon_basic05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordStudy {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		int[] arr = new int[26];
		int max = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) - 'a' >= 0 && S.charAt(i) - 'a' <= 26) {
				arr[S.charAt(i) - 'a']++;
			} else {
				arr[S.charAt(i) - 'A']++;
			}
		}

		char ch = '?';
		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) {
				max = arr[i];
				ch = (char) (i + 65);
			}
			else if (arr[i] == max) {
				ch = '?';
			}
		}
		sb.append(ch);

		System.out.print(sb);
	}

}

/*
다른풀이 1)
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int[] arr = new int[26]; // 영문자의 개수는 26개임
		String s = in.next();
 
		for (int i = 0; i < s.length(); i++){
 
			if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') { // 대문자 범위
				arr[s.charAt(i) - 'A']++;	// 해당 인덱스의 값 1 증가
			}
    
			else {	// 소문자 범위
				arr[s.charAt(i) - 'a']++;
			}
		}
 
 
		int max = -1;
		char ch = '?';
 
		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) {
				max = arr[i];
				ch = (char) (i + 65); // 대문자로 출력해야하므로 65를 더해준다.
			}
			else if (arr[i] == max) {
				ch = '?';
			}
		}
 
		System.out.print(ch);
	}
 
}

다른풀이 2)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26]; // 영문자의 개수는 26개임
		String s = br.readLine();
		
 
		for (int i = 0; i < s.length(); i++) {
			if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
				arr[s.charAt(i) - 97]++;
			} else {
				arr[s.charAt(i) - 65]++;
			}
		}
		int max = -1;
		char ch = '?';
		for (int i = 0; i < 26; i++) {
 
			if (arr[i] > max) {
				max = arr[i];
				ch = (char) (i + 65);
			} 
			else if (arr[i] == max) {
				ch = '?';
			}
		}
		System.out.print(ch);
	}
 
}

다른풀이 3)
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		int[] arr = new int[26]; // 영문자의 개수는 26개임
 
		int c = System.in.read();
 
		while (c > 64) {	// 공백을 입력받는 순간 종료됨 
			
			if (c < 91) {
				arr[c - 65]++;
			} else {
				arr[c - 97]++;
			}
			c = System.in.read();
		}
 
 
		int max = -1;
		int ch = -2;	// ? 는 63 이다.
 
		for (int i = 0; i < 26; i++) {
 
			if (arr[i] > max) {
				max = arr[i];
				ch = i;
			} else if (arr[i] == max) {
				ch = -2;
			}
		}
		System.out.print((char) (ch+65));
	}
 
}

*/