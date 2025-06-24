package backjoon_basic10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Check {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i]) max = arr[i];
		}

		for (int i = 2; i < max; i++) {
			int x = 0;
			boolean t = false;
			for (int j = 0; j < N; j++) {
				if (t == false) {
					x = arr[j] % i;
					t = true;
				} else {
					if(x != arr[j] % i) {
						t = false;
						break;
					}
				}
			}
			if(t == true) sb.append(i).append(" ");
		}
		System.out.print(sb);
	}

}

/*다른방법 1)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr); // 정렬
		int gcdVal = arr[1] - arr[0]; // 음수가 되지 않도록 큰 수에서 작은 수로 빼준다.
		for (int i = 2; i < N; i++) {
// 직전의 최대 공약수와 다음 수(arr[i] - arr[i - 1])의 최대공약수를 갱신
			gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]);
		}
// 최대공약수의 약수들 찾기
		for (int i = 2; i <= gcdVal; i++) {
// i가 최대공약수의 약수라면 출력
			if (gcdVal % i == 0) {
				System.out.print(i + " ");
			}
		}
	}

// 최대공약수 함수
	static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}

다른 방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr); // 정렬
		int gcdVal = arr[1] - arr[0]; // 음수가 되지 않도록 큰 수에서 작은 수로 빼준다.
		for (int i = 2; i < N; i++) {
// 직전의 최대 공약수와 다음 수(arr[i] - arr[i - 1])의 최대공약수를 갱신
			gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]);
		}
		StringBuilder sb = new StringBuilder();
// 최대공약수의 약수들 찾기 (절반까지만 탐색)
		for (int i = 2; i <= gcdVal / 2; i++) {
// i의 제곱 값이 최대공약수의 약수라면?
			if (gcdVal % i == 0) {
				sb.append(i + " ");
			}
		}
// 마지막 최대공약수 꼭 출력해야함
		sb.append(gcdVal);
		System.out.println(sb);
	}

// 최대공약수 함수
	static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}

다른 방법 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr); // 정렬
		int gcdVal = arr[1] - arr[0]; // 음수가 되지 않도록 큰 수에서 작은 수로 빼준다.
		for (int i = 2; i < N; i++) {
// 직전의 최대 공약수와 다음 수(arr[i] - arr[i - 1])의 최대공약수를 갱신
			gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]);
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<Integer>();
// 최대공약수의 약수들 찾기 (제곱근까지만 탐색)
		for (int i = 2; i <= Math.sqrt(gcdVal); i++) {
// 제곱근이 gcdVal의 약수라면 중복추가를 방지하기 위해 한 번만 추가
			if (i * i == gcdVal) {
				list.add(i);
			}
// i가 최대공약수의 약수라면 i와 나눈 몫 추가
			else if (gcdVal % i == 0) {
				list.add(i);
				list.add(gcdVal / i);
			}
		}
// 정렬
		Collections.sort(list);
		for (int val : list) {
			sb.append(val).append(' ');
		}
// 마지막 최대공약수 꼭 출력해야함
		sb.append(gcdVal);
		System.out.println(sb);
	}

// 최대공약수 함수
	static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
*/