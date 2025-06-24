package backjoon_basic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Card2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0, ans = 0;
		int x = 2;
		boolean flag = true;
		if (N == 1) {
			System.out.println(1);
			System.exit(0);
		}else if (N == 2 || N == 3) {
			System.out.println(2);
			System.exit(0);
		}
		
		while (true) {
			for (int i = x; i <= N; i *= x) {
				if (flag == true) {
					flag = false;
					cnt++;
				} else {
					flag = true;
					ans = i;
				}
			}
			if (cnt == 1) {
				System.out.println(ans);
				break;
			}
			x *= 2;
		}
	}
}


/*
다른풀이 1)
import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		**
		 *  한 턴에 1개 씩 삭제되고 뒤에 1개가 추가 되므로
		 *  2 * N - 1 의 공간이 필요하다.
		 *  다만 index는 1부터 시작할 것이기 때문에
		 *  2 * N 공간으로 생성한다.   
		 *
		int[] q = new int[2 * N];	  
		for(int i = 1; i <= N; i++) {
			q[i] = i;
		}
		int prev_index = 1;
		int last_index = N;
		
		while(N-- > 1) {
			prev_index++;
			q[last_index + 1] = q[prev_index];
			last_index++;
			prev_index++;
		}
 
		System.out.println(q[prev_index]);
	}
 
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		**
		 *  한 턴에 1개 씩 삭제되고 뒤에 1개가 추가 되므로
		 *  2 * N - 1 의 공간이 필요하다.
		 *  다만 index는 1부터 시작할 것이기 때문에
		 *  2 * N 공간으로 생성한다.   
		 *
		int[] q = new int[2 * N];	  
		for(int i = 1; i <= N; i++) {
			q[i] = i;
		}
		int prev_index = 1;
		int last_index = N;
		
		while(N-- > 1) {
			prev_index++;
			q[last_index + 1] = q[prev_index];
			last_index++;
			prev_index++;
		}
 
		System.out.println(q[prev_index]);
	}
 
}
*/