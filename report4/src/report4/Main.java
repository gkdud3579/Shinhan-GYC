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
	            System.out.println("-------------------------");
	            System.out.println("   3. 성적관리 종료");
	            System.out.println("=========================");
	            System.out.print("> 메뉴선택[Enter:1]? ");

	           int choice = scanner.nextInt();
	            
	           switch(choice) {
	        	   case 1:
	        		   //학생성적 입력
	        		   System.out.print("학생 학번을 입력하세요.[Enter:1]?");
	        		   String idInput = scanner.nextLine();
	        	       int id = idInput.isEmpty() ? 1 : Integer.parseInt(idInput);
	        	       scanner.nextLine();
	        		   
	        		   System.out.print("학생 성명을 입력하세요.[Enter:홍길동]?");
	        		   String name = scanner.nextLine();
	        		   if (name.isEmpty()) {
	        	            name = "홍길동";
	        	        }
	        		   scanner.nextLine();
	        		   
	        		   System.out.print("국어 성적을 입력하세요.[Enter:50]?");
	        		   String korInput = scanner.nextLine();
	        		   int korean = idInput.isEmpty() ? 50 : Integer.parseInt(korInput);
	        	       scanner.nextLine();
	        		   
	        		   System.out.print("영어 성적을 입력하세요.[Enter:50]?");
	        		   String engInput = scanner.nextLine();
	        		   int english = idInput.isEmpty() ? 50 : Integer.parseInt(engInput);
	        	       scanner.nextLine();
	        		   
	        		   System.out.print("수학 성적을 입력하세요.[Enter:50]?");
	        		   String mathInput = scanner.nextLine();
	        		   int math = idInput.isEmpty() ? 50 : Integer.parseInt(mathInput);
	        	       scanner.nextLine();
	        		   
	        		   manager.addStudent(id, name, korean, english, math);
	        		   System.out.println("[학생성적 입력 완료]");
	        		   System.out.println("Press [Enter] key to continue...");
	        		   functions.ClearScreen();
	        		   
	        		   break;
	        		   
	        	   case 2:
	        		   //학생성적 출력
	        		   System.out.println("<학생성적 출력>");
	                   manager.printStudents();
	                   System.out.println("[학생성적 출력 완료]");
	                   System.out.println("Press [Enter] key to continue...");
	        		   break;
	        		   
	        	   case 3:
	        		   //성적관리 종료
	        		   System.out.print("> 종료할까요(y/n)[Enter]? ");
	                    scanner.nextLine();  // 버퍼 비우기
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
	          }
	        }
	    }
