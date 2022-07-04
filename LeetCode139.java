package leetcodepractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LeetCode139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		HashSet<String> dictSet = new HashSet<String>();
		for (String str : wordDict)
			dictSet.add(str);
		return isBreakPossible(s, map, dictSet);

	}

	private boolean isBreakPossible(String str, Map<String, Boolean> map, HashSet<String> dictSet) {
		if (str.length() == 0)
			return true;

		if (map.containsKey(str))
			return map.get(str);

		for (int i = 0; i <= str.length(); i++) {
			String currentSubStr = str.substring(0, i);
			if (map.getOrDefault(currentSubStr, false)) {
				map.put(currentSubStr, true);
				String remainStr = str.substring(i, str.length());
				if (isBreakPossible(remainStr, map, dictSet)) {
					return true;
				}
			} else if (isPresentInDic(currentSubStr, dictSet)) {
				map.put(currentSubStr, true);
				String remainStr = str.substring(i, str.length());
				if (isBreakPossible(remainStr, map, dictSet)) {
					return true;
				}
			}

		}
		map.put(str, false);
		return false;

	}

	private boolean isPresentInDic(String aCurrentSubStr, HashSet<String> dictSet) {
		if (dictSet.contains(aCurrentSubStr))
			return true;

		return false;

	}

	public static void main(String[] args) {
		LeetCode139 soln = new LeetCode139();
		String str = "iloveicecreamandmango";
		String[] strArr = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "love",
				"ice", "cream" };
		List<String> wordDic = Arrays.asList(strArr);
		//
		// wordDic.add("aaaa");
		// wordDic.add("aaa");

		System.out.println(soln.wordBreak(str, wordDic));
	}

}
