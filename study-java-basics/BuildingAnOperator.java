package backjoon_basic08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuildingAnOperator {

	public static int oper[] = new int [4];
	public static int arr[];
	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		operator(1, arr[0], N);
		System.out.println(max);
		System.out.print(min);
		/*StringBuilder sb = new StringBuilder();
		sb.append(max).append('\n').append(min);
		System.out.print(sb);*/
	}

	public static void operator(int depth, int value, int N) {
        if(depth == N){
        	if(min > value) min = value;
        	if(max < value) max = value;
        	return;
        }
        
        for(int i = 0; i < 4; i++) {
        	if(oper[i] > 0) {
        		oper[i] --;	
        		if(i == 0) operator(depth + 1, value + arr[depth], N);
            	else if(i == 1) operator(depth + 1, value - arr[depth], N);
            	else if(i == 2) operator(depth + 1, value * arr[depth], N);
            	else if(i == 3) operator(depth + 1, value / arr[depth], N); 
    
        		oper[i]++;
        	}
        }
	}
}

/*다른풀이 1)
import java.util.Scanner;

public class Main {
	public static int MAX = Integer.MIN_VALUE; // 최댓값
	public static int MIN = Integer.MAX_VALUE; // 최솟값
	public static int[] operator = new int[4]; // 연산자 개수
	public static int[] number; // 숫자
	public static int N; // 숫자 개수

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		number = new int[N];
// 숫자 입력
		for (int i = 0; i < N; i++) {
			number[i] = in.nextInt();
		}
// 연산자 입력
		for (int i = 0; i < 4; i++) {
			operator[i] = in.nextInt();
		}
		dfs(number[0], 1);
		System.out.println(MAX);
		System.out.println(MIN);
	}

	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		for (int i = 0; i < 4; i++) {
// 연산자 개수가 1개 이상인 경우
			if (operator[i] > 0) {
// 해당 연산자를 1 감소시킨다.
				operator[i]--;
				switch (i) {
				case 0:
					dfs(num + number[idx], idx + 1);
					break;
				case 1:
					dfs(num - number[idx], idx + 1);
					break;
				case 2:
					dfs(num * number[idx], idx + 1);
					break;
				case 3:
					dfs(num / number[idx], idx + 1);
					break;
				}
// 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
				operator[i]++;
			}
		}
	}
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static int MAX = Integer.MIN_VALUE; // 최댓값
	public static int MIN = Integer.MAX_VALUE; // 최솟값
	public static int[] operator = new int[4]; // 연산자 개수
	public static int[] number; // 숫자
	public static int N; // 숫자 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
// 숫자 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
// 연산자 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		dfs(number[0], 1);
		System.out.println(MAX);
		System.out.println(MIN);
	}

	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		for (int i = 0; i < 4; i++) {
// 연산자 개수가 1개 이상인 경우
			if (operator[i] > 0) {
// 해당 연산자를 1 감소시킨다.
				operator[i]--;
				switch (i) {
				case 0:
					dfs(num + number[idx], idx + 1);
					break;
				case 1:
					dfs(num - number[idx], idx + 1);
					break;
				case 2:
					dfs(num * number[idx], idx + 1);
					break;
				case 3:
					dfs(num / number[idx], idx + 1);
					break;
				}
// 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
				operator[i]++;
			}
		}
	}
}
*/