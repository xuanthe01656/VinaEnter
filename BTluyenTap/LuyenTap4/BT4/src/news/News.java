package news;

public class News {
	private int idNews;
	private String name;
	private int count_number;
	private String created_at;
	public News() {
		
	}
	public News(int idNews, String name, int count_number, String created_at) {
		this.idNews = idNews;
		this.name = name;
		this.count_number = count_number;
		this.created_at = created_at;
	}
	public int getIdNews() {
		return idNews;
	}
	public void setIdNews(int idNews) {
		this.idNews = idNews;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount_number() {
		return count_number;
	}
	public void setCount_number(int count_number) {
		this.count_number = count_number;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	@Override
	public String toString() {
		return "ID tin tức: " + idNews + " - Tên tin tức: " + name + " - Số lượng đọc: " + count_number + " - Ngày sản xuất: "
				+ created_at;
	}
	
}
