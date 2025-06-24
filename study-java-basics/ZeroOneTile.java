package backjoon_basic09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroOneTile {

	public static int[] arr;
	public static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dfs(N, 0);
		System.out.print(cnt);
	}

	public static void dfs(int N, int depth) {
		if (depth == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < 2; i++) {
			if (depth < N - 1 && i == 0) {
				arr[depth] = 0;
				arr[depth + 1] = 0;
				dfs(N, depth + 2);
			} else {
				i++;
				arr[depth] = 1;
				dfs(N, depth + 1);
			}
		}
	}
}

/*다른풀이 1)
import java.util.Scanner;

public class Main {
	public static int[] dp = new int[1000001];;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
// -1 로 초기화
		for (int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(Tile(N));
	}

public static int Tile(int N) {
        if(dp[N] == -1) {
           dp[N] = (Tile(N - 1) + Tile((N - 2))) % 15746;
        }
        return dp[N];
   }
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static int[] dp = new int[1000001];;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
// -1 로 초기화
		for (int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(Tile(N));
	}

	public static int Tile(int N) {
		if (dp[N] == -1) {
			dp[N] = (Tile(N - 1) + Tile((N - 2))) % 15746;
		}
		return dp[N];
	}
}

다른풀이 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(Tile(N));
	}

	public static int Tile(int a) {
		if (a == 1) {
			return 1;
		}
		if (a == 2) {
			return 2;
		}
// 초기 값
		int val1 = 1;
		int val2 = 2;
		int sum = 0;
		for (int i = 2; i < a; i++) {
			sum = (val2 + val1) % 15746; // 이전 값과 이전의 이전 값의 합
			val1 = val2; // 이전의 이전 값은 이전 값으로 변경
			val2 = sum; // 이전 값은 현재 합 값으로 변경
		}
		return sum;
	}
}
*/