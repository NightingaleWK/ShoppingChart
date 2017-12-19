package wangkai;
import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class CartServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 变量cart引用用户的购物车
		List<Book> cart = null;
		// 变量pruFlag标记用户是否买过商品
		boolean purFlag = true;
		// 获得用户的session
		HttpSession session = request.getSession(false);
		// 如果session为null，purFlag置为false
		if (session == null) {
			purFlag = false;
		} else {
			// 获得用户购物车
			cart = (List) session.getAttribute("cart");
			// 如果用的购物车为null，purFlag置为false
			if (cart == null) {
				purFlag = false;
			}
		}
		/*
		 * 如果purFlag为false，表明用户没有购买图书 重定向到ListServlet页面
		 */
		if (!purFlag) {
			out.write("对不起！您还没有购买任何商品！<br>");
		} else {
			// 否则显示用户购买图书的信息
			out.write("==========================<br>");
			out.write("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp以下是您选购的图书，请查阅<br>");
			out.write("==========================<br><br>");
			double price = 0;
			for (Book book : cart) {
				out.write(book.getName() + "<br>");
			}
			response.getWriter().print("<br>============<br>");
			response.getWriter().print("&nbsp&nbsp&nbsp&nbsp<a href='/wangkai/ListBookServlet'>返回书籍列表</a>");
			response.getWriter().print("<br>============<br>");
		}
	}
}
