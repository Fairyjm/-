package Dao;

import Pojo.User;

public interface LoginDao {
	//��¼��Ϣ��Ҫ��֤�û���
	User checkLoginDao(String uname,String pwd);
	
	User checkLoginDao(String uname);
	//����ע����Ϣ�������ݵķ���
	public void insertUser(String uname,String pwd);
	
}
