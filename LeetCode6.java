package leetcodepractice;
//Zig-Zag conversion
public class LeetCode6
{
	private String convert(String s, int numRows)
	{
		String result = "";
		int length = s.length();
		for (int i = 0; i < numRows; i++)
		{
			int currentItemIndex = i;
			boolean even = true;
			while (currentItemIndex < length)
			{

				result = result + s.charAt(currentItemIndex);
				if(numRows == 1) {
					currentItemIndex = currentItemIndex + 1;
					continue;
				}
				if (i == 0 || i == numRows - 1)
					currentItemIndex = currentItemIndex + ((numRows - 1) * 2);
				else
				{
					if (even)
					{
						currentItemIndex = (currentItemIndex) + ((numRows - 1 - i) * 2);
						even = false;
					}
					else
					{
						currentItemIndex = currentItemIndex + (i * 2);
						even = true;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args)
	{
		LeetCode6 solution = new LeetCode6();
		System.out.println(solution.convert("A", 1));
	}
}
