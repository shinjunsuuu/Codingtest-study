package BOJ;

import java.util.Scanner;

public class BJ_10809 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        scanner.close();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        String[] alphaArray = alphabet.split("");


        for(int i = 0; i < alphaArray.length; i++){
            System.out.print(word.indexOf(alphaArray[i]) + " ");
        }
    }
}
