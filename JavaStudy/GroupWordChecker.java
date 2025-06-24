package backjoon_basic05;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class GroupWordChecker {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			String str = br.readLine();	
			char flag = ' ';
			int []arr = new int [26];
			for(int j = 0; j < str.length(); j++) {
				arr[str.charAt(j) - 'a']++;		
				if(arr[str.charAt(j) - 'a'] > 1 && flag != str.charAt(j)) {
					cnt++;
					break;
				}		
				flag = str.charAt(j);
			}
		}
		
		System.out.print(N - cnt);
	}
}

/*
다른풀이 1)
import java.util.Scanner;
 
public class Main {
 
	static Scanner in = new Scanner(System.in);
 
	public static void main(String[] args) {
 
		int count = 0;
		int N = in.nextInt();
 
		for (int i = 0; i < N; i++) {
			if (check() == true) {
				count++;
			}
		}
		System.out.println(count);
	}
 
	public static boolean check() {
		boolean[] check = new boolean[26];
		int prev = 0;
		String str = in.next();
		
		for(int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);	// i 번째 문자 저장 (현재 문자)
			
			
			// 앞선 문자와 i 번째 문자가 같지 않다면?
			if (prev != now) {		
				
				// 해당 문자가 처음 나오는 경우 (false 인 경우)
				if ( check[now - 'a'] == false ) {
					check[now - 'a'] = true;		// true 로 바꿔준다
					prev = now;					// 다음 턴을 위해 prev 도 바꿔준다 
				}
	 
				// 해당 문자가 이미 나온 적이 있는 경우 (그룹단어가 아니게 됨) 
				else {
					return false;	//함수 종료
				}
			}
	        
	        
			// 앞선 문자와 i 번째 문자가 같다면? (연속된 문자)
			// else 문은 없어도 됨
			else {
				continue;
			}
		}    
		return true;
	}
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
	public static void main(String[] args) throws IOException {
 
		int count = 0;
		int N = Integer.parseInt(br.readLine());
 
		for (int i = 0; i < N; i++) {
			if (check()) {
				count++;
			}
		}
		System.out.print(count);
	}
 
	public static boolean check() throws IOException {
		boolean[] check = new boolean[26];
		int prev = 0;
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);
			
			
			if (prev != now) {		
				if (!check[now - 'a']) {
					check[now - 'a'] = true;
					prev = now;	
				}
				else {
					return false;	
				}
			}
		}    
		return true;
	}
}

*/
