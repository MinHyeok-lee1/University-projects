package backjoon_basic09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting {
	
	 public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int N = Integer.parseInt(br.readLine());
	      int [] arr = new int [N];
	      int [] dp = new int[N];
	      for(int i = 0; i < N; i++) {
	         arr[i] = Integer.parseInt(br.readLine());
	      }
	      
	      dp[0] = arr[0];
	      dp[1] = arr[0] + arr[1];
	      dp[2] = Math.max(arr[0] + arr[2], Math.max(arr[0] + arr[2], dp[1]));
	      for(int i = 3; i < N; i++) {
	         dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i]);
	      }
	      
	      System.out.print(dp[N - 1]);
	   }

}

/*
다른풀이 Top-Down)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static Integer[] dp;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1];
		arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
		dp[1] = arr[1];
		
		if (N > 1) {
			dp[2] = arr[1] + arr[2];
		}
		System.out.println(recur(N));
	}

	static int recur(int N) {
		if (dp[N] == null) {
			dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + arr[N - 1]) + arr[N], recur(N - 1));
		}
		return dp[N];
	}
}

다른풀이 Bottom-up
package backjoon_basic9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int [] arr = new int [N + 1];
		int [] dp = new int[N + 1];
		for(int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		if(N > 1) dp[2] = arr[1] + arr[2];
		
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
		}
		
		System.out.print(dp[N]);
	}
}
*/