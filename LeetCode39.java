package leetcodepractice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode39
{
   Map<Integer, List<List<Integer>>> storeArray = new HashMap<Integer, List<List<Integer>>>();

   public List<List<Integer>> combinationSum(int[] candidates, int target)
   {
      Arrays.sort(candidates);
      List<List<Integer>> resultList = new ArrayList<List<Integer>>();
      List<Integer> currentList = new ArrayList<Integer>();
      populateSumMap(candidates, target, resultList, currentList, 0);
      return resultList;
//      populateMemList(target, candidates);
// if (storeArray.get(target) == null)
// {
// return new ArrayList<List<Integer>>();
// }
// return storeArray.get(target);
   }

   private void populateSumMap(int[] aCandidates, int aRemain, List<List<Integer>> copyList, List<Integer> tempList,
         int k)
   {
      if (aRemain < 0)
      {
         return;
      }
      if (aRemain == 0)
      {
         ArrayList<Integer> copy = new ArrayList<Integer>(tempList);
         copyList.add(copy);
      }
      for (int i = k; i < aCandidates.length; i++)
      {
         tempList.add(aCandidates[i]);
         populateSumMap(aCandidates, aRemain - aCandidates[i], copyList, tempList, i);
         if (tempList.size() > 0)
            tempList.remove(tempList.size() - 1);
      }
   }

   private void populateMemList(int aTarget, int[] candidates)
   {
      List<List<Integer>> temp0 = new ArrayList<List<Integer>>();
      temp0.add(new ArrayList<Integer>(Arrays.asList(0)));
      storeArray.put(0, temp0);
      for (int j = 0; j < candidates.length; j++)
      {
         List<List<Integer>> resultList = new ArrayList<List<Integer>>();
         resultList.add(new ArrayList<Integer>(Arrays.asList(candidates[j])));
         storeArray.put(candidates[j], resultList);
      }

      for (int i = 1; i <= aTarget; i++)
      {
         int end = i - 1;
         int start = 1;
         // Case where end = i and start = 0, means search for the item i in the list and add.
         while (start <= end)
         {
            if (storeArray.get(end) != null && storeArray.get(start) != null)
            {
               for (List<Integer> items1 : storeArray.get(end))
               {
                  for (List<Integer> items2 : storeArray.get(start))
                  {
                     List<Integer> copyList = new ArrayList<Integer>(items2);
                     copyList.addAll(items1);

                     Collections.sort(copyList);
                     List<List<Integer>> currentItemList = storeArray.get(i);
                     if (currentItemList == null)
                     {
                        currentItemList = new ArrayList<List<Integer>>();
                        storeArray.put(i, currentItemList);
                     }
                     if (!currentItemList.contains(copyList))
                     {
                        currentItemList.add(copyList);
                        storeArray.put(i, currentItemList);
                     }
                  }
               }
            }
            start = start + 1;
            end = end - 1;
         }
      }
   }

   public static void main(String[] args)
   {
      int[] nums = { 2, 3, 6, 7 };
      int target = 7;
      LeetCode39 soln = new LeetCode39();
      List<List<Integer>> listItems = soln.combinationSum(nums, target);
      for (List<Integer> items : listItems)
      {
         System.out.println("items");
         for (Integer i : items)
         {
            System.out.print(i);
         }
      }
   }
}
