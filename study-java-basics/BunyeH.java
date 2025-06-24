package backjoon_basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BunyeH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int [][]arr = new int [14][14];
		int cnt = 1;
		int pre = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
			for(int j = 0; j < arr.length; j++) {
				arr[i][j] = pre + cnt;
				pre = arr[i][j];
				cnt++;
			  }
			} else {
				for(int j = 0; j < arr.length; j++) {
					if(j == 0) {
						arr[i][j] = 1;
					}else arr[i][j] = arr[i-1][j] + arr[i][j-1];
				  }
			}
		}
		
		/*for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}*/
		for(int i = 0; i < T; i++) {
			sb.append(arr[Integer.parseInt(br.readLine()) - 1][Integer.parseInt(br.readLine()) - 1]).append('\n');
		}
		System.out.print(sb);
	}

}

/* 다른풀이 1)
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		// 아파트 생성 
		int[][] APT = new int[15][15];
 
		for(int i = 0; i < 15; i++) {
			APT[i][1] = 1;	// i층 1호
			APT[0][i] = i;	// 0층 i호
		}
 
 
		for(int i = 1; i < 15; i ++) {	// 1층부터 14층까지
 
			for(int j = 2; j < 15; j++) {	// 2호부터 14호까지
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}
		
		// 테스트 부분 		
		int T = in.nextInt();
		
		for(int i = 0; i < T; i++) {
			int k = in.nextInt();
			int n = in.nextInt();
			System.out.println(APT[k][n]);
		}
	}
 
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static int[][] APT = new int[15][15];
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		make_APT();	// 아파트 만들기 
		
		int T = Integer.parseInt(br.readLine());
 
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(APT[k][n]).append('\n');
		}
		System.out.println(sb);
	}
 
	
	public static void make_APT() {
		// 아파트 생성
 
		for (int i = 0; i < 15; i++) {
			APT[i][1] = 1; // i층 1호
			APT[0][i] = i; // 0층 i호
		}
 
		for (int i = 1; i < 15; i++) { // 1층부터 14층까지
 
			for (int j = 2; j < 15; j++) { // 2호부터 14호까지
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}
	}
 
}

*/