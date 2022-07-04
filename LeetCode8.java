package leetcodepractice;
public class LeetCode8
{
	public int myAtoi(String str)
	{
		int length = str.length();
		if(length <= 0)
			return 0;
		boolean positiveSignFound = false;
		boolean negativeSignFound = false;
		boolean isDigitFound = false;
		boolean isGoodString = false;
		String finalString = "";
		for (int i = 0; i < length; i++)
		{
			if (str.charAt(i) == '-')
			{
				if (positiveSignFound || negativeSignFound || isDigitFound)
					break;
				else
				{
					negativeSignFound = true;
					isGoodString = true;
					finalString = finalString + str.charAt(i);
				}
			}
			else if (str.charAt(i) == '+')
			{
				if (positiveSignFound || negativeSignFound || isDigitFound)
					break;
				else
				{
					positiveSignFound = true;
					isGoodString = true;
					finalString = finalString + str.charAt(i);
				}
			}
			else
			{
				if (Character.isDigit(str.charAt(i)))
				{
					finalString = finalString + str.charAt(i);
					isGoodString = true;
					isDigitFound = true;
				}
				else if (str.charAt(i) == ' ')
				{
					if(isGoodString)
						break;
				}
				else
				{
					isGoodString = false;
					break;
				}
			}
		}

		if (isDigitFound )
		{
			try
			{
				return Integer.valueOf(finalString);
			}
			catch (NumberFormatException e)
			{
				if (finalString.startsWith("-"))
					return (int) Math.pow(-2, 31);
				else
					return (int) Math.pow(2, 31);
			}
		}
		return 0;
	}

	public static void main(String args[])
	{
		LeetCode8 soln = new LeetCode8();
		System.out.println(soln.myAtoi("   -42-"));
	}
}
