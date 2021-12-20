package backjoon_basic09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonaciiFunction {

	public static Integer[] arr;
	public static StringBuilder sb = new StringBuilder();
    public static int cnt0;
    public static int cnt1;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		arr = new Integer[T + 1];
		arr[0] = 0;
		arr[1] = 1;
		cnt0 = 0;
		cnt1 = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			FiboF(Integer.parseInt(br.readLine()));
			sb.append(cnt0).append(' ').append(cnt1).append('\n');
			cnt0 = 0;
			cnt1 = 0;
		}
		System.out.println(sb);
	}

	public static int FiboF(int N) {
		if (N == 0) {
			cnt0++;
			return 0;
		} else if (N == 1) {
			cnt1++;
			return 1;
		} else
			return FiboF(N - 2) + FiboF(N - 1);
	}
}
/*
다른풀이 1)
import java.util.Scanner;

public class Main {
	static Integer[][] dp = new Integer[41][2];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		dp[0][0] = 1; // N=0 일 때의 0 호출 횟수
		dp[0][1] = 0; // N=0 일 때의 1 호출 횟수
		dp[1][0] = 0; // N=1 일 때의 0 호출 횟수
		dp[1][1] = 1; // N=1 일 때의 1 호출 횟수
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			fibonacci(N);
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	}

	static Integer[] fibonacci(int N) {
// N에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 때)
		if (dp[N][0] == null || dp[N][1] == null) {
// 각 N에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출한다.
			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
// N에 대한 0과 1, 즉 [N][0]과 [N][1] 을 담고있는 [N]을 반환한다.
		return dp[N];
	}
}

다른풀이 2)
import java.util.Scanner;

public class Main {
	static Integer[][] dp = new Integer[41][2];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		dp[0][0] = 1; // N=0 일 때의 0 호출 횟수
		dp[0][1] = 0; // N=0 일 때의 1 호출 횟수
		dp[1][0] = 0; // N=1 일 때의 0 호출 횟수
		dp[1][1] = 1; // N=1 일 때의 1 호출 횟수
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = in.nextInt();
			fibonacci(N);
			sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
		}
		System.out.print(sb);
	}

	static Integer[] fibonacci(int N) {
// N에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 때)
		if (dp[N][0] == null || dp[N][1] == null) {
// 각 N에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출한다.
			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
// N에 대한 0과 1, 즉 [N][0]과 [N][1] 을 담고있는 [N]을 반환한다.
		return dp[N];
	}
}

다른방법 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static Integer[][] dp = new Integer[41][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp[0][0] = 1; // N=0 일 때의 0 호출 횟수
		dp[0][1] = 0; // N=0 일 때의 1 호출 횟수
		dp[1][0] = 0; // N=1 일 때의 0 호출 횟수
		dp[1][1] = 1; // N=1 일 때의 1 호출 횟수
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
		}
		System.out.println(sb);
	}

	static Integer[] fibonacci(int N) {
// N에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 때)
		if (dp[N][0] == null || dp[N][1] == null) {
// 각 N에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출한다.
			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
// N에 대한 0과 1, 즉 [N][0]과 [N][1] 을 담고있는 [N]을 반환한다.
		return dp[N];
	}
}

다른방법 4)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int zero;
	static int one;
	static int zero_plus_one;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(zero).append(' ').append(one).append('\n');
		}
		System.out.println(sb);
	}

	public static void fibonacci(int N) {
// 반드시 초기화 해야한다.
		zero = 1;
		one = 0;
		zero_plus_one = 1;
		for (int i = 0; i < N; i++) {
			zero = one;
			one = zero_plus_one;
			zero_plus_one = zero + one;
		}
	}
}
*/