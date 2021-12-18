package backjoon_basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int [] arr = new int [N];
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			arr[i] = x;
		}
		Arrays.sort(arr);
		for(int x : arr) sb.append(x).append('\n');
		
		System.out.print(sb);
	}
}


/*다른방법 1)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
// select sort
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		for (int val : arr) {
			sb.append(val).append('\n');
		}
		System.out.println(sb);
	}
}

다른방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		 * range : -1000 ~ 1000 0 은 index[1000] 을 의미
		 
		boolean[] arr = new boolean[2001];
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000] = true;
		}
// 정렬 과정이 따로 필요 없음
		for (int i = 0; i < 2001; i++) {
			if (arr[i]) {
				sb.append(i - 1000).append('\n');
			}
		}
		System.out.println(sb);
	}
}*/
