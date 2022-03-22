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

	public void run() {
		
		// 실행 하자마자 추가되는 리스트
		// 테스트 케이스 추가
		Article a1 = new Article(1, "제목1", "내용1");
		Article a2 = new Article(2, "제목2", "내용2");
		Article a3 = new Article(3, "제목3", "내용3");
		
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		
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
				
				System.out.print("제목을 입력해주세요 : ");
				String title = sc.nextLine();
				System.out.print("내용을 입력해주세요 : ");
				String body = sc.nextLine();
				
				Article article = new Article(lastestArticleNum, title, body);
				articles.add(article);
	
				System.out.println("게시물이 등록되었습니다.");
				lastestArticleNum++;
				
				// 게시물 리스트 출력 명령어
			} else if (command.equals("list")) {
				printArticles();

				// 게시물 수정 명령어
			} else if (command.equals("update")) {
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
								// 게시물 삭제 명령어
			} else if(command.equals("delete")) {
				
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

// 게시물 객체
class Article {
	private int idx;
	private String title;
	private String body;
	
	public Article() {
		
	}

	public Article(int idx, String title, String body) {
		super();
		this.idx = idx;
		this.title = title;
		this.body = body;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}
