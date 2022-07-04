package leetcodepractice;
import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {

	String s1 = "(";
	String s2 = ")";

	public List<String> generateParenthesis(int n) {
		List<String> targetList = new ArrayList<>();
		calculateParenthesis(0, 0, n, targetList, "");
		return targetList;

	}

	public void calculateParenthesis(int openCount, int closeCount, int n, List<String> targetList, String str) {
		if (openCount == closeCount && str.length() == n * 2) {
			targetList.add(str);
		} else if (openCount + closeCount > n * 2) {
			return;

		}
		calculateParenthesis(openCount + 1, closeCount, n, targetList, str + s1);
		if (closeCount < openCount)
			calculateParenthesis(openCount, closeCount + 1, n, targetList, str + s2);
	}

	public static void main(String[] args) {
		LeetCode22 leetcode22 = new LeetCode22();
		List<String> str = leetcode22.generateParenthesis(3);
		for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i));
		}
	}

}
