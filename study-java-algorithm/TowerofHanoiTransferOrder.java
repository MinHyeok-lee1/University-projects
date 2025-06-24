package backjoon_basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TowerofHanoiTransferOrder {
    public static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println((int)Math.pow(2, N) - 1);
		hanoi(N,1,2,3);
	}
	
	public static void hanoi(int N, int start, int mid, int to) {

		// 이동할 원반의 수가 1개라면?
		if (N == 1) {
			System.out.print(start + " " + to + "\n");
			return;
		} 
	    
		// STEP 1 : N-1개를 A에서 B로 이동
		hanoi(N - 1, start, to, mid);
	    
		// STEP 2 : 1개를 A에서 C로 이동
		System.out.print(start + " " + to + "\n");
	    
		// STEP 3 : N-1개를 B에서 C로 이동
		hanoi(N - 1, mid, start, to);
	}
}
