package report;

import java.util.Scanner;

public class Star1 {
    public static void main(String[] args) {
    	
    	//1. 사람들에게 입력값을 받음 
        Scanner scanner = new Scanner(System.in);
        System.out.print("몇 개로 출력할까요? ");
        int numStars = scanner.nextInt();

        //2. 중첩 for문을 사용하여 별을 출력함 
        for (int i = 1; i <= numStars; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*"); // 별을 한 줄에 i개만큼 출력
            }
            System.out.println(); // 한 줄이 끝나면 다음 줄로 넘어감
        }
        scanner.close();
    }
}

