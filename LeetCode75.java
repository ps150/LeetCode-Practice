package leetcodepractice;

public class LeetCode75
{
   public void sortColors(int[] nums)
   {
      int mid = 0;
      int low = 0;
      int high = nums.length - 1;

      if (high == 0)
         return;

      while (mid <= high)
      {
         int midElement = nums[mid];
         switch (midElement)
         {
            case 0:
               int temp = nums[low];
               nums[low] = midElement;
               nums[mid] = temp;
               low++;
               mid++;
               break;
            case 1:
               mid++;
               break;
            case 2:
               temp = nums[high];
               nums[high] = midElement;
               nums[mid] = temp;
               high--;
               break;
         }
      }
      System.out.println(low + "" + mid + "" + high);
   }

   public static void main(String[] args)
   {
      int[] nums = { 2, 0, 2, 1, 1, 0 };
      LeetCode75 soln = new LeetCode75();
      soln.sortColors(nums);
      for (int i = 0; i < nums.length; i++)
      {
         System.out.println(nums[i]);
      }
   }

}
