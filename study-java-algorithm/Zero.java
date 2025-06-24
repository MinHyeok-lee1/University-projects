package backjoon_basic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zero {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[K];

		int size = 0;
		for (int i = 0; i < K; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				arr[size] = x;
				size++;
			} else {
				arr[size - 1] = 0;
				size--;
			}
		}
		int sum = 0;
		for(int x : arr) {
			sum += x;
		}
		System.out.print(sum);
	}

}
/*
다른 풀이 1) - 스택활용
import java.util.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			int number = Integer.parseInt(br.readLine());	// 정수 입력
			
			if(number == 0) {	// 0이라면 스택에 저장된 top 원소를 지운다.
				stack.pop();
			}
			else {
				
				 * push() 대신 add()로 대체해도 됨 (똑같이 상단에 원소를 추가하는 메소드다.)
				 * ex) stack.add(number);
				 
				stack.push(number);
			}
		}
		int sum = 0;
		
		for(int o : stack) {
			sum += o;
		}
 
		System.out.println(sum);		
	}
 
}

다른풀이 2)배열사용
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int top = -1;	// 마지막 원소의 위치를 가리키는 변수
 
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[K];
		
 
		for(int i = 0; i < K; i++) {
			
			int number = Integer.parseInt(br.readLine());	// 정수 입력
			
			if (number == 0) {	// 0 이라면 top 위치에 있는 원소를 0으로 초기화 
				top--;	// top이 가리키는 위치 1 감소
			} 
			else {
				top++;	// top이 가리키는 위치 1 증가
				arr[top] = number;	// 입력받은 정수로 초기화
			}
		}
		int sum = 0;
		for (int i = 0; i <= top; i++) {	// 합을 구할 때 K가 아닌 top까지이다.
			sum += arr[i];
		}
		System.out.println(sum);
 
	}
 
}*/