ackage garytest;

import java.sql.Connection;
import java.sql.SQLException;



public class Test {
	

	

	public static void main(String[] args) throws SQLException {
		System.out.println("ok-begin");
		Connection conn = null;
		Connection conn2 = null;

		try{
			
			for (int i=1;i<=10;i++){
				conn = C3P0Utils.getInstance().getConnection();	
				System.out.println("~"+i+conn);
				conn.close();
				Thread.sleep(10*1000);
			}

			System.out.println("debug");
			conn = C3P0Utils.getInstance().getConnection();	
			conn2 = C3P0Utils.getInstance().getConnection();	
			System.out.println("last2~begin");
			Thread.sleep(10*1000);
			conn.close();
			conn2.close();
			System.out.println("last2~end");
			Thread.sleep(15*1000);

			
		} catch (SQLException e) {
			System.out.println("失败:" + e.getMessage());
		}catch (Exception e1) {
			System.out.println("失败:" + e1.getMessage());
		}finally{
			
			System.out.println("ok-fi");
		}
		System.out.println("ok-end");
		
	}

}
