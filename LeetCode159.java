package leetcodepractice;

import java.util.HashMap;
import java.util.Map;

public class LeetCode159
{
   public int lengthOfLongestSubstringTwoDistinct(String s)
   {
      return countLengthofSubStr(s);

   }

   private int countLengthofSubStr(String str)
   {
      Map<Character, Integer> charmap = new HashMap<Character, Integer>(3);
      int startIndex = 0;
      int endIndex = 0;

      int count = 0;
      while (endIndex < str.length())
      {
         char currentChar = str.charAt(endIndex);

         if (charmap.containsKey(currentChar) || charmap.size() <= 1)
         {
            charmap.put(currentChar, charmap.getOrDefault(currentChar, 0) + 1);
         }
         else
         {
            while (charmap.size() <= 2 && startIndex < endIndex)
            {
               int charSize = charmap.getOrDefault(str.charAt(startIndex), 0);
               charSize = charSize - 1;
               if (charSize <= 0)
               {
                  charmap.remove(str.charAt(startIndex));
                  charmap.put(currentChar, charmap.getOrDefault(currentChar, 0) + 1);
                  startIndex++;
                  break;
               }
               charmap.put(str.charAt(startIndex), charSize);
               startIndex++;
            }

         }
         if (count < endIndex - startIndex + 1)
         {
            count = endIndex - startIndex + 1;
         }
         endIndex++;
      }
      return count;
   }

   public static void main(String[] args)
   {

      String str = "abcabcabc";
      LeetCode159 soln = new LeetCode159();
      System.out.println(soln.lengthOfLongestSubstringTwoDistinct(str));

   }

}
