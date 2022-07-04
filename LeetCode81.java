package leetcodepractice;

public class LeetCode81
{
   public boolean search(int[] nums, int target)
   {
      int len = nums.length - 1;
      if (len < 0)
         return false;
      if (len == 0)
         if (nums[0] == target)
            return true;
         else
            return false;

      int pivotIndex = findthePivotElement(nums, 0, len);
      if (pivotIndex == -1)
      {
         // Not rotated.
         return binarySearch(nums, 0, len, target);

      }
      if (nums[pivotIndex] < target && nums[len] >= target)
      {
         // check right side;
         if (nums[pivotIndex] == target || nums[len] == target)
            return true;
         return binarySearch(nums, pivotIndex, len, target);

      }
      else
      {
         // check right side;
         if (nums[pivotIndex] == target || nums[0] == target)
            return true;
         return binarySearch(nums, 0, pivotIndex, target);
      }

   }

   private boolean binarySearch(int[] aNums, int aStart, int aEnd, int aTarget)
   {
      if (aStart <= aEnd)
      {
         int mid = (aStart + aEnd) / 2;
         if (aNums[mid] == aTarget)
            return true;

         if (aNums[mid] > aTarget)
            return binarySearch(aNums, aStart, mid - 1, aTarget);
         else
            return binarySearch(aNums, mid + 1, aEnd, aTarget);
      }

      return false;
   }

   private int findthePivotElement(int[] nums, int start, int end)
   {
      if (end >= start)
      {
         int mid = (start + end) / 2;
         if (mid - 1 >= start && nums[mid] < nums[mid - 1])
            return mid;

         if (mid + 1 <= end && nums[mid] > nums[mid + 1])
            return mid + 1;

         int middle = findthePivotElement(nums, start, mid - 1);
         if (middle == -1)
         {
            return findthePivotElement(nums, mid + 1, end);
         }
         else
         {
            return middle;
         }
      }
      return -1;
   }

   public static void main(String[] args)
   {
      int[] nums = { 1, 1 };
      LeetCode81 soln = new LeetCode81();
      System.out.println(soln.search(nums, 1));
   }

}
