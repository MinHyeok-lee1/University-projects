package backjoon_basic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinomialCoefficient1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int x = 1;
		int y = 1;
		for(int i = 1; i <= K; i++) {
			x *= N--;
			y *= i;
		}
		System.out.print(x/y);
		}
}

/*
다른방법 0) Top-Down
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinomialCoefficient {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dp = new int [N+1][K+1];  
		System.out.print(BC(N,K));
		}

	static int BC(int N, int K) {
		if (dp[N][K] > 0) return dp[N][K];
		if(N == K || K == 0) return dp[N][K] = 1;
		
		return dp[N][K] = BC(N - 1, K - 1) + BC(N - 1, K);
	}
}
다른방법 1) bottom-up
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
 
		int[][] dp = new int[N + 1][K + 1];
 
		// 2번 성질 (n == k)
		for (int i = 0; i <= K; i++) {
			dp[i][i] = 1;
		}
		
		// 2번 성질 (k == 0)
		for(int i = 0; i <= N; i++) {
			dp[i][0] = 1;
		}
		
 
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				// 1번 성질 
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
 
		System.out.println(dp[N][K]);
	}
}

다른방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
 
		// nCk = n! / ((n-k)! * k!)
		System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));
	}
 
	static int factorial(int N) {
		// factorial(0) == 1 이다. 
		if (N <= 1)	{
			return 1;
		}
		return N * factorial(N - 1);
	}
}
*/