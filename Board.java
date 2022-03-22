package board;

import java.util.ArrayList;
import java.util.Scanner;

class Board {
	
	// 식별 번호를 담아둘 리스트
	ArrayList<Integer> nums = new ArrayList<>();
	// 게시물 제목들만 담아둔 리스트
	ArrayList<String> titles = new ArrayList<>();
	// 게시물 내용들만 담아둔 리스트
	ArrayList<String> bodies = new ArrayList<>();

	// 게시물객체(제목, 내용을 한 묶음으로)를 담아둘 리스트
	ArrayList<Article> articles = new ArrayList<>();
	// 게시물 고유 식별 번호
	int lastestArticleNum = 1;
	
	// 여러 함수에서 사용함으로 밖으로 뺌
	Scanner sc = new Scanner(System.in);

	public void run() {
		
		// 초기 세팅
		init();
		
		// 명령어를 계속 받기위한 while 
		while (true) {
			// 명령어를 command 에 입력받아 해당 명령어 구현
			System.out.print("명령어를 입력해주세요 : ");
			String command = sc.nextLine();

			// 명령어 종류 확인
			if (command.equals("help")) {
				help();

				// 게시물 추가 명령어
			} else if (command.equals("add")) {
				add();
				
				// 게시물 리스트 출력 명령어
			} else if (command.equals("list")) {
				printArticles();

				// 게시물 수정 명령어
			} else if (command.equals("update")) {
				update();
				
				// 게시물 삭제 명령어
			} else if(command.equals("delete")) {
				delete();

			}
		}
	}
	
	// 초기 셋 함수 : 테스트 케이스 3개 추가
	private void init() {
		Article a1 = new Article(1, "제목1", "내용1");
		Article a2 = new Article(2, "제목2", "내용2");
		Article a3 = new Article(3, "제목3", "내용3");
		
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
	}
	
	// 각종 명령어 출력함수
	private void help() {
		System.out.println("add  : 게시물 등록");
		System.out.println("list : 게시물 목록 조회");
		System.out.println("update : 게시물 수정");
		System.out.println("delete : 게시물 삭제");
	}
	
	// 게시물 추가 함수
	private void add() {
		System.out.print("제목을 입력해주세요 : ");
		String title = sc.nextLine();
		System.out.print("내용을 입력해주세요 : ");
		String body = sc.nextLine();
		
		Article article = new Article(lastestArticleNum, title, body);
		articles.add(article);

		System.out.println("게시물이 등록되었습니다.");
		lastestArticleNum++;
	}
	
	// 게시물 수정 함수
	private void update() {
		System.out.print("수정할 게시물 번호 :");
		
		int no = Integer.parseInt(sc.nextLine());
		
		// 번호를 받고 그 번호에 해당하는 게시물을 article에 담음
		Article article = getArticleByIdx(no);
		
		// article이 null아닐시(있는 번호의 게시물) 내용 실행
		if(article!=null) {
			System.out.print("새제목 : ");
			String newTitle = sc.nextLine();
			System.out.print("새내용 : ");
			String newBody = sc.nextLine();
			
			article.setTitle(newTitle);
			article.setBody(newBody);
			
			printArticles();
		} else {
			System.out.println("없는 게시물입니다.");
		}
	}
	
	// 게시물 삭제 함수
	private void delete() {
		System.out.print("삭제할 게시물 번호 :");
		// 문자열로 입력받고 정수로 변환
		int no = Integer.parseInt(sc.nextLine());
		
		Article article = getArticleByIdx(no);
		
		if(article!=null) {
			articles.remove(article);
			printArticles();
		} else {
			System.out.println("없는 게시물입니다.");
		}
	}
	
	// 객체의 번호를 입력받고 그 번호에 대한 게시물읋 보여주는 함수
	public Article getArticleByIdx(int idx) {
		// 입력 받은 번호의 객체가 있을시 그 객체를 리턴
		for(int i=0; i<articles.size(); i++) {
			Article article = articles.get(i);
			if(article.getIdx()==idx) {
				return article;
			}
		}
		// 없으면 null 리턴
		return null;
	}
	
	// 전체 게시물 출력 함수
	public void printArticles() {
		for(int i = 0; i < articles.size(); i++) {
 		
			Article article = articles.get(i);
			
			// 고유 식별 넘버를 출력
			System.out.printf("번호 : %d\n", article.getIdx());
			System.out.printf("제목 : %s\n", article.getTitle());
			System.out.println("========================");
		}
	}
}
