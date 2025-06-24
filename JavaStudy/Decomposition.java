package backjoon_basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Decomposition {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		String str;
		int result = 0;
		for(int j = 1; j < N; j++) {
			int sum = j;
			str = Integer.toString(j);
			for(int i = 0; i < str.length(); i++) {
				sum += str.charAt(i) - '0';
			}
			if(sum == N) {
				result = j;
				break;
			}
		}
		System.out.print(result);
	}
}

/*
다른풀이 1)
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int result = 0;
		for (int i = 0; i < N; i++) {
			int number = i;
			int sum = 0; // 각 자릿수 합 변수
			while (number != 0) {
				sum += number % 10; // 각 자릿수 더하기
				number /= 10;
			}
// i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
			if (sum + i == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}

다른풀이 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < N; i++) {
			int number = i;
			int sum = 0; // 각 자릿수 합 변수
			while (number != 0) {
				sum += number % 10; // 각 자릿수 더하기
				number /= 10;
			}
// i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
			if (sum + i == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}

다른풀이 3)
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
// 자릿수의 길이를 알기위해 일단 문자열로 입력받는다.
		String str_N = in.nextLine();
// 해당 문자열의 길이 변수
		int N_len = str_N.length();
// 문자열을 정수(int)로 변환
		int N = Integer.parseInt(str_N);
		int result = 0;
// i 는 가능한 최솟값인 N - 9 * N의 각 자릿수부터 시작
		for (int i = (N - (N_len * 9)); i < N; i++) {
			int number = i;
			int sum = 0; // 각 자릿수 합 변수
			while (number != 0) {
				sum += number % 10; // 각 자릿수 더하기
				number /= 10;
			}
// i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
			if (sum + i == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}

다른풀이 4)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 자릿수의 길이를 알기위해 일단 문자열로 입력받는다.
		String str_N = br.readLine();
// 해당 문자열의 길이 변수
		int N_len = str_N.length();
// 문자열을 정수(int)로 변환
		int N = Integer.parseInt(str_N);
		int result = 0;
// i 는 가능한 최솟값인 N - 9 * N의 각 자릿수부터 시작
		for (int i = (N - (N_len * 9)); i < N; i++) {
			int number = i;
			int sum = 0; // 각 자릿수 합 변수
			while (number != 0) {
				sum += number % 10; // 각 자릿수 더하기
				number /= 10;
			}
// i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
			if (sum + i == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
*/