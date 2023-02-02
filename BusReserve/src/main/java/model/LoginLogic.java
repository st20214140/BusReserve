package model;

import dao.UserDAO;

public class LoginLogic {
	/**
	 * excuteメソッド<br>
	 * ログインに関する処理を提供します。（ダミー処理）<br>
	 * 今回はパスワードが1234の時に認証が成功します。<br>
	 * @param UserBean(ユーザー情報のユーザ名／電話番号)<br>
	 * @return true…認証成功 / false…認証失敗
	 */
	public boolean excute(UserBean user) {
		// UserDAOをインスタンス化
		UserDAO userDAO = new UserDAO();
		// ユーザーIDの全リストを取得
		String userId = userDAO.findElement();
		
		/*findElement
		 * 
		 * 
		 */
		
		// 取得したレコードの内容を出力
		System.out.println("** EmployeeDAOを使った場合 ***");
		for (EmployeeBean emp : empList) {
			System.out.println("ID"   + emp.getId());
			System.out.println("名前" + emp.getName());
			System.out.println("年齢" + emp.getAge() + "\n");
		}
	}
}
