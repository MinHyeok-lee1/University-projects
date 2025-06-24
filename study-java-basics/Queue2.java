package backjoon_basic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Queue2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int [N];
		int size = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
		
			if(str.equals("push")) {
				arr[size] = Integer.parseInt(st.nextToken());
				size++;
			}else {
				switch(str) {
				   case("pop"):{
					   if(size == 0) System.out.println(-1);
					   else {
						   System.out.println(arr[0]);
						   for(int j = 0; j < size - 1; j++) {
							   arr[j] = arr[j + 1];
						   }
						   size--;
					   }
					   break;
				   }
				   case("size"):{
					   System.out.println(size);
					   break;
				   }
				   case("empty"):{
					   if(size == 0) System.out.println(1);
					   else System.out.println(0);
					   break;
				   }
				   case("front"):{
					   if(size == 0) System.out.println(-1);
					   else System.out.println(arr[0]);
					   break;
				   }
				   case("back"):{
					   if(size == 0) System.out.println(-1);
					   else System.out.println(arr[size - 1]);
					   break;
				   }
				}
			}
		}
	}

}

/*
다른방법 1:[LinkedList 방식]
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.io.IOException;
	import java.util.StringTokenizer;
	import java.util.Deque;
	import java.util.LinkedList;
	 
	public class Main {
	 
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			
			Deque<Integer> q = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer command;
			
			while(N-- > 0) {
				command = new StringTokenizer(br.readLine(), " ");	// 문자열 분리 
				
				switch(command.nextToken()) {	
				
				case "push":
					// offer는 큐의 맨 뒤에 요소를 추가한다.
					q.offer(Integer.parseInt(command.nextToken()));	
					break;
				
				case "pop" :
					 *
					 *  poll은 가장 앞에 있는 요소를 삭제하며
					 *  삭제할 원소가 없을 경우 예외를 던지는 것이 아닌 null을 반환한다.
					 *
					Integer item = q.poll();	
					if(item == null) {
						sb.append(-1).append('\n');
					}
					else {
						sb.append(item).append('\n');
					}
					break;
					
				case "size":	
					sb.append(q.size()).append('\n');
					break;
					
				case "empty":
					if(q.isEmpty()) {
						sb.append(1).append('\n');
					}
					else {
						sb.append(0).append('\n');
					}
					break;
					
				case "front":
					// peek()은 큐에 꺼낼 요소가 없을 경우 null을 반환한다.
					Integer ite = q.peek();
					if(ite == null) {
						sb.append(-1).append('\n');
					}
					else {
						sb.append(ite).append('\n');
					}
					break;
					
				case "back":
					// peekLast()은 큐에 꺼낼 요소가 없을 경우 null을 반환한다.
					Integer it = q.peekLast();	 
					if(it == null) {
						sb.append(-1).append('\n');
					}
					else {
						sb.append(it).append('\n');
					}
					break;
				}
			}
			System.out.println(sb);
		}
	}

다른방법 2) [ArrayDeque 방식]
		import java.io.BufferedReader;
		import java.io.InputStreamReader;
		import java.io.IOException;
		import java.util.StringTokenizer;
		import java.util.Deque;
		import java.util.ArrayDeque;
		 
		public class Main {
		 
			public static void main(String[] args) throws IOException {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringBuilder sb = new StringBuilder();
				
				Deque<Integer> q = new ArrayDeque<>();
				
				int N = Integer.parseInt(br.readLine());
				
				StringTokenizer command;
				
				while(N-- > 0) {
					command = new StringTokenizer(br.readLine(), " ");	// 문자열 분리 
					
					switch(command.nextToken()) {	
					
					case "push":
						// offer는 큐의 맨 뒤에 요소를 추가한다.
						q.offer(Integer.parseInt(command.nextToken()));	
						break;
						
					case "pop" :
						*
						 *  poll은 가장 앞에 있는 요소를 삭제하며
						 *  삭제할 원소가 없을 경우 예외를 던지는 것이 아닌 null을 반환한다.
						 *
						Integer item = q.poll();	
						if(item == null) {
							sb.append(-1).append('\n');
						}
						else {
							sb.append(item).append('\n');
						}
						break;
						
					case "size":	
						sb.append(q.size()).append('\n');
						break;
						
					case "empty":
						if(q.isEmpty()) {
							sb.append(1).append('\n');
						}
						else {
							sb.append(0).append('\n');
						}
						break;
						
					case "front":
						// peek()은 큐에 꺼낼 요소가 없을 경우 null을 반환한다.
						Integer ite = q.peek();
						if(ite == null) {
							sb.append(-1).append('\n');
						}
						else {
							sb.append(ite).append('\n');
						}
						break;
						
					case "back":
						// peekLast()은 큐에 꺼낼 요소가 없을 경우 null을 반환한다.
						Integer it = q.peekLast();	 
						if(it == null) {
							sb.append(-1).append('\n');
						}
						else {
							sb.append(it).append('\n');
						}
						break;
					}
				}
				System.out.println(sb);
			}
		}
		
다른방법 3) 직접 구현 방식
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	static int[] q = new int[2000000];	// 명령의 수는 2,000,000을 안넘음 
	
	static int size = 0;	
	static int front = 0;
	static int back = 0;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
 
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()){
			case "push": push(Integer.parseInt(st.nextToken())); break;
			case "pop" : pop(); break;
			case "size" : size(); break;
			case "empty" : empty(); break;
			case "front" : front(); break;
			case "back" : back(); break;
			
			}
		}
		System.out.println(sb);
	}
	
	static void push(int n) {
		q[back] = n;
		back++;
		size++;
	}
	
	static void pop() {
		if(size == 0) {
			sb.append(-1).append('\n');
		}
		else {
			sb.append(q[front]).append('\n');	// 맨 앞의 원소를 출력 
			size--;
			front++;	// front가 가리키는 위치 1 증가 
		}
	}
	
	static void size() {
		sb.append(size).append('\n');
	}
	
	static void empty() {
		if(size == 0) {
			sb.append(1).append('\n');
		}
		else sb.append(0).append('\n');
	}
	
	static void front() {
		if(size == 0) { 
			sb.append(-1).append('\n');
		}
		else {
			sb.append(q[front]).append('\n');	 // 맨 앞의 원소 출력 
		}
	}
	
	static void back() {
		if(size == 0) {
			sb.append(-1).append('\n');
		}
		else {
			sb.append(q[back - 1]).append('\n');	// 맨 뒤의 원소 출력 
		}
	}
 
}
*/