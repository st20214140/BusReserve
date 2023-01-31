package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import model.EmployeeBean;

//import java.sql.*;

public class UserDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://localhost/R2A403DB";
	private final String DB_USER = "R2A403";
	private final String DB_PASS = "passwd";
	
	public List<EmployeeBean> findAll() {
		List<EmployeeBean> empList = new ArrayList<EmployeeBean>();
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = "SELECT ID, NAME, AGE FROM EMPLOYEE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容を
			// Employeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String id   = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				EmployeeBean employeeBean = new EmployeeBean(id, name, age);
				empList.add(employeeBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
}
