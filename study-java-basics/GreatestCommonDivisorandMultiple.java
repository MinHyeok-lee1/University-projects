package backjoon_basic10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GreatestCommonDivisorandMultiple {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int x = a > b ? a : b;
		int mul = 1;
		int div = 1;
		
		for(int i = 2; i < Math.sqrt(x); i++) {
			if(a % i == 0 && b % i == 0) {
				a /= i;
				b /= i;
				div *= i;
				i = 1;
			}
		}
		sb.append(div).append('\n');
		if(a != 1 && b != 1) mul = div*(a*b);
		sb.append(mul);
		System.out.print(sb);
	}
}

/*다른 방법 1)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = gcd(a, b); // 최대공약수
		System.out.println(d);
		System.out.println(a * b / d);
	}

// 최대공약수 재귀 방식
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
// GCD(a, b) = GCD(b, r)이므로 (r = a % b)
		return gcd(b, a % b);
	}
}

다른 방법 2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = gcd(a, b);
		System.out.println(d);
		System.out.println(a * b / d);
	}

// 최대공약수 반복문 방식
	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b; // 나머지를 구해준다.
// GCD(a, b) = GCD(b, r)이므로 변환한다.
			a = b;
			b = r;
		}
		return a;
	}
}
*/