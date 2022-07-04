package leetcodepractice;
public class LeetCode12 {
	public String intToRoman(int num) {
		int arr[] = { 1, 5, 10, 50, 100, 500, 1000 };
		char romaChars[] = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		String finalResult = "";
		int length = arr.length;
		int index = length - 1;
		while (num != 0) {
			if (num >= arr[index]) {
				int frequecy = num / arr[index];

				for (int j = 0; j < frequecy; j++) {
					finalResult = finalResult + romaChars[index];
				}
				num = num % arr[index];
			} else {
				if (arr[index] == 1000 || arr[index] == 500) {
					if (num >= arr[index] - 100) {
						finalResult = finalResult + "C" + romaChars[index];
						num = num % 100;
					}
					index--;
				} else if (arr[index] == 50 || arr[index] == 100) {
					if (num >= arr[index] - 10) {
						finalResult = finalResult + "X" + romaChars[index];
						num = num % 10;
					}
					index--;
				} else if (arr[index] == 5 || arr[index] == 10) {
					if (num >= arr[index] - 1) {
						finalResult = finalResult + "I" + romaChars[index];
						num = 0;

					}

					index--;
				}

			}
		}
		return finalResult;
	}

	public static void main(String args[]) {
		LeetCode12 soln = new LeetCode12();
		System.out.println(soln.intToRoman(1994));
	}
}
