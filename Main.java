package board;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Board myBoard = new Board();
		myBoard.run();
	}
}

// static을 쓰지 않기 위해 클래스를 따로 만듦
class Board {
	ArrayList<Integer> nums = new ArrayList<>();
	// 게시물 제목들만 담아둔 리스트
	ArrayList<String> titles = new ArrayList<>();
	// 게시물 내용들만 담아둔 리스트
	ArrayList<String> bodies = new ArrayList<>();
	int lastestArticleNum = 1;

	public void printArticles() {
		for(int i = 0; i < titles.size(); i++) {
			System.out.printf("번호 : %d\n", nums.get(i));
			System.out.printf("제목 : %s\n", titles.get(i));
			System.out.println("========================");
		}
	}
	public void run() {
		
		Scanner sc = new Scanner(System.in);

		// 명령어를 계속 받기위한 while 
		while (true) {
			// 명령어를 command 에 입력받아 해당 명령어 구현
			System.out.print("명령어를 입력해주세요 : ");
			String command = sc.nextLine();

			// 명령어 종류 확인
			if (command.equals("help")) {
				System.out.println("add  : 게시물 등록");
				System.out.println("list : 게시물 목록 조회");

				// 게시물 추가 명령어
			} else if (command.equals("add")) {
				nums.add(lastestArticleNum);
				
				System.out.print("제목을 입력해주세요 : ");
				String title = sc.nextLine();
				System.out.print("내용을 입력해주세요 : ");
				String body = sc.nextLine();

				titles.add(title);
				bodies.add(body);
				System.out.println("게시물이 등록되었습니다.");
				lastestArticleNum++;
				
				// 게시물 리스트 출력 명령어
			} else if (command.equals("list")) {
				printArticles();

				// 게시물 수정 명령어
			} else if (command.equals("update")) {
				System.out.print("수정할 게시물 번호 :");
				// 문자열로 입력받고 정수로 변환
				int no = Integer.parseInt(sc.nextLine())-1;

				// 있는 번호인지 체크
				if (no < 0 || no >= titles.size()) {
					System.out.println("없는 게시물입니다.");

					// 있으면 내용 수정후 리스트 명령어 실행
				} else {
					System.out.print("새제목 : ");
					String newTitle = sc.nextLine();
					System.out.print("새내용 : ");
					String newBody = sc.nextLine();

					titles.set(no, newTitle);
					bodies.set(no, newBody);

					System.out.println("수정이 완료되었습니다.");

					printArticles();

				}
			} else if(command.equals("delete")) {
				
				System.out.print("삭제할 게시물 번호 :");
				// 문자열로 입력받고 정수로 변환
				int no = Integer.parseInt(sc.nextLine())-1;

				// 있는 번호인지 체크
				if (no < 0 || no >= titles.size()) {
					System.out.println("없는 게시물입니다.");

					// 있으면 내용 수정후 리스트 명령어 실행
				} else {
					nums.remove(no);
					titles.remove(no);
					bodies.remove(no);
					System.out.println("삭제 되었습니다");
					
					printArticles();
				}
			}
		}
	}
}
