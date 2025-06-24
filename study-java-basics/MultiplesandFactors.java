package backjoon_basic10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MultiplesandFactors {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == 0) {
				System.out.print(sb);
				if (b == 0) System.exit(0);
			}

			if (a % b == 0) sb.append("multiple").append('\n');
			else if (b % a == 0) sb.append("factor").append('\n');
			else sb.append("neither").append('\n');
		}
	}
}

/*다른풀이 1)
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			int first = in.nextInt();
			int second = in.nextInt();
			if (first == 0 && second == 0)
				break;
			if (second % first == 0) {
				System.out.println("factor");
			} else if (first % second == 0) {
				System.out.println("multiple");
			} else {
				System.out.println("neither");
			}
		}
	}
}

다른풀이 2)
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String f = "factor\n";
		String m = "multiple\n";
		String n = "neither\n";
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			int first = in.nextInt();
			int second = in.nextInt();
			if (first == 0 && second == 0)
				break;
			if (second % first == 0) {
				sb.append(f);
			} else if (first % second == 0) {
				sb.append(m);
			} else {
				sb.append(n);
			}
		}
		System.out.println(sb);
	}
}

다른풀이 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		String f = "factor\n";
		String m = "multiple\n";
		String n = "neither\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			if (first == 0 && second == 0)
				break;
			if (second % first == 0) {
				sb.append(f);
			} else if (first % second == 0) {
				sb.append(m);
			} else {
				sb.append(n);
			}
		}
		System.out.println(sb);
	}
}
*/