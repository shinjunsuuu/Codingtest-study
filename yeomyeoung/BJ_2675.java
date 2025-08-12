import java.util.Scanner;

public class BJ_2675 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeatTimes = scanner.nextInt();
        scanner.nextLine();
/*      String[] arr = new String[repeatTimes];
        String[] inputArray = new String[repeatTimes * 2];

        for(int i = 0; i < repeatTimes; i++){
            arr[i] = scanner.nextLine();
        }
        scanner.close();

        for(int i = 0; i < repeatTimes; i++){
            inputArray = arr[i].split(" ");
        }

        System.out.println(inputArray[0]);

        for(int i = 0; i < repeatTimes * 2; i++){
            if((i % 2) != 0){
*/

        for (int i = 0; i < repeatTimes; i++) {
            int r = scanner.nextInt();
            String s = scanner.next();

            for (char ch : s.toCharArray()) {
                for (int k = 0; k < r; k++) {
                    System.out.print(ch);
                }
            }
            System.out.println();
        }

    }
}
