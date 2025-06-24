package backjoon_basic02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 변수 한번일 때, int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		br.close();
		
		for (int i = n - 1; i > 0; i--) {
			n += i;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(n);
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
		int sum = 0;
        
		for (int i = 1; i <= a; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}

다른방법 2)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		int N = Integer.parseInt(br.readLine());
		br.close();
		int s = 0;
 
		for( int i = 1 ; i <= N ; i++ ) s+=i;
 
		System.out.println(s);
	}
}

*/
