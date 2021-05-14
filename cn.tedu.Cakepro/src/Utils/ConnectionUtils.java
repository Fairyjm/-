package Utils;
import java.io.IOException;
import java.io.InputStream;
/**
 * ���������ӵĹ�����
 * @author 15806
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class ConnectionUtils {
	//���ڻ�ȡ��ǰ��Ϣ�þ�̬�����ȡ
	private static String driver=null;
	private static String username=null;
	private static String password=null;
	private static String url=null;
	private static Properties props=new Properties();
	//��֤ÿ���߳���ֻ��һ�����ӣ�������Դ�˷�
	private static ThreadLocal<Connection> tl=new ThreadLocal(); 
	/**
	 * �þ�̬�Ĵ�����ȡdb.priperties
	 */
	static {
		try {
			//���������ȡ�ļ�,���������ķ�ʽ��ȡ��Դ
			InputStream in=ConnectionUtils.class.getClassLoader().getResourceAsStream("db.properties");
			props.load(in);
			
			driver=props.getProperty("jdbc.driver");
			url=props.getProperty("jdbc.url");
			username=props.getProperty("jdbc.username");
			password=props.getProperty("jdbc.password");
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		/**
		 * ��ȡ���ӵķ���
		 */
	
		public static Connection getConn() throws Exception{
		//�ȴ�tl�л�ȡ
		Connection conn=tl.get();
        if(conn==null){
            conn=DriverManager.getConnection(url,password,username);
        tl.set(conn);
		}
		return conn;//����
		}
		 /**
		 * �ر����ӵķ��� 
		 */
		public static void closeConn() throws Exception{
		Connection conn=tl.get();
		if(conn!=null) {
			conn.close();
		}
		tl.set(null);
		}
		public static  void main(String[] args)throws Exception{
			Connection c=getConn();
			Connection c1=getConn();
			System.out.println(c==c1);
		}
	}
	
