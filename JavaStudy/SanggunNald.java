package backjoon_basic04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SanggunNald {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min2 = 0, min = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			int a = Integer.parseInt(br.readLine());
			if (i == 0) {
				min = a;
			} else {
				if (a <= min)
					min = a;
			}
		}
		for (int i = 0; i < 2; i++) {
			int b = Integer.parseInt(br.readLine());
			if (i == 0) {
				min2 = b;
			} else {
				if (b <= min2)
					min2 = b;
			}
		}
		sb.append(min + min2 - 50);
		System.out.print(sb);

	}

}


/*
다른방법 1)
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int burger = 2001;
		int drink = 2001;
 
		// 버거
		for (int i = 0; i < 3; i++) {
			int value = in.nextInt();
			if (value < burger) {	// 최솟값 찾기
				burger = value;
			}
		}
 
		// 음료
		for (int i = 0; i < 2; i++) {
			int value = in.nextInt();
			if (value < drink) {	// 최솟값 찾기
				drink = value;
			}
		}
 
		System.out.println(burger + drink - 50);
	}
 
}

다른방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int burger = 2001;
		int drink = 2001;
 
		// 버거
		for (int i = 0; i < 3; i++) {
			int value = Integer.parseInt(br.readLine());
			if (value < burger) {	// 최솟값 찾기
				burger = value;
			}
		}
 
		// 음료
		for (int i = 0; i < 2; i++) {
			int value = Integer.parseInt(br.readLine());
			if (value < drink) {	// 최솟값 찾기
				drink = value;
			}
		}
 
		System.out.println(burger + drink - 50);
	}
 
}

*/
