package backjoon_basic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starchopping1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < i; j++) sb.append('*');
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}

/*다른풀이 1)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		br.close();
 
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				bw.write('*');
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}*/