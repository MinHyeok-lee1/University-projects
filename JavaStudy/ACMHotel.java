package backjoon_basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACMHotel {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // 호텔의 층
			st.nextToken();
			//int W = Integer.parseInt(st.nextToken()); // 각 층의 방 수
			int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님

			int x,y;
			if(N % H == 0) {
				x = N / H;
				y = H * 100;
			}
			else {
				x = (N / H) + 1;
				y = (N % H) * 100;
			}
			sb.append(y + x).append('\n');
		}
		System.out.print(sb);
	}

}

/* 다른풀이 1)
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
 
		int T = in.nextInt();	// 테스트 케이스
 
 
		for(int i = 0; i < T; i++) {
			
			int H = in.nextInt();
			int W = in.nextInt(); 	// 쓸모없는 변수다.
			int N = in.nextInt();
			
			if(N % H == 0) {
				System.out.println((H * 100) + (N / H));
 
			} else {
				System.out.println(((N % H) * 100) + ((N / H) + 1));
			}
		}
	}
}

다른풀이 2)
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스
 
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
			int H = Integer.parseInt(st.nextToken());
			st.nextToken();			// W 는 그냥 버린다.
			int N = Integer.parseInt(st.nextToken());
 
			if (N % H == 0) {
				sb.append((H * 100) + (N / H)).append('\n');
 
			} else {
				sb.append(((N % H) * 100) + ((N / H) + 1)).append('\n');
			}
		}
		System.out.print(sb);
 
	}
}

*/