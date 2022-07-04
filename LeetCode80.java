package leetcodepractice;
public class LeetCode80
{
   public int removeDuplicates(int[] nums)
   {
      int len = nums.length;
      if (len == 0)
         return 0;

      int bufferStart = -1;
      int bufferEnd = -1;

      int currentNum = nums[0];
      int currentNumCount = 1;
      for (int i = 1; i < len; i++)
      {
         if (nums[i] == currentNum && currentNumCount < 2)
         {
            currentNumCount++;
            if (bufferStart != -1)
            {
               int temp = nums[bufferStart];
               nums[bufferStart] = nums[i];
               nums[i] = temp;
               bufferStart++;
               bufferEnd++;
            }
         }
         else
         {
            if (nums[i] == currentNum && currentNumCount >= 2)
            {
               if (bufferStart == -1)
                  bufferStart = i;

               bufferEnd = i;
            }
            else if (nums[i] != currentNum)
            {
               currentNum = nums[i];
               currentNumCount = 1;
               if (bufferStart != -1)
               {
                  int temp = nums[bufferStart];
                  nums[bufferStart] = nums[i];
                  nums[i] = temp;
                  bufferStart++;
                  bufferEnd++;
               }
            }
         }

      }
      if (bufferEnd != -1 && bufferStart != -1)
         len = len - (bufferEnd - bufferStart) - 1;

      return len;
   }

   public static void main(String[] args)
   {
      int[] nums = { 1, 1, 1, 2, 2, 3 };
      LeetCode80 soln = new LeetCode80();
      System.out.println(soln.removeDuplicates(nums));
      for (int i = 0; i < nums.length; i++)
      {
         System.out.println(nums[i]);

      }
   }

}
