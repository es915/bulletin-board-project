package board;
import java.util.ArrayList;
import java.util.Scanner;

class Board {
	
	ArrayList<Article> articles = new ArrayList<>();
	int lastestArticleNo = 4;
	Scanner sc = new Scanner(System.in);
	
	public void run() {
		init();
		
		while (true) {
			System.out.print("명령어를 입력해주세요 : ");
			String command = sc.nextLine();

			if (command.equals("help")) {
				printHelp();

			} else if (command.equals("add")) {
				add();

			} else if (command.equals("list")) {
				printArticles(articles);

			} else if (command.equals("update")) {
				update();		

			} else if(command.equals("delete")) {
				delete();
			} else if(command.equals("search")) {
				search();
				
			}
		}
	}
	
	private void search() {
		
		System.out.print("검색 키워드를 입력해주세요 : ");
		String keyword = sc.nextLine();
		
		ArrayList<Article> searchedList = new ArrayList<>();
		
		for(int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
				
			if(article.getTitle().contains(keyword)) {
				searchedList.add(article);
			}
		}
		
		printArticles(searchedList);
		
	}

	private void init() {
		
		Article a1 = new Article(1, "제목1", "내용1");
		Article a2 = new Article(2, "제목2", "내용2");
		Article a3 = new Article(3, "제목2", "내용2");
		
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		
	}

	private void printHelp() {
		System.out.println("add  : 게시물 등록");
		System.out.println("list : 게시물 목록 조회");
		System.out.println("update : 게시물 수정");
		System.out.println("delete : 게시물 삭제");
	}

	private void delete() {
		System.out.print("삭제할 게시물 번호 :");
		int idx = Integer.parseInt(sc.nextLine());
		Article article = getArticleByIdx(idx);
		
		if(article != null) {
			//articles.remove(i);// 순번으로지우는 버전
			articles.remove(article);// 값으로지우는 버전
			printArticles(articles);
		} else {
			System.out.println("없는 게시물입니다.");	
		}
	}

	private void update() {
		System.out.print("수정할 게시물 번호 :");
		int idx = Integer.parseInt(sc.nextLine());
		Article article = getArticleByIdx(idx);
		
		if(article != null) {
			System.out.print("새제목 : ");
			String newTitle = sc.nextLine();
			System.out.print("새내용 : ");
			String newBody = sc.nextLine();
			
			article.setTitle(newTitle);
			article.setBody(newBody);
			printArticles(articles);
		} else {
			System.out.println("없는 게시물입니다.");	
		}		
	}

	private void add() {
		System.out.print("제목을 입력해주세요 : ");
		String title = sc.nextLine();
		System.out.print("내용을 입력해주세요 : ");
		String body = sc.nextLine();

		Article article = new Article(lastestArticleNo, title, body);
		articles.add(article);
		
		System.out.println("게시물이 등록되었습니다.");
		lastestArticleNo++;
	}

	public Article getArticleByIdx(int idx) {
		for(int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			if(article.getIdx() == idx) {
				return article;
			}
		}
		
		return null;
	}
	
	public void printArticles(ArrayList<Article> targetList) {
		for(int i = 0; i < targetList.size(); i++) {
		
			Article article = targetList.get(i);
			
			System.out.printf("번호 : %d\n", article.getIdx());
			System.out.printf("제목 : %s\n", article.getTitle());
			System.out.println("========================");
		}
	}
}