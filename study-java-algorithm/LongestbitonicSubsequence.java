package backjoon_basic09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestbitonicSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		int[] dp = new int[N]; // ( -> 방향 증가수열
		int[] dp1 = new int[N]; // ( <- 방향 증가수열
		
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
		
		for (int i = N - 1; i >= 0; i--) {
			dp1[i] = 1;
			// N - 1 ~ i 이후 원소들 탐색
			for (int j = N - 1; j > i; j--) {
				// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
				if (seq[j] < seq[i] && dp1[i] < dp1[j] + 1) {
					dp1[i] = dp1[j] + 1; // j번째 원소의 +1 값이 i번째 dp가 된다.
				}
			}
		}
		
		// 최댓값(최대 길이) 탐색
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = (dp[i] + dp1[i] - 1) > max ? (dp[i] + dp1[i] - 1) : max;
		}
		System.out.print(max);
	}
}

/*다른풀이 1) TOP-DOWN
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static Integer[] r_dp;
	static Integer[] l_dp;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		r_dp = new Integer[N]; // LIS dp
		l_dp = new Integer[N]; // LDS dp
		seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			LIS(i);
			LDS(i);
		}
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(r_dp[i] + l_dp[i], max);
		}
		System.out.println(max - 1);
	}

	static int LIS(int N) {
// 만약 탐색하지 않던 위치의 경우
		if (r_dp[N] == null) {
			r_dp[N] = 1; // 1로 초기화
// N 이전의 노드들을 탐색
			for (int i = N - 1; i >= 0; i--) {
// 이전의 노드 중 seq[N]의 값보다 작은 걸 발견했을 경우
				if (seq[i] < seq[N]) {
					r_dp[N] = Math.max(r_dp[N], LIS(i) + 1);
				}
			}
		}
		return r_dp[N];
	}

	static int LDS(int N) {
// 만약 탐색하지 않던 위치의 경우
		if (l_dp[N] == null) {
			l_dp[N] = 1; // 1로 초기화
// N 이후의 노드들을 탐색
			for (int i = N + 1; i < l_dp.length; i++) {
// 이후의 노드 중 seq[N]의 값보다 작은 걸 발견했을 경우
				if (seq[i] < seq[N]) {
					l_dp[N] = Math.max(l_dp[N], LDS(i) + 1);
				}
			}
		}
		return l_dp[N];
	}
}

다른풀이 2) Bottom-Up
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] seq;
	static int[] r_dp;
	static int[] l_dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		r_dp = new int[N]; // LIS
		l_dp = new int[N]; // LDS
		seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		LIS();
		LDS();
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (max < r_dp[i] + l_dp[i]) {
				max = r_dp[i] + l_dp[i];
			}
		}
		System.out.println(max - 1);
	}

	static void LIS() {
		for (int i = 0; i < N; i++) {
			r_dp[i] = 1;
// 0 ~ i 이전 원소들 탐색
			for (int j = 0; j < i; j++) {
// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
				if (seq[j] < seq[i] && r_dp[i] < r_dp[j] + 1) {
					r_dp[i] = r_dp[j] + 1; // j번째 원소의 +1 값이 i번째 dp가 된다.
				}
			}
		}
	}

	static void LDS() {
// 뒤에서부터 시작
		for (int i = N - 1; i >= 0; i--) {
			l_dp[i] = 1;
// 맨 뒤에서 i 이전 원소들을 탐색
			for (int j = N - 1; j > i; j--) {
// i번째 원소가 j번째 원소보다 크면서 i번째 dp가 j번째 dp+1 값보다 작은경우
				if (seq[j] < seq[i] && l_dp[i] < l_dp[j] + 1) {
					l_dp[i] = l_dp[j] + 1; // j번쨰 원소의 +1이 i번쨰 dp값이 됨
				}
			}
		}
	}
}
*/