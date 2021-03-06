package wangkai;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("check_code");
		String savedCode = (String) request.getSession().getAttribute(
				"check_code");
		PrintWriter pw = response.getWriter();
		if (("wk").equals(username) && ("wk").equals(password)
				&& checkCode.equals(savedCode)) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/wangkai/IndexServlet");
		} else if (checkCode.equals(savedCode)) {
			pw.write("用户名或密码错误，登录失败(；´д｀)ゞ");
		} else {
			pw.write("验证码错误(╥╯^╰╥)");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
