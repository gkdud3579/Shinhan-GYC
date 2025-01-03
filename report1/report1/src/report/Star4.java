package report;

import java.util.Scanner;

public class Star4 {
    public static void main(String[] args) {
    	
    	//1. 사람들에게 입력값을 받음 
        Scanner scanner = new Scanner(System.in);
        System.out.print("몇 개로 출력할까요? ");
        int numStars = scanner.nextInt();

        //2. 중첩 for문을 사용하여 별을 출력함
        for (int i = numStars; i >= 1; i--) {
            // 2.1 먼저 줄마다 앞에 올 공백을 출력
            for (int j = numStars - i; j > 0; j--) {
                System.out.print(" ");
            }
            // 2.2 그 다음 별을 출력
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println(); // 한 줄이 끝나면 다음 줄로 넘어감
        }
        scanner.close();
    }
}
