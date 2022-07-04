package leetcodepractice;
import java.util.ArrayList;
import java.util.List;

public class LeetCode89
{
   public List<Integer> grayCode(int n)
   {
      if (n == 0)
      {
         List<Integer> list = new ArrayList<>();
         list.add(0);
         return list;
      }
      else if (n == 1)
      {
         List<Integer> list = new ArrayList<>();
         list.add(0);
         list.add(1);
         return list;
      }

      List<Integer> binaryList = calculateAllTheGrayCode(n);
      // converBinaryListToNumList(resultList, binaryList);
      for (Integer str : binaryList)
         System.out.println(str);

      return binaryList;
   }

   private List<Integer> calculateAllTheGrayCode(int aN)
   {
      if (aN == 2)
      {
         List<Integer> resultArray = new ArrayList<Integer>();
         resultArray.add(0);
         resultArray.add(1);
         resultArray.add(3);
         resultArray.add(2);
         return resultArray;
      }

      List<Integer> nthBitItem = calculateAllTheGrayCode(aN - 1);

      List<Integer> finalMixList = new ArrayList<Integer>();

      for (Integer str : nthBitItem)
      {
         finalMixList.add(str);
      }

      for (int i = nthBitItem.size() - 1; i >= 0; i--)
      {
         finalMixList.add((int) (Math.pow(2, aN - 1) + nthBitItem.get(i)));
      }
      return finalMixList;
   }

   public static void main(String[] args)
   {
      LeetCode89 soln = new LeetCode89();
      soln.grayCode(2);

   }

}
