package leetcodepractice;
public class LeetCode7
{
	public int reverse(int x)
	{
		int result = 0;
		boolean isNegative = false;
		if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE)
		{
			return 0;
		}
		if (x < 0)
		{
			isNegative = true;
			x = x * -1;
		}
		while (x > 0)
		{
			int reminder = x % 10;
			result = result * 10 + reminder;
			x = x / 10;
		}
		if (isNegative)
			result = result * -1;
		return result;
	}

	public static void main(String[] args)
	{
		LeetCode7 soln = new LeetCode7();
		System.out.println(soln.reverse(1534236469));

	}
}
