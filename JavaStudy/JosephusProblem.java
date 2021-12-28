package backjoon_basic12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class JosephusProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		sb.append('<');
		
		while(q.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				int val = q.poll();
				q.offer(val);
			}
			sb.append(q.poll()).append(", ");
		}
		
		sb.append(q.poll()).append('>');

		System.out.print(sb);
	}

}

/*
첫 풀이 1)- 타임아웃
package backjoon_basic12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JosephusProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] jos = new int[N];
		int cnt = 1;
        int save = 1;
		for (int i = 0; i < N; i++) {
			for (int j = save; j <= N; j++) {
				boolean flag = true;
				for (int x : jos) {
					if (x == j) {
						flag = false;
						break;
					}
				}
				if (flag == false) {
					if (j == N) j = 0;
					continue;
				}
				if (cnt == K) {
					jos[i] = j;
					cnt = 1;
					save = j;
					break;
				}

				if (j == N) j = 0;
				cnt++;
			}
		}

		sb.append('<');
		for (int i = 0; i < N; i++) {
			if (i == N - 1)
				sb.append(jos[i]);
			else
				sb.append(jos[i]).append(", ");
		}
		sb.append('>');
		System.out.print(sb);
	}

}
*/