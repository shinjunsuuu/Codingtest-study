package BOJ;

import java.util.Scanner;

public class BOJ_2920 {
    public static void main(String[] args) {
        int num = 8;
        int[] arr = new int[num];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < num; i++){
            arr[i] = scanner.nextInt();
        }

            if(arr[0] == num){
                for(int i = 0; i < num; i++){
                    if(arr[i] != num - i){
                        System.out.println("mixed");
                        return;
                    }else {
                    }
                }
                System.out.println("descending");
            }

            else if(arr[0] == 1) {
                for (int i = 0; i < num; i++) {
                    if (arr[i] != i + 1) {
                        System.out.println("mixed");
                        return;
                    } else {
                    }
                }
                System.out.println("ascending");
            }
            else System.out.println("mixed");
        }
//        System.out.println(arr[7]);
    }

