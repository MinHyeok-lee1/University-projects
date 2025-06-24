package backjoon_basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachGuess {
	public static boolean[] prime;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		prime = new boolean[10001];
		int T = Integer.parseInt(br.readLine());
		get_prime();
		
		for (int i = 0; i < T; i++) {
			int p = Integer.parseInt(br.readLine());
			boolean flag = false;
			for (int j = 2; j < p; j++) {
				if (!prime[j]) {
					for (int x = 2; x <= j; x++) {
						if (!prime[x] && j + x == p) {
							sb.append(x + " " + j).append('\n');
							flag = true;
							break;
						}
					}
				}
				if(flag) break;
			}
		}
		System.out.print(sb);
	}

	// 에라토스테네스 체 알고리즘
	public static void get_prime() {
		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue; // 이미 체크된 배열일 경우 skip
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

	}
}

/* 다른풀이 1)
import java.util.Scanner;

public class Main {
 
	//	false : 소수
	//	range : 0 ~ 10000
	
	public static boolean[] prime = new boolean[10001];
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		
		get_prime();
 
		int T = in.nextInt();	// 테스트케이스
 
		while (T-- > 0) {
			int n = in.nextInt();
			int first_partition = n / 2;
			int second_partition = n / 2;
 
			while (true) {
            
				// 두 파티션이 모두 소수일 경우
				if (!prime[first_partition] && !prime[second_partition]) {
					System.out.println(first_partition + " " + second_partition);
					break;
				}
				first_partition--;
				second_partition++;
			}
		}
 
	}
 
	// 에라토스테네스의 체
	public static void get_prime() {
		prime[0] = prime[1] = true;
 
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
 
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
//		false : 소수
	//	range : 0 ~ 10000
	
	public static boolean[] prime = new boolean[10001];
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		get_prime();
 
		int T = Integer.parseInt(br.readLine());	// 테스트케이스
 
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int first_partition = n / 2;
			int second_partition = n / 2;
 
			while (true) {
            
				// 두 파티션이 모두 소수일 경우
				if (!prime[first_partition] && !prime[second_partition]) {
					System.out.println(first_partition + " " + second_partition);
					break;
				}
				first_partition--;
				second_partition++;
			}
		}
 
	}
 
	// 에라토스테네스의 체
	public static void get_prime() {
		prime[0] = prime[1] = true;
 
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
 
}

다른풀이 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
//		false : 소수
//		range : 0 ~ 10000
	
	public static boolean[] prime = new boolean[10001];
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		get_prime();
 
		int T = Integer.parseInt(br.readLine());	// 테스트케이스
 
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int first_partition = n / 2;
			int second_partition = n / 2;
 
			while (true) {
            
				// 두 파티션이 모두 소수일 경우
				if (!prime[first_partition] && !prime[second_partition]) {
					sb.append(first_partition).append(' ').append(second_partition).append('\n');
					break;
				}
				first_partition--;
				second_partition++;
			}
		}
		System.out.print(sb);
	}
 
	// 에라토스테네스의 체
	public static void get_prime() {
		prime[0] = prime[1] = true;
 
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
 
}

*/