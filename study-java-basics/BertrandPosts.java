package backjoon_basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BertrandPosts {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) break;
			int cnt = 0;
			for(int i = x+1; i <= x*2; i++) {
				boolean flag = true;
				for(int j = 2; j <= Math.sqrt(i); j++) {
					if(i % j == 0) {
						flag = false;
						break;
					}
				}if(flag) cnt++;
			}
			sb.append(cnt).append('\n');
		}
		System.out.print(sb);
	}
}

/* 다른풀이 1)
import java.util.Scanner;
 
public class Main {
	
	//n > 123456 이므로 2n 은 최대 246912 이다.
	//0 부터 시작하므로 246912 + 1
	
	public static boolean[] prime = new boolean[246913];
    
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
        
		get_prime();	// 소수를 얻는 메소드 실행
		
		while(true) {
			int n = in.nextInt();
			if(n == 0) break;	// n 이 0 일경우 종료
            
			int count = 0;	// 소수 개수를 셀 변수
            
			for(int i = n + 1; i <= 2 * n; i++) {
				if(!prime[i]) count++;
			}
			System.out.println(count);
		}		
	}
	
	// 소수를 얻는 메소드
	public static void get_prime() {
		// 0 과 1 은 소수가 아니므로 ture
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
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
	
	//n > 123456 이므로 2n 은 최대 246912 이다.
	//0 부터 시작하므로 246912 + 1
	
	public static boolean[] prime = new boolean[246913];
    
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		get_prime();	// 소수를 얻는 메소드 실행
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;	// n 이 0 일경우 종료
            
			int count = 0;	// 소수 개수를 셀 변수
            
			for(int i = n + 1; i <= 2 * n; i++) {
				if(!prime[i]) count++;
			}
			System.out.println(count);
		}		
	}
	
	// 소수를 얻는 메소드
	public static void get_prime() {
		// 0 과 1 은 소수가 아니므로 ture
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
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
	
	//n > 123456 이므로 2n 은 최대 246912 이다.
	//0 부터 시작하므로 246912 + 1
	
	public static boolean[] prime = new boolean[246913];
    
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		get_prime();	// 소수를 얻는 메소드 실행
		
		StringBuilder sb = new StringBuilder();
 
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;	// n 이 0 일경우 종료
            
			int count = 0;	// 소수 개수를 셀 변수
            
			for(int i = n + 1; i <= 2 * n; i++) {
				if(!prime[i]) count++;
			}
			sb.append(count).append('\n');	// 문자열로 이어준다
		}
		System.out.print(sb);
	}
	
	// 소수를 얻는 메소드
	public static void get_prime() {
		// 0 과 1 은 소수가 아니므로 ture
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
 
}

다른풀이 4)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	
//	n > 123456 이므로 2n 은 최대 246912 이다.
//	0 부터 시작하므로 246912 + 1
	
	public static boolean[] prime = new boolean[246913];
 
	//1 부터 누적하여 각 index 까지의 
//	소수의 개수를 담을 배열
	
	public static int[] count_arr = new int[246913];
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		get_prime();	// 소수를 얻는 메소드 실행
		get_count();	// 소수의 개수가 저장된 배열을 얻는 메소드 실행
		StringBuilder sb = new StringBuilder();
 
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;	// n 이 0 일경우 종료
 
			// 2n 까지의 소수의 개수 - n 까지의 소수의 개수
			sb.append(count_arr[2 * n] - count_arr[n]).append('\n');
		}
		System.out.print(sb);
	}
	
	// 소수를 얻는 메소드
	public static void get_prime() {
		// 0 과 1 은 소수가 아니므로 ture
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
    
	// 소수의 개수를 얻는 메소드
	public static void get_count() {
		int count = 0;
		for(int i = 2; i < prime.length; i++) {
			if(!prime[i]) count++;	// 소수일 경우 count를 증가시킨다
            
			
			//0 ~ i 까지 소수의 개수 = count
			//count 값을 count_arr 의 i 에 저장한다
			
			count_arr[i] = count;	
		}
	}
 
 
}
*/