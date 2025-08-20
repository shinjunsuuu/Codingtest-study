package nowoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585 {
//500 100 50 10 5 1
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());

		int money = 1000 - input;
		int count = 0;
		count += money / 500;
		count += (money % 500) / 100;
		count += (money % 100) / 50;
		count += (money % 50) / 10;
		count += (money % 10) / 5;
		count += (money % 5) / 1;
		System.out.println(count);

	}

}
