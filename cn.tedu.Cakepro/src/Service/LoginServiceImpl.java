package Service;

import Dao.LoginDao;
import Dao.LoginDaoImpl;
import Pojo.User;

public class LoginServiceImpl implements LoginService{
	//������ת
	//ʵ��Dao�����ݹ���
	LoginDao ld=new LoginDaoImpl();
	public User checkLoginService(String uname, String pwd){
		
		return ld.checkLoginDao(uname, pwd);
}
}