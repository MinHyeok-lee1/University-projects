package backjoon_basic08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;
public class AgingSorting {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Person[] p = new Person[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			p[i] = new Person(age, name);
		}
		
		Arrays.sort(p, new Comparator<Person>() {
			@Override
			public int compare(Person s1, Person s2) {
				return s1.age - s2.age;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(p[i]);
		}
		System.out.print(sb);
		
	}
	
	public static class Person{
		int age;
		String name;
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return age + " " + name + '\n';
		}
	}

}
/*
다른풀이 1)
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String[][] arr = new String[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = in.next(); // 나이
			arr[i][1] = in.next(); // 이름
		}
		Arrays.sort(arr, new Comparator<String[]>() {
// 나이순으로 정렬
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}

다른풀이 2)
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String[][] arr = new String[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = in.next(); // 나이
			arr[i][1] = in.next(); // 이름
		}
		Arrays.sort(arr, new Comparator<String[]>() {
// 나이순으로 정렬
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}
}

다른풀이 3)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = st.nextToken(); // 나이
			arr[i][1] = st.nextToken(); // 이름
		}
		Arrays.sort(arr, new Comparator<String[]>() {
// 나이순으로 정렬
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}
}

다른풀이 4)
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Person[] p = new Person[N];
		for (int i = 0; i < N; i++) {
			p[i] = new Person(in.nextInt(), in.next());
		}
// 타입을 Person 으로 둘 것.
		Arrays.sort(p, new Comparator<Person>() {
// 나이순으로 정렬
			@Override
			public int compare(Person s1, Person s2) {
				return s1.age - s2.age;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
// 객체배열의 객체를 출력하면 해당 인덱스의 객체의 toString() 이 출력 됨
			sb.append(p[i]);
		}
		System.out.println(sb);
	}

	public static class Person {
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
}

다른풀이 5)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Person[] p = new Person[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			p[i] = new Person(age, name);
		}
// 타입을 Person 으로 둘 것.
		Arrays.sort(p, new Comparator<Person>() {
// 나이순으로 정렬
			@Override
			public int compare(Person s1, Person s2) {
				return s1.age - s2.age;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
// 객체배열의 객체를 출력하면 해당 인덱스의 객체의 toString() 이 출력 됨
			sb.append(p[i]);
		}
		System.out.println(sb);
	}

	public static class Person {
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
}

다른풀이 6)
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
// 입력되는 나이의 범위 : 1 ~ 200
		StringBuilder[] p = new StringBuilder[201];
//객체배열의 인덱스에 각 StringBuilder 객체를 생성해준다.
		for (int i = 0; i < p.length; i++) {
			p[i] = new StringBuilder();
		}
		for (int i = 0; i < N; i++) {
			int age = in.nextInt();
			String name = in.next();
// 카운팅 정렬 : 나이를 index 로 하여 해당 배열에 나이와 이름을 append() 한다
			p[age].append(age).append(' ').append(name).append('\n');
		}
		StringBuilder sb = new StringBuilder();
		for (StringBuilder val : p) {
			sb.append(val);
		}
		System.out.println(sb);
	}
}

다른풀이 7)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
// 입력되는 나이의 범위 : 1 ~ 200
		StringBuilder[] p = new StringBuilder[201];
//객체배열의 인덱스에 각 StringBuilder 객체를 생성해준다.
		for (int i = 0; i < p.length; i++) {
			p[i] = new StringBuilder();
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
// 카운팅 정렬 : 나이를 index 로 하여 해당 배열에 나이와 이름을 append() 한다
			p[age].append(age).append(' ').append(name).append('\n');
		}
		StringBuilder sb = new StringBuilder();
		for (StringBuilder val : p) {
			sb.append(val);
		}
		System.out.println(sb);
	}
}
*/