package Servlet;
/**
 * 
 * ������������
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Pojo.User;
import Service.LoginService;
import Service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������������ʽ
		request.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		response.setContentType("text/html;charset=utf-8");
		
		//��ȡ����
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		System.out.println(uname+":"+pwd);
		
		//��������
	    //��ȡҵ������
		LoginService ls=new LoginServiceImpl();
		//���÷�������У���û���Ϣ
		User u=ls.checkLoginService(uname, pwd);
		System.out.println(u);
		//��Ӧ������
		if(u!=null) {
			//��¼�û����õ�session��
			HttpSession session=request.getSession();
			
			session.setAttribute( "loginUser", u);
			//response.getWriter().write("һҹ����");
			response.sendRedirect("index.jsp");
		}else {
        //��¼ʧ�ܺ��ٴ�������½ҳ��
	    //ͨ���ض���ķ�ʽȥ��¼ҳ��
		//response.sendRedirect("Login.jsp");
		/*
		 * ��ת����д	
		 */
		//׼��ת������֮ǰ�������ݣ�������Ҫ������һ�������������ݰ󶨵�������
		request.setAttribute("msg", "�û�������������󣡣�");	
			
		//��ȡת����
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	    //��ʼת��
		rd.forward(request, response);
		
			

         
		}
		
		
	}

}
