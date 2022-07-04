package leetcodepractice;

public class LeetCode165
{
   public int compareVersion(String version1, String version2)
   {
      int result = 0;
      String[] strTokens = version1.split("\\.");
      String[] str2Token = version2.split("\\.");
      int index1 = 0, index2 = 0;
      while (index1 < strTokens.length || index2 < str2Token.length)
      {
         int firstV = index1 < strTokens.length ? Integer.parseInt(strTokens[index1]) : 0;
         int secondV = index2 < str2Token.length ? Integer.parseInt(str2Token[index2]) : 0;
         if (firstV > secondV)
            return 1;
         else if (secondV > firstV)
            return -1;
         index1++;
         index2++;
      }
      return result;
   }

   public static void main(String[] args)
   {

      String str1 = "1.0";
      String str2 = "1";

      LeetCode165 soln = new LeetCode165();
      System.out.println(soln.compareVersion(str1, str2));

   }

}
