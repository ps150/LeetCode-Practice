/////////////////////////////////////////////////////////////////////////////
// Property of Informatica.
// (C) Copyright 2020 Informatica LLC
// All Rights Reserved.
/////////////////////////////////////////////////////////////////////////////
package leetcodepractice;

import java.util.HashMap;
import java.util.Map;

public class LeetCode45
{
   public int jump(int[] nums)
   {
      Map<Integer, Integer> indexToCountMap = new HashMap<Integer, Integer>();
      indexToCountMap.put(nums.length - 1, 0);
      for (int i = nums.length - 1; i >= 0; i--)
      {
         countSumRecursively(nums, i, 0, indexToCountMap);
      }
      return indexToCountMap.get(0);
   }

   private int countSumRecursively(int[] aNums, int currentIndex, int jumpCount, Map<Integer, Integer> aIndexToCountMap)
   {
      if (currentIndex >= aNums.length - 1)
         return jumpCount;

      if (aIndexToCountMap.containsKey(currentIndex) && aIndexToCountMap.get(currentIndex) != Integer.MAX_VALUE)
         return jumpCount + aIndexToCountMap.get(currentIndex);
      else if(aIndexToCountMap.containsKey(currentIndex))
      {
         return Integer.MAX_VALUE;
      }

      int frogJump = Integer.MAX_VALUE;
      for (int i = currentIndex + aNums[currentIndex]; i >= currentIndex + 1; i--)
      {
         int currentCount = countSumRecursively(aNums, i, jumpCount + 1, aIndexToCountMap);
         
         if(currentCount == Integer.MAX_VALUE)
            return frogJump;
         
         if (currentCount < frogJump)
            frogJump = currentCount;
      }
      aIndexToCountMap.put(currentIndex, frogJump);
      return frogJump;
   }

   public static void main(String[] args)
   {
      int[] nums = { 8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7,
            6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0,
            0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5 };
      LeetCode45 soln = new LeetCode45();
      System.out.println(soln.jump(nums));
   }

}
