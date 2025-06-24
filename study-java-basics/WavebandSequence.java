package backjoon_basic09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WavebandSequence {
	public static int [] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
        	int T = Integer.parseInt(br.readLine());
        	arr = new int[T + 1];
    		arr[0] = 0;
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 1;
            arr[4] = 2;
            arr[5] = 2;
        	sb.append(dfs(T)).append('\n');
        }
        System.out.print(sb);
	}

	public static int dfs(int N) {
		if(N >= 6) return dfs(N - 1) + dfs(N - 5);
		else return arr[N];
	}
}

/*다른풀이 1) - 동적계획법과 단순 반복문
import java.util.Scanner;

public class Main {
	public static Long[] seq = new Long[101];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		seq[0] = 0L;
		seq[1] = 1L;
		seq[2] = 1L;
		seq[3] = 1L;
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			System.out.println(padovan(N));
		}
	}

	public static long padovan(int N) {
		if (seq[N] == null) { // 탐색하지 않은 인덱스일 경우 재귀호출
			seq[N] = padovan(N - 2) + padovan(N - 3);
		}
		return seq[N];
	}
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static Long[] seq = new Long[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		seq[0] = 0L;
		seq[1] = 1L;
		seq[2] = 1L;
		seq[3] = 1L;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			sb.append(padovan(Integer.parseInt(br.readLine()))).append('\n');
		}
		System.out.println(sb);
	}

	public static long padovan(int N) {
		if (seq[N] == null) {
			seq[N] = padovan(N - 2) + padovan(N - 3);
		}
		return seq[N];
	}
}

다른풀이 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static long[] seq = new long[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		padovan();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			sb.append(seq[Integer.parseInt(br.readLine())]).append('\n');
		}
		System.out.println(sb);
	}

	public static void padovan() {
		seq[1] = 1;
		seq[2] = 1;
		seq[3] = 1;
		for (int i = 4; i < 101; i++) {
			seq[i] = seq[i - 2] + seq[i - 3];
		}
	}
}
*/