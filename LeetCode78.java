package leetcodepractice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode78
{

   public List<List<Integer>> subsets(int[] nums)
   {
      List<List<Integer>> resultList = new ArrayList<List<Integer>>();

      int len = nums.length;
      List<Integer> holderList = new ArrayList<Integer>();
      ArrayList<Integer> emptyLis = new ArrayList<Integer>();
      resultList.add(emptyLis);
      populateResultList(nums, len, 0, holderList, resultList);

      return resultList;

   }

   private void populateResultList(int[] aNums, int aLen, int aI, List<Integer> holderList,
         List<List<Integer>> resultList)
   {
      if (holderList.size() > 0 && holderList.size() <= aLen)
      {
         List<Integer> copyList = new ArrayList<Integer>(holderList);
         resultList.add(copyList);
      }

      for (int i = aI; i < aLen; i++)
      {
         holderList.add(aNums[i]);
         populateResultList(aNums, aLen, i + 1, holderList, resultList);
         if (holderList.size() > 0)
            holderList.remove(holderList.size() - 1);
      }

   }

   @SuppressWarnings("serial")
   public List<List<Integer>> subsets1(int[] nums)
   {
      @SuppressWarnings({ "rawtypes", "unchecked" })
      List<List<Integer>> output = new ArrayList();
      output.add(new ArrayList<Integer>());

      for (int num : nums)
      {
         @SuppressWarnings({ "rawtypes", "unchecked" })
         List<List<Integer>> newSubsets = new ArrayList();

         for (List<Integer> curr : output)
         {
            newSubsets.add(new ArrayList<Integer>(curr)
            {
               {
                  add(num);
               }
            });
         }
         for (List<Integer> curr : newSubsets)
         {
            output.add(curr);
         }
      }
      return output;
   }

   private void findAllsubSet1(List<List<Integer>> resultArray, int x, List<Integer> holdingArray, List<Integer> spces,
         int currentIndex)
   {

      if (holdingArray.size() > 0 && holdingArray.size() == x)
      {
         List<Integer> copyList = new ArrayList<Integer>(holdingArray);
         Collections.sort(copyList);
         resultArray.add(copyList);
         holdingArray.clear();
         return;
      }

      for (int i = currentIndex; i < spces.size(); i++)
      {
         currentIndex = currentIndex + 1;
         holdingArray.add(spces.get(i));
         findAllsubSet1(resultArray, x, holdingArray, spces, currentIndex);
         if (currentIndex > spces.size() - x)
            return;
         if (holdingArray.size() > 0)
            holdingArray.clear();
      }

   }

   private void allSubset(List<List<Integer>> resultArray, int x, List<Integer> spces)
   {
      for (int i = 0; i <= spces.size() - x; i++)
      {
         List<Integer> holdingList = new ArrayList<Integer>(spces.subList(i, i + x));
         Collections.sort(holdingList);
         resultArray.add(holdingList);
      }
   }

   public static void main(String[] args)
   {
      LeetCode78 soln = new LeetCode78();
      List<Integer> listArr = new ArrayList<Integer>();
      listArr.add(3);
      listArr.add(9);
      listArr.add(2);
      listArr.add(7);
      listArr.add(4);
      listArr.add(6);
      listArr.add(8);

      List<List<Integer>> resultArray = new ArrayList<List<Integer>>();
      List<Integer> holdingArray = new ArrayList<Integer>();

      soln.allSubset(resultArray, 2, listArr);
      // soln.findAllsubSet1(resultArray, 2, holdingArray, listArr, 0);

      for (List<Integer> item : resultArray)
      {

         for (Integer i : item)
            System.out.print(i + ",");

         System.out.println();
      }

      int max = -1;
      for (List<Integer> item : resultArray)
      {
         if (item != null && item.size() > 0)
         {
            int currentItem = item.get(0);
            if (currentItem > max)
            {
               max = currentItem;
            }
         }
      }
      System.out.println(max);
   }

}
