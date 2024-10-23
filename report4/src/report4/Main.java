package report4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("=========================");
            System.out.println("  [[[ 학생성적관리 I ]]]");
            System.out.println("-------------------------");
            System.out.printf("   1. 학생성적 입력[%d]\n", manager.students.size());
            System.out.println("   2. 학생성적 출력");
            System.out.println("   3. 성적관리 종료");
            System.out.println("=========================");
            System.out.print("> 메뉴선택[Enter:1]? ");

            String input = scanner.nextLine();
            int choice = input.isEmpty() ? 1 : Integer.parseInt(input);

            try {
                switch (choice) {
                    case 1:
                        // 학번 입력 (예외 처리 적용)
                        int id;
                        while (true) {
                            try {
                                System.out.print("학생 학번을 입력하세요.[Enter:1]? ");
                                String idInput = scanner.nextLine();
                                id = idInput.isEmpty() ? 1 : Integer.parseInt(idInput);

                                // 학번 중복 검사
                                if (manager.isDuplicateId(id)) {
                                    System.out.println("[오류] 중복된 학번입니다. 다시 입력해주세요.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("[오류] 숫자를 입력해야 합니다. 다시 시도해주세요.");
                            }
                        }

                        // 이름과 성적 입력
                        System.out.print("학생 성명을 입력하세요.[Enter:홍길동]? ");
                        String name = scanner.nextLine();
                        if (name.isEmpty()) name = "홍길동";

                        int korean = getValidScore(scanner, "국어 성적을 입력하세요.[Enter:50]?");
                        int english = getValidScore(scanner, "영어 성적을 입력하세요.[Enter:50]?");
                        int math = getValidScore(scanner, "수학 성적을 입력하세요.[Enter:50]?");

                        manager.addStudent(id, name, korean, english, math);
                        System.out.println("[학생성적 입력 완료]");
                        System.out.println("Press [Enter] key to continue...");
                        scanner.nextLine();  // 엔터 대기

                        break;

                    case 2:
                        // 학생 성적 출력
                        System.out.println("<학생성적 출력>");
                        manager.printStudents();
                        System.out.println("[학생성적 출력 완료]");
                        System.out.println("Press [Enter] key to continue...");
                        scanner.nextLine();  // 엔터 대기
                        break;

                    case 3:
                        // 성적관리 종료
                        System.out.print("> 종료할까요(y/n)[Enter:n]? ");
                        String exit = scanner.nextLine();
                        if (exit.equalsIgnoreCase("y")) {
                            System.out.println("수고 하셨습니다~ ^^");
                            scanner.close();
                            return;
                        }
                        break;

                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[오류] 숫자를 입력해야 합니다. 다시 시도해주세요.");
            }
        }
    }

    // 유효한 성적 입력을 받는 메소드
    private static int getValidScore(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return input.isEmpty() ? 50 : Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[오류] 숫자를 입력해야 합니다. 다시 시도해주세요.");
            }
        }
    }
}
