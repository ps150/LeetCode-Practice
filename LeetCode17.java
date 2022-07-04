package leetcodepractice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {
	static Map<String, String> phone = new HashMap<>();
	List<String> outputs = new ArrayList<>();

	static {
		phone.put("2", "abc");
		phone.put("3", "def");
		phone.put("4", "ghi");
		phone.put("5", "jkl");
		phone.put("6", "mno");
		phone.put("7", "pqrs");
		phone.put("8", "tuv");
		phone.put("9", "wxyz");
	}

	private void calculateCobination(String pattern, String digits) {

		if (digits.length() == 0) {
			outputs.add(pattern);
		} else {
			String digit = digits.substring(0, 1);
			String letters = phone.get(digit);
			for (int i = 0; i < letters.length(); i++) {
				calculateCobination(pattern + letters.substring(i, i + 1), digits.substring(1));
			}
		}
	}

	public List<String> letterCombinations(String digits) {
		if(digits.length() > 0) {
			calculateCobination("", "");
		}
		return outputs;
	}

	public static void main(String[] args) {
		LeetCode17 leetCode17 = new LeetCode17();
		leetCode17.letterCombinations("23");
		for (int i = 0; i < leetCode17.outputs.size(); i++) {
			System.out.println(leetCode17.outputs.get(i));
		}

	}

}
