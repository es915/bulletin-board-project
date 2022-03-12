package board;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<String> titles = new ArrayList<>();
		ArrayList<String> bodies = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String command = sc.nextLine();
			
			if(command.equals("help")) {
				System.out.println("add  : 게시물 등록");
				System.out.println("list : 게시물 목록 조회");
				
			} else if(command.equals("add")) {
				System.out.println("제목을 입력해주세요 : ");
				String title = sc.next();
				System.out.println("내용을 입력해주세요 : ");
				String body = sc.next();
				
				titles.add(title);
				bodies.add(body);
				System.out.println("게시물이 저장되었습니다\n");
				
			} else if(command.equals("list")) {

				for(int i=0; i<titles.size(); i++) {
					System.out.printf("번호 : %d\n", i+1);
					System.out.printf("제목 : %s\n", titles.get(i));
					System.out.printf("내용 : %s\n", bodies.get(i));
					System.out.println("=========================");
				}
				
			}	
		}		
	}

}