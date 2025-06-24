package backjoon_basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindPrimenumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			boolean flag = true;
			if(x == 1) flag = false;
			for (int j = 2; j <= Math.sqrt(x); j++) {
				if (x % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) cnt++;
		}

		System.out.print(cnt);
	}

}

/* 다른풀이 1)
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			
			// 소수인경우 true, 아닌경우 false   
			boolean isPrime = true;
			
			int num = in.nextInt();
			
			if(num == 1) {	// 1 인경우 다음 반복문으로
				continue;
			}
			for(int j = 2; j <= Math.sqrt(num); j++) {
				if(num % j == 0) {
					isPrime = false;	// 소수가 아니므로 false 로 바꿔줌
					break;
				}
			}
			if(isPrime) {	// 소수인경우 count 값 1 증가
				count++;
			}
		}
		System.out.println(count);
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
		
		br.readLine();	// N 은 쓰지 않음.	
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		while(st.hasMoreTokens()) {
        
			// 소수인경우 true, 아닌경우 false   
			boolean isPrime = true;
			
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 1) {
				continue;
			}
			for(int i = 2; i <= Math.sqrt(num); i++) {
				if(num % i == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				count++;
			}
		}
		System.out.println(count);
	}
 
}

 * 다른 문제 (1 ~ N)까지 소수탐색
// 1 ~ Max 범위
 
// 소수인 수 = false
// 소수가 아닌 수 = true
 
public boolean[] make_prime(int Max) {
 
	boolean[] Prime = new boolean[Max + 1];	// 0 부터 시작하므로 +1
 
	//0 과 1 은 소수가 아니므로 true
	Prime[0] = true;
	Prime[1] = true;
    
    
	for(int i = 2; i <= Math.sqrt(Max); i++) {
 
		//이미 걸러진 배열일 경우 다음 반복문으로 건너뜀
		if(Prime[i] == true) {
			continue;
		}
		
		//정석대로라면 j = i * 2 부터 시작이지만 
		//이미 2의 배수가 걸러졌기때문에
		//i 의 제곱수부터 시작해도 된다.
	    
		for(int j = i * i; j < Max + 1; j = j + i) {
			Prime[j] = true;
		}
	}
 
	//배열 index 가 소수라면 false 로, 아니라면 true 로 완성됨
    
	return Prime;
}

*/