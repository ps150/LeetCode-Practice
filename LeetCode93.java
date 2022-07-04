package leetcodepractice;

public class LeetCode93
{
   public int restoreIpAddresses(String s)
   {

      int length = s.length();
      return countPossible(s, 1, 0, length);
   }

   private int countPossible(String str, int currentsec, int currentIndex, int strLength)
   {
      int remainingItemCount = strLength - currentIndex;
      if (currentsec > 5)
         return 0;
      if (remainingItemCount < 0)
         return 0;
      if (remainingItemCount == 0 && currentsec == 5)
         return 1;
      if (currentsec == 4 && remainingItemCount > 3)
         return 0;
      if (currentsec == 3 && (remainingItemCount > 6 || remainingItemCount < 2))
         return 0;
      if (currentsec == 2 && (remainingItemCount > 9 || remainingItemCount < 3))
         return 0;
      if (currentsec == 1 && (remainingItemCount > 12 || remainingItemCount < 4))
         return 0;
      
      int count;
      count = countPossible(str, currentsec + 1, currentIndex + 1, strLength);
      
      if (currentIndex < str.length() && currentIndex >= 0 && str.charAt(currentIndex) != '0')
         count = count + countPossible(str, currentsec + 1, currentIndex + 2, strLength);
      
      if (currentIndex < str.length() && currentIndex >= 0 && str.charAt(currentIndex) != '0'
            && ((str.charAt(currentIndex) < '3')
                  && (str.charAt(currentIndex) == '2' && str.charAt(currentIndex + 1) < '6')
                  || str.charAt(currentIndex) == '1'))
         count = count + countPossible(str, currentsec + 1, currentIndex + 3, strLength);
      
      return count;
   }

   public static void main(String[] args)
   {
      LeetCode93 soln = new LeetCode93();
      System.out.println(soln.restoreIpAddresses("023405"));
   }

}
