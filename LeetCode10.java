
package leetcodepractice;

public class LeetCode10
{
   private final static char starChar = '*';

   private final static char pointChar = '.';

   public boolean isMatch(String s, String p)
   {
      int patternIndex = 0;
      char previousChar = ' ', currentChar;
      boolean isValid = true;
      for (int i = 0; i < s.length(); i++)
      {
         currentChar = s.charAt(i);
         if (patternIndex >= p.length())
         {
            return false;
         }
         else
         {
            if (patternIndex + 1 < p.length() && p.charAt(patternIndex) == pointChar
                  && (patternIndex + 1 < p.length() || p.charAt(patternIndex + 1) == starChar))
            {
               isValid = true;
               break;
            }
         }
         switch (p.charAt(patternIndex))
         {
            case starChar:
               if (currentChar == previousChar)
               {
                  isValid = true;
               }
               else
               {
                  patternIndex = patternIndex + 1;
                  if (patternIndex < p.length()
                        && (p.charAt(patternIndex) == currentChar || p.charAt(patternIndex) == pointChar))
                  {
                     isValid = true;
                     previousChar = currentChar;
                  }
                  else
                  {
                     isValid = false;
                  }
               }
               break;
            case pointChar:
               isValid = true;
               patternIndex = patternIndex + 1;
               previousChar = currentChar;
               break;
            default:
               if (p.charAt(patternIndex) == currentChar)
               {
                  isValid = true;
                  patternIndex = patternIndex + 1;
                  previousChar = currentChar;
               }
               else
               {
                  if (patternIndex + 1 < p.length() && p.charAt(patternIndex + 1) == starChar)
                  {
                     isValid = true;
                     patternIndex = patternIndex + 2;
                     i = i - 1;
                  }
                  else
                  {
                     isValid = false;
                  }
               }
               break;
         }

         if (!isValid)
         {
            break;
         }
      }
      return isValid;
   }

   public static void main(String[] args)
   {
      LeetCode10 soln = new LeetCode10();
      String str = "mississipp";
      String pattern = "mis*is*ip*";
      System.out.println(soln.isMatch(str, pattern));
   }

}
