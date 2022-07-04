package leetcodepractice;

public class LeetCode34
{
   public int[] searchRange(int[] nums, int target)
   {

      int[] resultArray = new int[2];
      int leftMostIndex = -1;
      int rightMostIndex = -1;
      int indx = binarySearch(nums, 0, nums.length - 1, target);
      leftMostIndex = indx;
      rightMostIndex = indx;
      boolean leftEnd = false;
      boolean rightEnd = false;
      resultArray[0] = leftMostIndex;
      resultArray[1] = rightMostIndex;
      while (!leftEnd || !rightEnd)
      {
         if (leftMostIndex >= 0 && nums[leftMostIndex] == target)
         {
            resultArray[0] = leftMostIndex;
            leftMostIndex = leftMostIndex - 1;
         }
         else
         {
            leftEnd = true;
         }
         if (rightMostIndex >= 0 && rightMostIndex < nums.length && nums[rightMostIndex] == target)
         {
            resultArray[1] = rightMostIndex;
            rightMostIndex = rightMostIndex + 1;
         }
         else
         {
            rightEnd = true;
         }

      }
      return resultArray;
   }

   private int binarySearch(int[] aNums, int start, int end, int target)
   {
      if (start > end)
         return -1;
      int mid = (start + end) / 2;

      if (aNums[mid] == target)
         return mid;

      if (aNums[mid] < target)
      {
         return binarySearch(aNums, mid + 1, end, target);
      }
      else if (aNums[mid] > target)
         return binarySearch(aNums, start, mid - 1, target);

      return -1;
   }

   public static void main(String[] args)
   {
      int[] nums = { 2, 2 };
      int target = 2;

      LeetCode34 soln = new LeetCode34();
      int[] resultArr = soln.searchRange(nums, target);
      for (int i = 0; i < resultArr.length; i++)
      {
         System.out.print(resultArr[i]);
      }
   }

}
