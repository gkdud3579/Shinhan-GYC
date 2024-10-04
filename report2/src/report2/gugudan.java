package report2;

import java.util.Scanner;

public class gugudan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력받기
        System.out.print("시작단을 입력하세요: ");
        int startDan = sc.nextInt();

        System.out.print("끝단을 입력하세요: ");
        int endDan = sc.nextInt();

        System.out.print("단수를 입력하세요: ");
        int cols = sc.nextInt();

        // 2. 최대 자릿수 계산
        int maxDanWidth = getMaxDigitWidth(endDan); // 단의 최대 자릿수
        int maxProductWidth = getMaxDigitWidth(endDan * 9); // 곱셈 결과 최대 자릿수

        // 3. 구구단 출력과 동시에 최대 길이 계산
        int maxLineLength = 0; // 3.1 각 줄의 최대 길이 추적

        StringBuilder output = new StringBuilder(); // 출력 내용을 저장할 StringBuilder
        //3.2 startDan부터 endDan까지 cols개씩 출력
        for (int i = startDan; i <= endDan; i += cols) { 
            //3.3 구구단은 1부터 9까지 곱하는 방식으로 진행
            for (int j = 1; j <= 9; j++) { 
                int dan = i; //현재 출력중인 단의 값
                StringBuilder line = new StringBuilder(); // 한 줄의 내용을 저장할 StringBuilder
                //3.4 dan이 cols범위를 넘지 않도록 출력되지 않으면서, endDan을 넘지 않도록 출력
                while (dan < i + cols && dan <= endDan) {
                    line.append(String.format("%" + maxDanWidth + "d x %d = %" + maxProductWidth + "d    ", dan, j, dan * j));
                    dan++;
                }
                // 3.5 한 줄 완성 시 출력하고 그 줄의 길이 계산
                String lineStr = line.toString();
                output.append(lineStr).append("\n"); 
                maxLineLength = Math.max(maxLineLength, lineStr.length()); 
            }
            // 마지막 묶음이 아닌 경우에만 빈 줄 추가
            if (i + cols <= endDan) {
                output.append("\n");
            }
        }

        // 4. 구분선 생성 및 출력
        String header = String.format("<GUGUDAN : %d ~ %d, %d>", startDan, endDan, cols);
        String footer = "<END>";
        // maxLineLength를 header와 footer 중 가장 긴 값으로 업데이트
        maxLineLength = Math.max(maxLineLength, Math.max(header.length(), footer.length()));


        String separator = "-".repeat(maxLineLength); // 정확한 길이의 구분선 생성
        
        // 5. 공백 길이 계산
        int leftPaddingHeader = (maxLineLength - header.length() + 1) / 2;
        int leftPaddingFooter = (maxLineLength - footer.length() + 1) / 2;

        // 6. 출력 시작 부분
        System.out.println(separator);
        System.out.printf("%" + (leftPaddingHeader + header.length()) + "s%n", header); // 중앙 정렬된 헤더
        System.out.println(separator);

        // 7. 구구단 내용 출력
        System.out.print(output);

        // 8. 출력 종료 부분
        System.out.println(separator);
        System.out.printf("%" + (leftPaddingFooter + footer.length()) + "s%n", footer); // 중앙 정렬된 푸터
        System.out.println(separator);

        sc.close();
    }

    // 자릿수 계산 메서드
    public static int getMaxDigitWidth(int num) {
        return String.valueOf(num).length();
    }
}
