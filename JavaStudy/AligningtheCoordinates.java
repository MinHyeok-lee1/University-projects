package backjoon_basic08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AligningtheCoordinates {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (e1, e2) -> {
			if (e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		System.out.print(sb);
	}

}

/*다른풀이 1)
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		Arrays.sort(arr, (e1, e2) -> {
			if (e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}

다른풀이 2)
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		Arrays.sort(arr, (e1, e2) -> {
			if (e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}
}}*/
