package leetcodepractice;
/////////////////////////////////////////////////////////////////////////////
// Property of Informatica.
// (C) Copyright 2020 Informatica LLC
// All Rights Reserved.
/////////////////////////////////////////////////////////////////////////////

public class LeetCode55
{

   public boolean canJump(int[] nums)
   {
      boolean isValid = true;
      int target = nums.length - 2;
      int lastValidIndex = nums.length - 1;

      while (target >= 0)
      {
         if (nums[target] + target >= lastValidIndex)
         {
            isValid = true;
            lastValidIndex = target;
         }
         else
         {
            isValid = false;
         }
         target--;

      }
      return isValid;

   }

   public static void main(String[] args)
   {
      int nums[] = { 3, 2, 1, 0, 4 };
      LeetCode55 soln = new LeetCode55();
      System.out.println(soln.canJump(nums));
   }

}
