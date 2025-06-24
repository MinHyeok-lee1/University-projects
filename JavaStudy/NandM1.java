package backjoon_basic08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class NandM1 {
	
	public static boolean [] visit;
	public static int [] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int [M];
		visit = new boolean [N];
		dfs(N ,M, 0);
		System.out.print(sb);
	}
	
	public static void dfs(int N, int M, int depth) {
		if(depth == M) {
			for(int x : arr) {
				sb.append(x).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(N, M, depth+1);	
				visit[i] = false;
			}
		}
	}
}
/*
다른방법 1)
import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static boolean[] visit;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		arr = new int[M];
		visit = new boolean[N];
		dfs(N, M, 0);
	}

	public static void dfs(int N, int M, int depth) {
		if (depth == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(N, M, depth + 1);
				visit[i] = false;
			}
		}
	}
}

다른방법 2)
import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder(); // 정적타입으로 해주어야한다.

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		arr = new int[M];
		visit = new boolean[N];
		dfs(N, M, 0);
// 마지막에 한 번에 출력
		System.out.println(sb);
	}

	public static void dfs(int N, int M, int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(N, M, depth + 1);
				visit[i] = false;
			}
		}
	}
}

다른방법 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N];
		dfs(N, M, 0);
		System.out.println(sb);
	}

	public static void dfs(int N, int M, int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(N, M, depth + 1);
				visit[i] = false;
			}
		}
	}
}

다른방법 4)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static int N; // 정적변수로 변경
	public static int M; // 정적변수로 변경
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
// 정적변수 N과 M을 초기화해준다.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N];
// 정적변수를 쓰면 되기 때문에 굳이 N과 M을 넘겨줄 필요 없다.
		dfs(0);
		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
}
*/