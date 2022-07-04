package leetcodepractice;
/////////////////////////////////////////////////////////////////////////////
// Property of Informatica.
// (C) Copyright 2020 Informatica LLC
// All Rights Reserved.
/////////////////////////////////////////////////////////////////////////////

public class LeetCode29
{
   public int divide(int dividend, int divisor, int count, int i)
   {
      if (dividend < divisor || dividend == 0)
      {
         return count;
      }
      // if (i > 0 && dividend == Integer.MAX_VALUE && divisor == 1)
      // return Integer.MAX_VALUE;
      //
      while (dividend >= divisor)
      {
         if (i < 0 && count == Integer.MAX_VALUE - 1)
         {
            count = Integer.MIN_VALUE;
         }
         else
            count = count + 1;
         dividend = dividend - divisor;
      }
      return count;
   }

   public int divide(int dividend, int divisor)
   {
      int i = 1;
      if (dividend < 0 && divisor < 0)
      {
         i = 1;
         if (dividend == Integer.MIN_VALUE)
         {
            dividend = Integer.MAX_VALUE;
         }
         else
         {
            dividend = dividend * -1;
         }
         if (divisor == Integer.MIN_VALUE)
            divisor = Integer.MAX_VALUE;
         else
         {
            divisor = divisor * -1;
         }
      }
      else
      {
         if (divisor < 0)
         {
            i = -1;
            if (divisor == Integer.MIN_VALUE)
               divisor = Integer.MAX_VALUE;
            else
               divisor = Math.abs(divisor);
         }
         if (dividend < 0)
         {
            i = -1;
            if (dividend == Integer.MIN_VALUE)
            {
               dividend = Integer.MAX_VALUE;
            }
            else
               dividend = Math.abs(dividend);
         }
      }

      return divide(dividend, divisor, 0, i) == Integer.MIN_VALUE ? Integer.MIN_VALUE
            : divide(dividend, divisor, 0, i) * i;
   }

   public static void main(String[] args)
   {
      LeetCode29 soln = new LeetCode29();
      System.out.println(soln.divide(2147483647, 2));
   }

}
