package GIL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution11720 {
	public static void main(String[] args) throws IOException {
		// 1. BufferedReader 객체 생성
		// System.in (바이트 스트림) -> InputStreamReader (문자 스트림) -> BufferedReader (버퍼 스트림)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		String line = br.readLine();
		String[] nums = line.split("");// 띄어쓰기 없는 문자열 str을 한 문자씩 분리하여 String[] 배열로 반환
		int a = 0;
		int count = 0;
		for (int i = 0; i < num; i++) {
			a = Integer.parseInt(nums[i]);
			count += a;
		}
		System.out.println(count);
		br.close();
	}
}