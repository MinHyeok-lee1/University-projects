package backjoon_basic10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = arr[0];
		int max = arr[0];

		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			max = Math.max(max, dp[i]);
		}

		System.out.print(max);
	}

}
/*
다른방법 1) Top-Down
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int[] arr; // 배열
	static Integer[] dp; // 메모이제이션 할 dp
	static int max; // 최댓값 변수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		 *
		 * dp[0]은 첫 원소로 이전에 더이상 탐색할 것이 없기 때문에 arr[0] 자체 값이 되므로 arr[0]으로 초기화 해준다. max또한 첫
		 * 번째 원소로 초기화 해준다.
		 *
		dp[0] = arr[0];
		max = arr[0];
// dp의 마지막 index는 N-1이므로 N-1부터 Top-Down 탐색
		recur(N - 1);
		System.out.println(max);
	}

	static int recur(int N) {
// 탐색하지 않은 인덱스라면
		if (dp[N] == null) {
			dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
// 해당 dp[N]과 max 중 큰 값으로 max 갱신
			max = Math.max(dp[N], max);
		}
		return dp[N];
	}
}
*/