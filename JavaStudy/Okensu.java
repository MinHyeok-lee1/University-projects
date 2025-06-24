package backjoon_basic12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Okensu {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < arr.length; i++) {
			while (!stack.empty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		while(!stack.empty()) arr[stack.pop()] = -1;
		for(int x : arr) sb.append(x).append(' ');
		System.out.print(sb);
	}

}


/*다른풀이 1) Stack
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
 
 
		for(int i = 0; i < N; i++) {
			
			
			 * 스택이 비어있지 않으면서 
			 * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
			 * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
			 * 해당 인덱스의 값을 현재 원소로 바꿔준다. 
			 
			while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
				seq[stack.pop()] = seq[i];
			}
			
			stack.push(i);
		}
		
		
		 * 스택의 모든 원소를 pop하면서 해당 인덱스의 value를
		 * -1로 초기화한다.
		 
		while(!stack.isEmpty()) {
			seq[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(seq[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}

다른풀이 2) Array
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		int[] stack = new int[N];	// 스택처럼 쓸 배열 
		int top = -1;	// 스택의 맨 위 원소를 가리키는 변수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
 
		for (int i = 0; i < N; i++) {
			
			 * 스택이 비어있지 않으면서 (= top 이 -1이 아닐 경우) 
			 * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
			 * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
			 * 해당 인덱스의 값을 현재 원소로 바꿔준다. 
			 
			while (top != - 1 && seq[stack[top]] < seq[i]) {
				seq[stack[top]] = seq[i];
				top--;
			}
			top++;
			stack[top] = i;
		}
 
		
		 * 스택의 모든 원소를 pop하면서 해당 인덱스의 value를
		 * -1로 초기화한다.
		 
		for(int i = top; i >= 0; i--) {
			seq[stack[i]] = -1;
		}
 
		StringBuilder sb = new StringBuilder();
		for (int v : seq) {
			sb.append(v).append(' ');
		}
 
		System.out.println(sb);
	}
}
*/