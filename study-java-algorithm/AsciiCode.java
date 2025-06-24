package backjoon_basic05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsciiCode {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = br.read();
		
		sb.append(N);
		System.out.println(sb);
	}

}

/*
다른풀이 1)
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int ch = in.next().charAt(0);
        
		System.out.print(ch);
	}
}

다른풀이 2)
public class Main {
	public static void main(String[] args) throws Exception {
 
		int a = System.in.read();
		System.out.print(a);
 
	}
}
*/