package leetcodepractice;
import java.util.ArrayList;

public class LeetCode43
{
   public String multiply(String num1, String num2)
   {
      String result = "0";
      ArrayList<Integer> resultArray = new ArrayList<Integer>();
      char[] num1Array = num1.toCharArray();
      char[] num2Array = num2.toCharArray();
      if ((num1Array.length == 1 && num1Array[0] == '0') || (num2Array.length == 1 && num2Array[0] == '0'))
         return result;
      int count = 0;
      for (int i = num1Array.length - 1; i >= 0; i--)
      {
         int a = Integer.parseInt(String.valueOf((num1Array[i])));
         int carry = 0;
         int index = count;
         for (int j = num2Array.length - 1; j >= 0; j--)
         {
            int b = Integer.parseInt(String.valueOf((num2Array[j])));
            int c = a * b + carry;

            if (resultArray.size() > index)
            {
               c = resultArray.get(index) + c;
               if (c > 9)
               {
                  carry = c / 10;
                  c = c % 10;
               }
               else
               {
                  carry = 0;
               }
               resultArray.set(index, c);
            }
            else
            {
               if (c > 9)
               {
                  carry = c / 10;
                  c = c % 10;
               }
               else
               {
                  carry = 0;
               }
               resultArray.add(c);
            }
            index = index + 1;
         }
         if (carry > 0)
         {
            resultArray.add(carry);
         }
         count = count + 1;
      }

      int counter = resultArray.size() - 1;
      while (counter >= 0)
      {
         if (result != "0")
         {
            result = result + resultArray.get(counter);
         }
         else
         {
            result = "" + resultArray.get(counter);
         }
         counter = counter - 1;
      }

      return result;
   }

   public static void main(String[] args)
   {

      String num1 = "408";
      String num2 = "52";

      LeetCode43 soln = new LeetCode43();
      String result = soln.multiply(num1, num2);

      System.out.println(result);
   }

}
