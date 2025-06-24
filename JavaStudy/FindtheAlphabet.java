package backjoon_basic05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindtheAlphabet {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		int [] arr = new int [26];
		for(int i = 0; i < 26; i++) arr[i] = -1;

		
		for(int i = 0; i < S.length(); i++) {		
			if(arr[S.charAt(i) - 'a'] == -1) arr[S.charAt(i) - 'a'] = i;
		}
		for(int x : arr) {
			sb.append(x).append(' ');
		}
		System.out.print(sb);
	}

}
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindtheAlphabet {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		char [] arr = new char[26];
		int [] arr2 = new int [26];
		for(int i = 0; i < 26; i++) {
			arr[i] = (char)(i + 97); 
			arr2[i] = -1;
		}
		
		for(int i = 0; i < S.length(); i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == S.charAt(i) && arr2[j] == -1) arr2[j] = i;
			}
		}
		for(int x : arr2) {
			sb.append(x).append(' ');
		}
		System.out.print(sb);
	}

}
*/
/*
다른방법 1)
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
 
		int[] arr = new int[26];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
 
		String S = in.nextLine();
 
		for(int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
    
			if(arr[ch - 'a'] == -1) {	// arr 원소 값이 -1 인 경우에만 초기화
				arr[ch - 'a'] = i;
			}
		}
 
		for(int val : arr) {	// 배열 출력
			System.out.print(val + " ");
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
 
		int[] arr = new int[26];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
 
		String S = br.readLine();
 
		for(int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
    
			if(arr[ch - 'a'] == -1) {	// arr 원소 값이 -1 인 경우에만 초기화
				arr[ch - 'a'] = i;
			}
		}
 
		for(int val : arr) {	// 배열 출력
			System.out.print(val + " ");
		}
	}
}

*/
