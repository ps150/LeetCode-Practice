package leetcodepractice;
import java.util.Arrays;

public class LeetCode16 {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int loopMin = Integer.MAX_VALUE;
		int result = 0;
		boolean isFound = false;
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int targetSum = nums[j] + nums[k];
				int currentMin = targetSum + nums[i];
				int diff = currentMin - target;
				int dist = getMod(diff);
				if (diff < 0) {
					if (dist < loopMin) {
						loopMin = dist;
						result = currentMin;
					}
					j = j + 1;
				} else if (diff > 0) {
					if (dist < loopMin) {
						loopMin = dist;
						result = currentMin;
					}
					k = k - 1;
				}
				if (dist == 0) {
					result = currentMin;
					isFound = true;
					break;
				}
			}
			if (isFound)
				break;
		}
		return result;
	}

	private int getMod(int i) {
		if (i < 0) {
			return i * -1;
		}
		return i;
	}

	public static void main(String[] args) {
		int[] nums = { 4, -1, -4, 4 };

		int target = -1;
		LeetCode16 soln = new LeetCode16();
		System.out.println(soln.threeSumClosest(nums, target));
	}
}
