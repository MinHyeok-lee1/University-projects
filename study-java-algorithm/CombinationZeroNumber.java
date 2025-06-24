package backjoon_basic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombinationZeroNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = (n-m);
		int cnt5 = five_power_n(n) - (five_power_n(t) + five_power_n(m));
		int cnt2 = two_power_n(n) - (two_power_n(t) + two_power_n(m));
		System.out.print(Math.min(cnt5, cnt2));
	}
	
	static int five_power_n(int x) {
		int count = 0;
		
		while(x >= 5) {
			x /= 5;
			count += x;
		}
		return count;
	}
	
	static int two_power_n(int x) {
		int count = 0;
		
		while(x >= 2) {
			x /= 2;
			count += x;
		}
		return count;
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
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
 
		// 각각의 승수를 구해준다.
		long count5 = five_power_n(N) - five_power_n(N - M) - five_power_n(M);
		long count2 = two_power_n(N) - two_power_n(N - M) - two_power_n(M);
		System.out.println(Math.min(count5, count2));
 
	}
 
	// 5의 승수를 구하는 함수
	static long five_power_n(long num) {
		int count = 0;
 
		while (num >= 5) {
			count += (num / 5);
			num /= 5;
		}
		return count;
	}
 
	// 2의 승수를 구하는 함수
	static long two_power_n(long num) {
		int count = 0;
 
		while (num >= 2) {
			count += (num / 2);
			num /= 2;
		}
		return count;
	}
 
}*/