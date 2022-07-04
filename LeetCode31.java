package leetcodepractice;

public class LeetCode31 {

	public void nextPermutation(int[] nums) {
		int length = nums.length - 1;
		for (int i = length; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				for (int j = length; j >= i; j--) {
					if (nums[j] > nums[i - 1]) {
						int temp = nums[j];
						nums[j] = nums[i - 1];
						nums[i - 1] = temp;
						reverse(nums, i, length);
						return;
					}
				}
			}

		}
		reverse(nums, 0, length);
	}

	public void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

	}

	public static void main(String[] args) {
		LeetCode31 solution = new LeetCode31();
		int[] numArr = { 4, 5, 6, 8, 7, 3 };
		solution.nextPermutation(numArr);

		for (int i = 0; i < numArr.length; i++) {
			System.out.println(numArr[i]);
		}

	}

}
