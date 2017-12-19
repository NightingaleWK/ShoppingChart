package wangkai;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class IndexServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         // 解决乱码问题
		response.setContentType("text/html;charset=utf-8");
         // 创建或者获取保存用户信息的Session对象
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			response.getWriter().print("Oops！您还没有登录，请<a href='/wangkai/Login.html'>登录</a>");
		} else {
			response.getWriter().print("================<br>");
			response.getWriter().print("&nbsp&nbsp&nbsp登录成功!欢迎您," + user.getUsername() + "!<br>");
			response.getWriter().print("================<br>");
			
			response.getWriter().print("+---------+<br>");
			response.getWriter().print("+");
			response.getWriter().print("<a href='/wangkai/ListBookServlet'>进入购买</a>");
			response.getWriter().print("+<br>");
			
			response.getWriter().print("+---------+<br>");
			response.getWriter().print("+");
			response.getWriter().print("<a href='/wangkai/LogoutServlet'>账户退出</a>");
			response.getWriter().print("+<br>");
			response.getWriter().print("+---------+<br>");
			
			// 创建Cookie存放Session的标识号
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60 * 30);
			cookie.setPath("/wangkai");
			response.addCookie(cookie);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
