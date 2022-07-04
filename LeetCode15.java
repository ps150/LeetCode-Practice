package leetcodepractice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode15 {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> outPut = new ArrayList<List<Integer>>();
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				break;
			}
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int temp = nums[j] + nums[k];
				temp = temp + nums[i];
				if (temp > 0) {
					k = k - 1;
				} else if (temp < 0) {
					j = j + 1;
				} else if (temp == 0) {
					if (!resultMap.containsKey(nums[i] + "*" + nums[j] + "*" + nums[k])) {
						Integer[] values = { nums[i], nums[j], nums[k] };
						List<Integer> list = Arrays.asList(values);
						outPut.add(list);
						resultMap.put(nums[i] + "*" + nums[j] + "*" + nums[k], true);
					}
					j = j + 1;
					k = k - 1;
				}
			}
		}
		return outPut;
	}

	public static void main(String[] args) {

		int[] nums = { 0, 0, 0 };
		LeetCode15 soln = new LeetCode15();
		List<List<Integer>> outPut = soln.threeSum(nums);
		for (List<Integer> items : outPut) {
			for (Integer i : items) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
