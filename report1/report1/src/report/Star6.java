package report;

import java.util.Scanner;

public class Star6 {
    public static void main(String[] args) {
        
        //1. 사람들에게 피라미드 높이를 설정할 입력값을 받음 
        Scanner scanner = new Scanner(System.in);
        System.out.print("피라미드의 높이를 몇 개로 출력할까요? ");
        int height = scanner.nextInt();

        //2. 중첩 for문을 사용하여 별을 출력함
        for (int i = height; i >= 1; i--) {
            //2.1 각 줄의 앞에 올 공백을 출력
            for (int j = height - i; j > 0; j--) {
                System.out.print(" ");
            }
            //2.2 해당 줄에서 출력할 별의 수
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            //2.3 다음 줄로 넘어감
            System.out.println();
        }
        scanner.close(); // 스캐너 사용을 종료함
    }
}
