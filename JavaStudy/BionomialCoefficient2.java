package backjoon_basic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BionomialCoefficient2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int x = 1;
		int y = 1;
		for (int i = 1; i <= K; i++) {
			x *= N--;
			y *= i;
		}
		System.out.print((x/y)%10007);
	}

}
