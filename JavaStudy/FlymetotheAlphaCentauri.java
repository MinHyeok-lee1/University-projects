package backjoon_basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class FlymetotheAlphaCentauri {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 int cnt = 0;
			 int d = y - x;
			 int flag = 1;
			 for(int j = 0; j < d; j+=flag) {
               if(j != 0 && cnt % 2 == 0) flag++;
				 cnt++;
			 }
			 sb.append(cnt).append('\n');
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
        
			int X = in.nextInt();
			int Y = in.nextInt();
			
			int distance = Y - X;	// 거리
			
			int max = (int)Math.sqrt(distance);	// 소수점 버림
            
			if(max == Math.sqrt(distance)) {
				System.out.println(max * 2 - 1);
			}
			else if(distance <= max * max + max) {
				System.out.println(max * 2);
			}
			else {
				System.out.println(max * 2 + 1);
			}
			
		}
	}
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 
		
		for(int i = 0; i < T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			int distance = Y - X;
			
			int max = (int)Math.sqrt(distance);
			
			if(max == Math.sqrt(distance)) {
				sb.append(max * 2 - 1).append('\n');
			}
			else if(distance <= max * max + max) {
				sb.append(max * 2).append('\n');
			}
			else {
				sb.append(max * 2 + 1).append('\n');
			}
			
		}
		System.out.println(sb);
	}
 
}

*/