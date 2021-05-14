package Servlet;
/**
 * ע����
 * 
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LoginDao;
import Dao.LoginDaoImpl;
import Pojo.User;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ע�Ṧ�ܵ�ʵ�֣�
		//1.��ȡ�û��ύ���û���Ϣ
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		//2.�ж��û����Ƿ����
		 LoginDao loginDao=new LoginDaoImpl();
		 User u=loginDao.checkLoginDao(uname);
		 if(u!=null) {
			//ע��ʧ��
			 request.setAttribute("registmsg", "�û��Ѿ�ע�����");
			 request.getRequestDispatcher("regist.jsp").forward(request,response);			 
		 }else {
			 //ע��ɹ�
			//3.���û���Ϣ���뵽���ݿ�
			 loginDao.insertUser(uname, pwd);
		 }
		//4.ע��ɹ���ȥ��¼ҳ�棬ע��ʧ�ܣ��ص�ע��ҳ�沢�ҽ���ʧ����ʾ
		 response.sendRedirect("login.jsp");
		 
	}

}
