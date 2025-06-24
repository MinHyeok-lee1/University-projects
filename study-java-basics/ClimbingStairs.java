package backjoon_basic09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] Stairs = new int[N + 1];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			Stairs[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = Stairs[1];
		if (N >= 2)
			dp[2] = Stairs[1] + Stairs[2];

		for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + Stairs[i-1]) + Stairs[i];
		}

		System.out.print(dp[N]);
	}

}

/*다른방법 1)
import java.util.Scanner;

public class Main {
	static Integer dp[];
	static int arr[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		dp = new Integer[N + 1];
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = in.nextInt();
		}
		dp[0] = arr[0]; // 디폴트값이 null이므로 0으로 초기화 해주어야한다.
		dp[1] = arr[1];
		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		System.out.println(find(N));
	}

	static int find(int N) {
// 아직 탐색하지 않는 N번째 계단일 경우
		if (dp[N] == null) {
			dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
		}
		return dp[N];
	}
}

다른방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static Integer dp[];
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1];
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = arr[0]; // 디폴트값이 null이므로 0으로 초기화 해주어야한다.
		dp[1] = arr[1];
		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		System.out.println(find(N));
	}

	static int find(int N) {
// 아직 탐색하지 않는 N번째 계단일 경우
		if (dp[N] == null) {
			dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
		}
		return dp[N];
	}
}

다른방법 3)
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] DP = new int[N + 1];
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = in.nextInt();
		}
// index = 0 은 시작점이므로 0이다.
		DP[1] = arr[1];
// N 이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다.
		if (N >= 2) {
			DP[2] = arr[1] + arr[2];
		}
		for (int i = 3; i <= N; i++) {
			DP[i] = Math.max(DP[i - 2], DP[i - 3] + arr[i - 1]) + arr[i];
		}
		System.out.println(DP[N]);
	}
}

다른방법 4)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N + 1];
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
// index = 0 은 시작점이다.
		DP[1] = arr[1];
// N 이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다.
		if (N >= 2) {
			DP[2] = arr[1] + arr[2];
		}
		for (int i = 3; i <= N; i++) {
			DP[i] = Math.max(DP[i - 2], DP[i - 3] + arr[i - 1]) + arr[i];
		}
		System.out.println(DP[N]);
	}
}
*/