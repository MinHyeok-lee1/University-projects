package backjoon_basic09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			// 0 ~ i 이전 원소들 탐색
			for (int j = 0; j < i; j++) {
				// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
				if (seq[j] < seq[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1; // j번째 원소의 +1 값이 i번째 dp가 된다.
				}
			}
		}
		// 최댓값(최대 길이) 탐색
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		System.out.println(max);
	}

}

/*
다른풀이 Top-Down)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int[] seq;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		seq = new int[N];
		dp = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
// 0 ~ N-1 까지 탐색
		for (int i = 0; i < N; i++) {
			LIS(i);
		}
		int max = dp[0];
// 최댓값 찾기
		for (int i = 1; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	static int LIS(int N) {
// 만약 탐색하지 않던 위치의 경우
		if (dp[N] == null) {
			dp[N] = 1; // 1로 초기화
// N-1 부터 0까지중 N보다 작은 값들을 찾으면서 재귀호출.
			for (int i = N - 1; i >= 0; i--) {
				if (seq[i] < seq[N]) {
					dp[N] = Math.max(dp[N], LIS(i) + 1);
				}
			}
		}
		return dp[N];
	}
}
*/