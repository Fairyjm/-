package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LoginDao;
import Dao.LoginDaoImpl;
import Pojo.User;

/**
 * Servlet implementation class CheckUsernameServlet
 */
public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //��ȡ���û���
		
		
		
		String uname=request.getParameter("uname");
		LoginDao loginDao=new LoginDaoImpl();
		User user=loginDao.checkLoginDao(uname);
		String msg="";
		if(user==null) {
			//�û�����ʹ��
			msg="0";
		}else {
			msg="1";
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(msg);
		//��������ƥ��
		//��ȡ���
	}
}
