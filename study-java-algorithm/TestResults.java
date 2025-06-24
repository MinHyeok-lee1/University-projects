package backjoon_basic02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestResults {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		br.close();

		StringBuilder sb = new StringBuilder();

		sb.append((A >= 90) ? 'A' : (A >= 80) ? 'B' : (A >= 70) ? 'C' : (A >= 60) ? 'D' : 'F');

		System.out.print(sb);
	}

}

/* 다른방법 1)
import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		in.close();
		
		if(A>=90) System.out.println("A");
		else if(A>=80) System.out.println("B");
		else if (A>=70) System.out.println("C");
		else if(A>=60) System.out.println("D");
		else System.out.println("F");
	}
 
}
*/
