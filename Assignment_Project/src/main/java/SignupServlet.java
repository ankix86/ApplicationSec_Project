import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.assignment.model.Signup;
import com.assignment.model.SignupDao;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SignupDao signupDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		signupDao = new SignupDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");
		String preferredName = request.getParameter("preferredName");
		String name = request.getParameter("name");


		Signup signup = new Signup();
		signup.setUserName(userName);
		signup.setUserEmail(userEmail);
		signup.setPassword(password);
		signup.setPreferredName(preferredName);
		signup.setName(name);

		try {
			signupDao.registerUser(signup);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("dbError", "Database error: " + e.getMessage());
			request.getRequestDispatcher("signup.jsp").forward(request, response);
			return;
		}
		request.setAttribute("signup", signup);
		request.getRequestDispatcher("userstatus.jsp").forward(request, response);
	}

}
