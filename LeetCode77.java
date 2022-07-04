package leetcodepractice;
import java.util.ArrayList;
import java.util.List;

public class LeetCode77
{
   public List<List<Integer>> combine(int n, int k)
   {
      List<List<Integer>> resultList = new ArrayList<List<Integer>>();

      ArrayList<Integer> holdinglist = new ArrayList<Integer>();
      populateResult(n, k, resultList, 1, holdinglist);
      return resultList;

   }

   private void populateResult(int aN, int aK, List<List<Integer>> aResultList, int counter, List<Integer> holdinglist)
   {
      if (aK == holdinglist.size())
      {
         ArrayList<Integer> copy = new ArrayList<Integer>(holdinglist);
         aResultList.add(copy);
         return;
      }
      for (int i = counter; i <= aN; i++)
      {
         if (holdinglist.size() == 0 && i > aN - aK + 1)
            return;

         holdinglist.add(i);
         populateResult(aN, aK, aResultList, i + 1, holdinglist);
         holdinglist.remove(holdinglist.size() - 1);
      }

   }

   public static void main(String[] args)
   {
      LeetCode77 soln = new LeetCode77();
      List<List<Integer>> items = soln.combine(6, 3);

      for (List<Integer> item : items)
      {

         for (Integer i : item)
            System.out.print(i + ",");

         System.out.println();
      }

   }

}
