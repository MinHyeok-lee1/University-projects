package backjoon_basic01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FourRuleCalculations {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write((a + b) + "\n");
		bw.write((a - b) + "\n");
		bw.write((a * b) + "\n");
		bw.write((a / b) + "\n");
		bw.write((a % b) + "\n");
		
		bw.flush();
		bw.close();
	}
}
