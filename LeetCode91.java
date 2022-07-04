package leetcodepractice;
public class LeetCode91
{

   public static void main(String[] args)
   {
      LeetCode91 soln = new LeetCode91();
      System.out.println(soln.numDecodings("111111111111111111111111111111111111111111111"));

   }

   public int numDecodings(String s)
   {
      // return recursion(s, s.length(), 0, 0);
      return iterativeWayToDecode(s);

   }

   private int iterativeWayToDecode(String str)
   {
      if (str.length() == 0)
         return 0;
      if (str.charAt(0) == '0')
         return 0;

      int prevCount = 1, prevPrevCount = 1;
      for (int i = 1; i < str.length(); i++)
      {
         int count = 0;
         if (str.charAt(i) != '0')
            count = prevCount;

         if (str.charAt(i - 1) == '1' || (str.charAt(i - 1) == '2' && str.charAt(i) < '7'))
         {
            count = count + prevPrevCount;
         }
         prevPrevCount = prevCount;
         prevCount = count;
      }
      return prevCount;
   }

   public int recursion(String s, int sLength, int sTempLength, int totalWays)
   {

      if (sTempLength == sLength)
      {
         return totalWays + 1;
      }
      else if (sTempLength > sLength)
      {
         return totalWays;
      }

      for (int i = 0; i < 2; i++)
      {

         if (i == 0 && s.charAt(sTempLength) == '0')
         {
            break;
         }
         else
         {
            sTempLength++;
         }

         if (i == 1)
         {
            if (sTempLength >= sLength)
               break;

            int test = Integer.parseInt(s.charAt(sTempLength - 1) + "" + s.charAt(sTempLength));
            if (test <= 26 && test > 0)
               sTempLength++;
            else
               break;
         }

         totalWays = recursion(s, sLength, sTempLength, totalWays);

         sTempLength--;
         if (i == 1)
            sTempLength--;
      }

      return totalWays;
   }

}
