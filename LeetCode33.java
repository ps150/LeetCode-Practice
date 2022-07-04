package leetcodepractice;

public class LeetCode33
{
   public int search(int[] nums, int target)
   {
      int pivotElement = 0;
      int nextElement = 1;
      boolean isPivotFound = false;
      while (nextElement < nums.length)
      {
         if (nums[pivotElement] > nums[nextElement])
         {
            isPivotFound = true;
            break;
         }
         pivotElement = pivotElement + 1;
         nextElement = nextElement + 1;
      }

      // From start to pivot elemnt is sorted, and nextElement to end is sorted array
      if (isPivotFound)
         if (nums[0] <= target && nums[pivotElement] >= target)
            return binarySearch(nums, 0, pivotElement, target);
         else
         {
            return binarySearch(nums, nextElement, nums.length - 1, target);
         }
      else
      {
         // Array is sorted just do the binary search.
         return binarySearch(nums, 0, nums.length - 1, target);

      }

   }

   public int binarySearch(int[] arr, int start, int end, int k)
   {

      if (end >= start)
      {
         int mid = (start + end) / 2;

         if (arr[mid] == k)
            return mid;

         if (arr[mid] < k)
         {
            return binarySearch(arr, mid + 1, end, k);
         }
         else if (arr[mid] > k)
         {
            return binarySearch(arr, start, mid - 1, k);
         }

      }
      return -1;
   }

   public static void main(String[] args)
   {
      int[] nums = { 3, 1 };
      int target = 3;
      LeetCode33 soln = new LeetCode33();
      int i = soln.search(nums, target);
      System.out.println(i);

   }

}
