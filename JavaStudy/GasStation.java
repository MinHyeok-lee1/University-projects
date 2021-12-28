package backjoon_basic12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasStation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long []way = new long [N];
		long []gas = new long [N+1];
		long min = 0, mgas = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N; i++) {
			way[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N + 1; i++) {
			gas[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N; i++) {
			if(i == 1) {
				min = gas[i]*way[i];
				mgas = gas[i];
			}
			else {
				if(mgas <= gas[i]) {
					min += mgas*way[i];
				}else {
					min += gas[i]*way[i];
					mgas = gas[i];
				}
			}
		}
		
		System.out.print(min);
	}
}

/*다른풀이 1)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dist = new long[N - 1];	// 거리
		long[] cost = new long[N];	// 비용 
		
		// 거리 입력 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N - 1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		// 리터당 기름값 입력
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		
		long sum = 0;
		long minCost = cost[0];	// 이전 까지의 과정 중 주유 최소 비용 
 
		for(int i = 0; i < N - 1; i++) {
			
			
			 *  현재 주유소가 이전 주유소의 기름값보다 쌀 경우
			 *  minCost를 갱신해준다. 
			 
			if(cost[i] < minCost) {
				minCost = cost[i];
			}
			
			sum += (minCost * dist[i]);
		}
		
		System.out.println(sum);
		
	}
}
*/