package backjoon_basic09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ElectricWire {

	static int[] ElecL;
	static int[] ElecR;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ElecL = new int[N + 1];
		ElecR = new int[N + 1];
		int[] dp = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ElecL[i] = Integer.parseInt(st.nextToken());
			ElecR[i] = Integer.parseInt(st.nextToken());
		}
		
	
	    for(int i = 1; i <= N; i++) {
	    	for(int j = 1; j < i; j++) {
	    		if(Overlap(i, j)) dp[i] = dp[j] + 1;
	    	}
	    }
	    
	    // 최댓값(최대 길이) 탐색
	      int max = -1;
	      for (int i = 1; i <= N; i++) {
	         max = dp[i] > max ? dp[i] : max;
	      }
	      System.out.print(N - max);
	}
	
	static boolean Overlap(int i, int x) {
		if(ElecL[i] > ElecR[i]) {
    		for(int j = ElecR[i]; j < ElecL[i]; j++) {
    		     if(ElecR[x] == j) return false;
    		     else if(ElecL[x] == j) return false;
    		}
    	}else {
    		for(int j = ElecL[i]; j < ElecR[i]; j++) {
    		     if(ElecR[x] == j) return false;
    		     else if(ElecL[x] == j) return false;
    		}
    	}
		return true;
	}

}

/*
다른풀이 1) Top-Down
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static Integer[] dp;
	static int[][] wire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N];
		wire = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
// 첫 번째 원소(A전봇대)를 기준으로 오름차순으로 정
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int max = 0;
		 *
		 * i번째 A전봇를 기준으로 연결가능한 개수 탐색 및 최댓값 찾기
		 *
		for (int i = 0; i < N; i++) {
			max = Math.max(recur(i), max);
		}
// 전선 개수 - 쵀댓값
		System.out.println(N - max);
	}

	static int recur(int N) {
// 탐색하지 않았던 위치라면
		if (dp[N] == null) {
			dp[N] = 1; // 최솟값 1로 초기화
// A의 N번째와 이후의 전봇대들 비교
			for (int i = N + 1; i < dp.length; i++) {
				 *
				 * A전봇대의 N번째 전선이 연결되어있는 B전봇대보다 A의 i번째 전봇대의 전선이 이어진 B전봇대가 뒤에 있을 경우 전선을 설치할 수 있음
				 *
				if (wire[N][1] < wire[i][1]) {
// 연결 가능한 전선의 경우의 수 중 큰 값을 dp에 저장한다.
					dp[N] = Math.max(dp[N], recur(i) + 1);
				}
			}
		}
		return dp[N];
	}
}

다른풀이 2) Bottom-up
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		int[][] wire = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < wire.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
// A전봇대를 기준으로 정렬
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1; // 최소 개수인 1로 초기화
			 *
			 * i번째 전봇대를 기준으로 이전의 전봇대들의 전선을 연결하기 위한 탐색 즉, i번째 전봇대에 연결된 B전봇대는 탐색할 j번째 전봇대에 연결된
			 * B전봇대보다 값이 커야함
			 *
			for (int j = 0; j < i; j++) {
				if (wire[i][1] > wire[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
// 전체 개수 - 설치 가능한 전깃줄 = 최소 철거 개수
		System.out.println(N - max);
	}
}
*/