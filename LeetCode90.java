package leetcodepractice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode90
{
   Map<String, Boolean> isSetPresent = new HashMap<String, Boolean>();

   public List<List<Integer>> subsetsWithDup(int[] nums)
   {
      List<List<Integer>> resultSet = new ArrayList<List<Integer>>();
      List<Integer> holdingArr = new ArrayList<Integer>();
      resultSet.add(holdingArr);
      calculateAllSubset(resultSet, 0, nums, holdingArr);

      return resultSet;

   }

   private void calculateAllSubset(List<List<Integer>> aResultSet, int aCurrentIndex, int[] aNums,
         List<Integer> aHoldingArr)
   {
      if (aHoldingArr.size() > 0)
      {
         List<Integer> copyArray = new ArrayList<Integer>(aHoldingArr);
         Collections.sort(copyArray);
         String str = "";
         for (Integer i : copyArray)
            str = str + i;
         if (!isSetPresent.containsKey(str))
         {
            aResultSet.add(copyArray);
            isSetPresent.put(str, true);
         }

      }

      for (int i = aCurrentIndex; i < aNums.length; i++)
      {
         aHoldingArr.add(aNums[i]);
         calculateAllSubset(aResultSet, i + 1, aNums, aHoldingArr);
         aHoldingArr.remove(aHoldingArr.size() - 1);
      }

   }

   public static void main(String[] args)
   {
      LeetCode90 soln = new LeetCode90();
      int[] nums = { 4, 1, 0 };
      List<List<Integer>> solnList = soln.subsetsWithDup(nums);
      for (List<Integer> item : solnList)
      {
         for (Integer i : item)
         {
            System.out.print(i + ",");
         }
         System.out.println();
      }

   }

}
