package leetcodepractice;

public class LeetCode5
{
   public String longestPalindrome(String s)
   {
      int strLength = s.length();
      // Iterate over string and compare left and right.
      int start = 0;
      int end = 0;
      for (int i = 0; i < strLength; i++)
      {
         // odd length
         int oddStrLen = expandStr(s, i, i);
         int evenStrLen = expandStr(s, i, i + 1);
         int len = Math.max(oddStrLen, evenStrLen);
         if (len % 2 == 0)
         {
            if (len > (end - start + 1))
            {
               start = i - (len / 2 - 1);
               end = i + (len / 2);
            }
         }
         else
         {
            if (len > (end - start + 1))
            {
               start = i - (len / 2);
               end = i + (len / 2);
            }
         }
      }
      return s.substring(start, end + 1);
   }

   private int expandStr(String aS, int left, int right)
   {
      int len = 0;

      if (left == right)
      {
         left--;
         right++;
         len = 1;
      }
      else
         len = 0;
      while (left >= 0 && right < aS.length() && aS.charAt(left) == aS.charAt(right))
      {
         len = len + 2;
         left--;
         right++;
      }
      return len;
   }

   public static void main(String[] args)
   {
      String str = "cbbd";
      LeetCode5 soln = new LeetCode5();
      System.out.println(soln.longestPalindrome(str));
   }

}
