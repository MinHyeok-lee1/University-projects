package backjoon_basic04;

import java.io.IOException;

public class AddN {

	public static void main(String args[]) throws IOException {
		int [] arr = new int [100];
		Test test = new Test();
		System.out.print(test.sum(arr));
	}
}

class Test {
	long sum(int [] a) {
		long x = 0;
		for(int i : a) {
			x += i;
		}
		return x;
	}
}
