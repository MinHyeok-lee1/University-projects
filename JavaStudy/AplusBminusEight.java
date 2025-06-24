package backjoon_basic03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AplusBminusEight {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int A, B;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			sb.append("Case #").append(i + 1).append(": ").append(A)
			.append(" + ").append(B).append(" = ").append(A + B).append('\n');
		}
		System.out.print(sb);
	}

}


/* 다른방법 1)
import java.util.Scanner;
 
public class Main {
	public static void main(String args[]) {
 
		Scanner in = new Scanner(System.in);
 
		int T = in.nextInt();
 
		for (int i = 1; i <= T; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
 
			System.out.println("Case #" + i + ": " + A + " + " + B + " = " + (A+B));
		}
 
		in.close();
	}
}

다른방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
 
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int A;
		int B;
        
		StringTokenizer st;
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine()," ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			System.out.println("Case #" + i + ": " + A + " + " + B + " = " + (A+B));
		}
		br.close();
	}
 
}

다른 방법 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
 
public class Main {
	public static void main(String args[]) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int A;
		int B;
 
		StringTokenizer st;
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine()," ");
 
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
            
			bw.write("Case #"+i+": ");
			bw.write(A + " + " + B + " = ");
			bw.write((A+B) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
 
}


다른 방법 4)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
 
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
 
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			String str = br.readLine();
			int A = str.charAt(0)-'0'; // '0' = 48
			int B = str.charAt(2)-'0';
			sb.append("Case #").append(i).append(": ").append(A)
			.append(" + ").append(B).append(" = ").append(A+B).append('\n');
		}
		System.out.println(sb);
	}
}

*/


