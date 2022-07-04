package leetcodepractice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode47
{
   public List<List<Integer>> permuteUnique(int[] nums)
   {
      List<List<Integer>> resultOutput = new ArrayList<List<Integer>>();
      Integer[] numss = new Integer[nums.length];
      for (int i = 0; i < nums.length; i++)
         numss[i] = nums[i];

      HashMap<String, Boolean> isItemPresent = new HashMap<String, Boolean>();
      calculatePermutation(resultOutput, 0, numss, isItemPresent);
      return resultOutput;
   }

   private void calculatePermutation(List<List<Integer>> aResultOutput, int aCurrentIndex, Integer[] aNums,
         HashMap<String, Boolean> isItemPresent)
   {
      if (aCurrentIndex == aNums.length)
      {
         List<Integer> copylist = Arrays.asList(aNums);
         ArrayList<Integer> copy = new ArrayList<Integer>(copylist);
         if (!aResultOutput.contains(copy))
         {
            aResultOutput.add(copy);
         }
      }
      for (int i = aCurrentIndex; i < aNums.length; i++)
      {
         swap(i, aCurrentIndex, aNums);
         calculatePermutation(aResultOutput, aCurrentIndex + 1, aNums, isItemPresent);
         swap(i, aCurrentIndex, aNums);
      }
   }

   private void swap(int aI, int aCurrentIndex, Integer[] aNums)
   {
      int temp = aNums[aI];
      aNums[aI] = aNums[aCurrentIndex];
      aNums[aCurrentIndex] = temp;
   }

   public static void main(String[] args)
   {
      int nums[] = { 1, 2, 3, 2 };
      LeetCode47 soln = new LeetCode47();
      List<List<Integer>> solnArray = soln.permuteUnique(nums);
      for (List<Integer> items : solnArray)
      {
         for (Integer i : items)
         {
            System.out.print(i);
         }
         System.out.println();
      }
   }

}
