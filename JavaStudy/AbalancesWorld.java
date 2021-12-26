package backjoon_basic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbalancesWorld {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[100];
        while(true) {
		int size = 0;
		String str = br.readLine();
		if(str.equals(".")) System.exit(0);
		
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == ')') {
				if (size <= 0) {
					System.out.println("NO");
					size = -1;
					break;
				} else {
					if(arr[size - 1] == 1) {
					arr[size - 1] = 0;
					size--;
					}else {
						System.out.println("NO");
						size = -1;
						break;
					}
				}
			}
			if (str.charAt(j) == '(') {
				arr[size] = 1;
				size++;
			}
			
			if (str.charAt(j) == ']') {
				if (size <= 0) {
					System.out.println("NO");
					size = -1;
					break;
				} else {
					if(arr[size - 1] == 2) {
						arr[size - 1] = 0;
						size--;
						}else {
							System.out.println("NO");
							size = -1;
							break;
						}
				}
			}
			if (str.charAt(j) == '[') {
				arr[size] = 2;
				size++;
			}
		}
		if (size == 0)
			System.out.println("YES");
		else if (size > 0)
			System.out.println("NO");
        }
	}

}
/*
다른풀이 1) 스택
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		String s;
		
		while(true) {
			
			s = br.readLine();
			
			if(s.equals(".")) {	// 종료 조건문 
				break;
			}
			
			sb.append(solve(s)).append('\n');
		}
		
		System.out.println(sb);
		
		
	}
	
	public static String solve(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);	// i 번째 문자 
			
			// 여는 괄호일 경우 스택에 push 
			if(c == '(' || c == '[') {
				stack.push(c);
			}
			
			// 닫는 소괄호 일 경우 
			else if(c == ')') {
				
				// 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
			else if(c == ']') {
				
				// 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
			// 그 외의 경우에는 불필요한 문자들이기에 skip한다. 
		}
		
		if(stack.empty()) {
			return "yes";
		}
		else {
			return "no";
		}
	}
 
}

다른풀이2) char[]
		import java.io.BufferedReader;
		import java.io.InputStreamReader;
		import java.io.IOException;
		 
		public class Main {
		 
			public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringBuilder sb = new StringBuilder();
				String s;
		 
				while (true) {
		 
					s = br.readLine();
		 
					if (s.equals(".")) { // 종료 조건문
						break;
					}
		 
					sb.append(solve(s)).append('\n');
				}
		 
				System.out.println(sb);
			}
		 
			public static String solve(String s) {
				
				char[] stack = new char[s.length()];	// 스택처럼 사용할 비열 
				int size = 0;
		 
				for (char val : s.toCharArray()) {
					
					// 여는 괄호일 경우 배열에 저장 후 size 1증가 
					if (val == '(' || val == '[') {
						stack[size] = val;
						size++;
					} 
					
					// 닫는 소괄호일경우 
					else if (val == ')') {
						
						// 요소가 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우 
						if (size == 0 || stack[size - 1] != '(') {
							return "no";
						} 
						else {
							size--;
						}
					} 
					
					// 닫는 소괄호일경우 
					else if (val == ']') {
						
						// 요소가 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우 
						if (size == 0 || stack[size - 1] != '[') {
							return "no";
						} 
						else {
							size--;
						}
					}
				}
				
				if (size != 0) {
					return "no";
				} 
				else {
					return "yes";
				}
			}
		}
		*/
		