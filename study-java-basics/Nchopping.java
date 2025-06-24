package backjoon_basic02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nchopping {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();				
		for(int i = 1; i <= N; i++) sb.append(i).append('\n');
		
		System.out.print(sb);
	}

}


/* 다른방법 1)

import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		in.close();
        
		int i = 1;
        
		while(i<= N) {
			System.out.println(i);
			i++;
		}
	}
}

다른방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int N = Integer.parseInt(br.readLine());
		br.close();
        
		int i = 1;
        
		while(i<= N) {
			bw.write(i+"\n");
			i++;
		}
		bw.flush();
		bw.close();
	}
}

*/
