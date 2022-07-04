package leetcodepractice;

public class LeetCode121
{
   public int maxProfit(int[] prices)
   {
      int maxProfit = 0;
      int startIndex = 0;
      int endIndex = startIndex + 1;
      while (startIndex < prices.length && endIndex < prices.length)
      {
         if (prices[endIndex] < prices[startIndex])
         {
            startIndex = endIndex;
            endIndex++;
         }
         else
         {
            int currentProf = prices[endIndex] - prices[startIndex];
            if (currentProf > maxProfit)
            {
               maxProfit = currentProf;
            }
            endIndex++;
         }

      }
      return maxProfit;
   }

   public static void main(String[] args)
   {

      int[] arr = { 7, 1, 5, 3, 6, 4 };
      LeetCode121 soln = new LeetCode121();
      int s = soln.maxProfit(arr);
      System.out.println(s);
   }

}
