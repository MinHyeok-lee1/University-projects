package backjoon_basic08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM3 {

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
				arr[depth] = i+1;
				dfs(N, M, depth+1);	
		}
	}

}
/*
다른방법 1)
import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		arr = new int[M];
		dfs(0);
		System.out.print(sb);
	}

	public static void dfs(int depth) {
// 깊이가 M이랑 같아지면 출력후 return
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1);
		}
	}
}

다른방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		dfs(0);
		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1);
		}
	}
}
*/