package board;

// 게시물 겍체
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