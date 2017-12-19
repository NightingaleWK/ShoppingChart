package wangkai;
import java.io.*;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Collection<Book> books = BookDB.getAll();
		
		out.write("==========================<br>");
		out.write("&nbsp&nbsp&nbsp欢迎！快进来坐坐，挑选几本书看看吧！<br>");
		out.write("==========================<br><br>");
		
		for (Book book : books) {
			String url = "/wangkai/PurchaseServlet?id=" + book.getId();
			out.write(book.getName() + "&nbsp&nbsp&nbsp&nbsp<a href='" + url + "'>点击剁手</a><br>");
		}
		
		response.getWriter().print("<br>=======<br>");
		response.getWriter().print("&nbsp&nbsp<a href='/wangkai/LogoutServlet'>账户退出</a>");
		response.getWriter().print("<br>=======<br>");
		
		response.getWriter().print("<a href='/wangkai/CartServlet'>查看购物车</a>");
		response.getWriter().print("<br>=======<br>");
		
	}
}
