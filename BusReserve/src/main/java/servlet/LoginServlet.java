package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utl.Check;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * 既存の場合のフォーム入力後遷移
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String frontPath = "/WEB-INF/jsp/";
		String fPath = "index.jsp";

		String error_msg = "";

		String firstName = null;
		String lastName = null;
		String strTel = null;
		int telNo = 0;
		boolean regFlag = false; // 登録判別フラグ (true: 登録 / false: 確認)

		// リクエストパラメータの取得
		try {
			// 確認
			firstName = request.getParameter("fName");
			lastName = request.getParameter("lName");
			strTel = request.getParameter("telNo");
		} catch (Exception e1) {
			System.out.println("「確認」の欄に入力されていません");
			try {
				// 登録
				firstName = request.getParameter("fNameR");
				lastName = request.getParameter("lNameR");
				strTel = request.getParameter("telNoR");
				regFlag = true;
			} catch (Exception e2) {
				System.out.println("「登録」の欄に入力されていません");
			}
		}

		if (firstName == null || lastName == null || strTel == null ||
				firstName == "" || lastName == "" || strTel == "") {
			error_msg += "どこかの欄が抜けています\n";
			System.out.println("どこかの欄が抜けています");
			fPath = "index.jsp";
		} else if (strTel.length() != 11) {
			error_msg += "電話番号の桁が間違えています\n";
			System.out.println("電話番号の桁が間違えています\n");

			try {
				Integer.parseInt(strTel);
			} catch (NumberFormatException e) {
				System.out.println(strTel);
				error_msg += "電話番号が数値ではありません\n";
				System.out.println("電話番号が数値ではありません\n");
			}
			fPath = "index.jsp";
		} else {
			System.out.println("name = " + firstName + " " + lastName + " tel = " + strTel);
			fPath = frontPath + (regFlag ? "register.jsp" : "verification.jsp");
		}

		// エラーメッセージの埋め込み
		request.setAttribute("error_msg", error_msg);

		// ログイン結果画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(fPath);
		dispatcher.forward(request, response);
	}

}
