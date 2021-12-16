package backjoon_basic05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumNumber {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//int N = Integer.parseInt(br.readLine());
		int sum = 0;
		/*String str = br.readLine();
		for (int i = 0; i < N; i++) {
			sum += (str.charAt(i) - '0');
		}*/
		for(byte value : br.readLine().getBytes()) {
			sum += (value - '0');
		}
		sb.append(sum);
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
		String a = in.next();
		in.close();
		
		int sum = 0;
        
		for(int i = 0; i < N; i++) {
			sum += a.charAt(i)-'0';
		}
		System.out.print(sum);
	}
}

다른방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {		
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();	// N 은 쓸모가 없으므로 입력만 받는다.
		
		int sum = 0;
		
		for(byte value : br.readLine().getBytes()) {
			sum += (value - '0');	// 또는 (a-48)
		}
		
		System.out.print(sum);
		
	}
}
*/