package backjoon_basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortInside {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[10];
		String N = br.readLine();
		
		for(int i = 0; i < N.length(); i++) arr[N.charAt(i) -'0']++;
		
		for(int i = 9; i >= 0; i--) {
			while(arr[i]-- > 0) sb.append(i);
		}
		
		System.out.print(sb);
	}
}

/*다른풀이 1)
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] arr = in.nextLine().toCharArray();
		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	}
}

다른풀이 2)
import java.io.InputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		int[] counting = new int[10];
		int c;
		while ((c = in.read()) != '\n') {
			counting[c - '0']++;
		}
		for (int i = 9; i >= 0; i--) {
			while (counting[i]-- > 0) {
				System.out.print(i);
			}
		}
	}
}
*/