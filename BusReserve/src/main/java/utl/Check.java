package utl;

public class Check {
	public int NumCheck(String checkTarget) {
		int number = -1;
		try {
			number = Integer.parseInt(checkTarget);
		} catch (NumberFormatException e) {
			return number;
		}
		return number;
	}
	
	public String NumErrorMsg(int checkTarget) {
		return (Check.NumCheck(checkTarget) == -1 ? "" : "数値ではありません");
	}
}
