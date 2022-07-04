package leetcodepractice;
import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode56
{
   public int[][] merge(int[][] intervals)
   {
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

      LinkedList<int[]> resultArray = new LinkedList<int[]>();
      for (int[] currentInterval : intervals)
      {
         if (resultArray.isEmpty())
            resultArray.add(currentInterval);
         else
         {
            int[] lastAddedInterval = resultArray.getLast();
            if (lastAddedInterval[1] >= currentInterval[0] && lastAddedInterval[1] < currentInterval[1])
            {
               lastAddedInterval[1] = currentInterval[1];
            }
            else
            {
               if (lastAddedInterval[1] < currentInterval[0] && lastAddedInterval[1] < currentInterval[1])
                  resultArray.add(currentInterval);
            }

         }

      }

      return resultArray.toArray(new int[resultArray.size()][]);

   }

   public static void main(String[] args)
   {

      int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

      LeetCode56 soln = new LeetCode56();
      int[][] listItems = soln.merge(intervals);

      for (int[] item : listItems)
      {
         System.out.println(item[0] + "," + item[1]);
      }
   }

}
