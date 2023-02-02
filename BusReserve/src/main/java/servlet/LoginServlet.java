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

		String error_msg = null;

		String firstName   = null;
		String lastName    = null;
		String callNumber = null;

		// リクエストパラメータの取得
			// 確認
		firstName = request.getParameter("fName");
		lastName = request.getParameter("lName");
		callNumber = request.getParameter("callNumber");
		System.out.println("「確認」の欄に入力されていません");
		
		// 入力チェック
		if (firstName == null || lastName == null || callNumber == null ||
				firstName == "" || lastName == "" || callNumber == "") {
			error_msg = "どこかの欄が抜けています";
		} else if (callNumber.length() != 11) {
			error_msg = "電話番号の桁が間違えています";
		} else {
			if (Check.checkString(callNumber)) {
				System.out.println("name = " + firstName + " " + lastName + " tel = " + callNumber);
//				fPath = frontPath + (regFlag ? "register.jsp" : "verification.jsp");
			}else {
				error_msg = "電話番号に文字が含まれています";
			}
		}
		System.out.println("ERR: " + error_msg);
		
		// エラーメッセージの埋め込み
		request.setAttribute("error_msg", error_msg);

		// ログイン結果画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(fPath);
		dispatcher.forward(request, response);
	}

}
