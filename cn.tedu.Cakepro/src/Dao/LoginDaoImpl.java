package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Pojo.User;
import Utils.ConnectionUtils;

public class LoginDaoImpl implements LoginDao {
//LoginServlet
	@Override
	public User checkLoginDao(String uname, String pwd) {
		//����JDBC����
		//Connection conn=null;//���Ӷ���
		PreparedStatement ps=null;//�������
		ResultSet rs=null;//���������
		//�������ݴ洢����
		User u=null;
		
		try {
			
			//ͨ����װ�ഴ�����Ӷ���
			Connection conn=ConnectionUtils.getConn();
			//sql����
			String sql="SELECT * FROM t_user WHERE uname=? AND pwd=?";
			//����sql����
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setString(1, uname);
			ps.setString(2, pwd);
			//ִ��
			rs=ps.executeQuery();
			//����ִ�н��
			while(rs.next()) {
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//ps.close();
			ConnectionUtils.closeConn();	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return u;
	}
//registServlet
	@Override
	public User checkLoginDao(String uname) {

		//����JDBC����
		//Connection conn=null;//���Ӷ���
		PreparedStatement ps=null;//�������
		ResultSet rs=null;//���������
		//�������ݴ洢����
		User u=null;
		
		try {
			
			//ͨ����װ�ഴ�����Ӷ���
			Connection conn=ConnectionUtils.getConn();
			//sql����
			String sql="SELECT * FROM t_user WHERE uname=?";
			//����sql����
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setString(1, uname);
			//ps.setString(2, pwd);
			//ִ��
			rs=ps.executeQuery();
			//����ִ�н��
			while(rs.next()) {
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				return u;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//ps.close();
			ConnectionUtils.closeConn();	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	//�û���Ϣע��ɹ����������
	@Override
	public void insertUser(String uname, String pwd) {
		try {
	Connection conn=ConnectionUtils.getConn();
	String sql="insert into t_user (uname,pwd)value(?,?)";
	PreparedStatement  ps= conn.prepareStatement(sql);
	ps.setString(1, uname);
	ps.setString(2, pwd);
	//executeUpdate()ִ����ɾ��sql����
	ps.executeUpdate();
		}catch(Exception e) {		
			  try {
				ConnectionUtils.closeConn();
			} catch (Exception e1) {
				e1.printStackTrace();
			}		
}
		}
	}

