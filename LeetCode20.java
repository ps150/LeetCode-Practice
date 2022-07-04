package leetcodepractice;
import java.util.Stack;

public class LeetCode20
{

   char[] openParanthesisArr = { '(', '{', '[', };

   char[] closeParanthesisArr = { ')', '}', ']' };

   public boolean isValid(String s)
   {
      boolean isValid = false;
      if (s.length() == 0 || s == null)
      {
         return true;
      }

      Stack<Character> characterStack = new Stack<Character>();
      char[] charactersArr = s.toCharArray();
      if (isCloseParanthesis(charactersArr[0]))
         return false;

      characterStack.push(charactersArr[0]);
      int currentIndex = 1;
      while (!characterStack.isEmpty() || currentIndex < charactersArr.length)
      {
         if (currentIndex >= charactersArr.length)
         {
            return isValid;
         }
         
         if (isCloseParanthesis(charactersArr[currentIndex]))
         {
            if (!characterStack.isEmpty() && getCounterPart(charactersArr[currentIndex]) == characterStack.peek())
            {
               characterStack.pop();
               currentIndex = currentIndex + 1;
               if (characterStack.isEmpty())
               {
                  isValid = true;
               }
               else
               {
                  isValid = false;
               }
            }
            else
            {
               return false;
            }
         }
         else
         {
            characterStack.push(charactersArr[currentIndex]);
            currentIndex = currentIndex + 1;
            isValid = false;
         }
      }
      return isValid;
   }

   private boolean isCloseParanthesis(char c)
   {
      for (int i = 0; i < closeParanthesisArr.length; i++)
      {
         if (closeParanthesisArr[i] == c)
         {
            return true;
         }
      }
      return false;
   }

   private char getCounterPart(char c)
   {
      switch (c)
      {

         case ')':
            return '(';

         case '}':
            return '{';

         case ']':
            return '[';

         default:
            return ':';
      }
   }

   public static void main(String[] args)
   {
      String s = "()[]}{";
      System.out.println(new LeetCode20().isValid(s));
   }
}
