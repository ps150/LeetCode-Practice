package leetcodepractice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode40
{

   public List<List<Integer>> combinationSum2(int[] candidates, int target)
   {
      Arrays.sort(candidates);
      List<List<Integer>> resultList = new ArrayList<List<Integer>>();
      Map<String, Boolean> map = new HashMap<String, Boolean>();
      List<Integer> currentList = new ArrayList<Integer>();
      populateSumMap(candidates, target, resultList, currentList, 0, map);
      return resultList;
   }

   private void populateSumMap(int[] aCandidates, int aRemain, List<List<Integer>> copyList, List<Integer> tempList,
         int k, Map<String, Boolean> map)
   {
      if (aRemain < 0)
      {
         return;
      }
      if (aRemain == 0)
      {
         ArrayList<Integer> copy = new ArrayList<Integer>(tempList);
         if (!copyList.contains(copy))
         {
            copyList.add(copy);
         }
      }
      for (int i = k; i < aCandidates.length; i++)
      {
         tempList.add(aCandidates[i]);
         populateSumMap(aCandidates, aRemain - aCandidates[i], copyList, tempList, i + 1, map);
         if (tempList.size() > 0)
            tempList.remove(tempList.size() - 1);
      }
   }

   public static void main(String[] args)
   {
      int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
      int target = 8;
      LeetCode40 soln = new LeetCode40();
      List<List<Integer>> listItems = soln.combinationSum2(nums, target);
      for (List<Integer> items : listItems)
      {
         for (Integer i : items)
         {
            System.out.print(i);
         }
         System.out.println();
      }
   }
}
