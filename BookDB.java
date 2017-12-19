package wangkai;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
public class BookDB {
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();
	static {
		books.put("1", new Book("1", "他，改变了中国"));
		books.put("2", new Book("2", "Deep ♂ Dark ♂ Fantastic"));
		books.put("3", new Book("3", "白色相簿"));
		books.put("4", new Book("4", "日在校园"));
		books.put("5", new Book("5", "五年高考，三年复读"));
		books.put("6", new Book("6", "金瓶梅"));
		books.put("7", new Book("7", "草榴社区"));
		books.put("8", new Book("8", "青铜修炼手册"));
		books.put("9", new Book("9", "元气满满的亚龙人女仆"));
		books.put("10", new Book("10", "天际省漫游手册"));
		books.put("11", new Book("11", "为美好的世界献上祝福"));
		books.put("12", new Book("12", "真正的粉丝"));
	}
	// 获得所有的图书
	public static Collection<Book> getAll() {
		return books.values();
	}
	// 根据指定的id获得图书
	public static Book getBook(String id) {
		return books.get(id);
	}
}
