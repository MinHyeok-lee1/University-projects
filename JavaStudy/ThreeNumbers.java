package backjoon_basic02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThreeNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		br.close();

		StringBuilder sb = new StringBuilder();

		if(A > B) {
			if(A < C) sb.append(A);
			else sb.append(C);
		} else {
			if(B < C) sb.append(B);
			else {
				if(A > C) sb.append(A);
				else sb.append(C);
			}
		}
		System.out.print(sb);
	}

}

/* 다른방법 1)
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int[] arr = new int[3];
 
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
 
		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(arr[1]);
	}
}

다른방법 2)

import java.util.Scanner;
import java.util.Arrays;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int arr[] = {in.nextInt(), in.nextInt(), in.nextInt()};
		in.close();		
        
		Arrays.sort(arr);	//정렬 메소드 (기본이 오름차순이다.)
        
		System.out.println(arr[1]);
	}
}

다른방법 3)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
 
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
 
		if (a >= b) {
			if (a >= c) {
				// a가 가장 크거나 모두 같을 경우
				if (b >= c)
					System.out.println(b);
				else
					System.out.println(c);
			} else
				System.out.println(a);
		} else {
			if (c <= b) { // b가 가장 큰 수일 경우
				if (c <= a)
					System.out.println(a);
				else
					System.out.println(c);
			} else
				System.out.println(b);
		}
	}
}

*/