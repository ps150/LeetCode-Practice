package leetcodepractice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode120
{
   Map<String, Integer> aValueMap = new HashMap<String, Integer>();

   public int minimumTotal(List<List<Integer>> triangle)
   {
      return calculateMinimumSum(triangle, 0, 0);
   }

   private int calculateMinimumSum(List<List<Integer>> aTriangle, int aCurrentLevel, int currentIndex)
   {
      if (aTriangle.size() == aCurrentLevel)
      {
         return aTriangle.get(aCurrentLevel).get(currentIndex);
      }
      if (aValueMap.containsKey(aCurrentLevel + "," + currentIndex))
      {
         return aValueMap.get(aCurrentLevel + "," + currentIndex);
      }
      int leftMin = calculateMinimumSum(aTriangle, aCurrentLevel + 1, currentIndex);
      int rightMin = calculateMinimumSum(aTriangle, aCurrentLevel + 1, currentIndex + 1);
      int currentSum = aTriangle.get(aCurrentLevel).get(currentIndex) + (leftMin > rightMin ? rightMin : leftMin);
      aValueMap.put(aCurrentLevel + "," + currentIndex, currentSum);
      return currentSum;
   }

   public static void main(String[] args)
   {

   }

}
