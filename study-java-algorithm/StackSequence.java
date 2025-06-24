package backjoon_basic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[N + 1];
		int[] seq = new int[N + 1];
		int size = 1;

		while (N > 0) {
			int x = Integer.parseInt(br.readLine());

			for (int i = 1; i <= x; i++) {
				if (stack[i] == 0) {
					size = i;
					break;
				}
			}
			System.out.println(seq[N] + "//" + x);
			if (seq[N] < x) {
				for (int i = size; i <= x; i++) {
					stack[i] = 1;
					System.out.println("+");
				}
			}
            for(int i = seq[N]; i > x; i--) {
            	if(stack[i] == 1) {
            		System.out.println("NO");
            		System.exit(0);
            	}
            }
			seq[N - 1] = x;
			System.out.println("-");
			stack[x] = -1;

			N--;
		}
	}

}

/*
다른방법 1) BufferReader+StringBuilder
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	// 출력할 결과물 저장
		
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int start = 0;
		
		// N 번 반복
		while(N -- > 0) {
			
			int value = Integer.parseInt(br.readLine());
			
			if(value > start) {
				// start + 1부터 입력받은 value 까지 push를 한다.
				for(int i = start + 1; i <= value; i++) {
					stack.push(i);
					sb.append('+').append('\n');	// + 를 저장한다. 
				}
				start = value; 	// 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화 
			}
			
			// top에 있는 원소가 입력받은 값과 같이 않은 경우  
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;		// 또는 System.exit(0); 으로 대체해도 됨. 
			}
			
			stack.pop();
			sb.append('-').append('\n');
			
		}
		
		System.out.println(sb);
	}
}

다른방법 2) BufferReader+Array
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] stack = new int[N];
		
		int idx = 0;
		int start = 0;
		
		// N 번 반복
		while(N -- > 0) {
			int value = Integer.parseInt(br.readLine());
			
			if(value > start) {
				// start + 1부터 입력받은 value 까지 push를 한다.
				for(int i = start + 1; i <= value; i++) {
					stack[idx] = i;
					idx++;
					sb.append('+').append('\n');
				}
				start = value; 	// 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화 
			}
			
			// top에 있는 원소가 입력받은 값과 같이 않은 경우  
			else if(stack[idx - 1] != value) {
					System.out.println("NO");
					System.exit(0);	//	return 으로 대체해도 됨 
			}
			
			idx--;
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
 
}
*/