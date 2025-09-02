package selfStudy;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_10773 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int repeat;
        repeat = scanner.nextInt();
        int answer = 0;
        int index = 0;

        Stack<Integer> stack = new Stack<>();

        while (0 < repeat--){
            int num = scanner.nextInt();
            if(num != 0){
                stack.push(num) ;
                index++;
            }
            else{
                stack.pop();
                index--;
            }
        }

        for(int i = 0; i < index; i++){
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
