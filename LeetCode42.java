package leetcodepractice;

public class LeetCode42
{

   public int trap(int[] height)
   {
      if (height.length == 0)
         return 0;
      int ans = 0;
      int leftIndex = 0;
      int righIndex = height.length - 1;
      int tempMin;
      boolean isLeft;
      if (height[leftIndex] > height[righIndex])
      {
         tempMin = righIndex;
         righIndex--;
         isLeft = false;
      }
      else
      {
         tempMin = leftIndex;
         leftIndex++;
         isLeft = true;
      }

      while (leftIndex <= righIndex)
      {
         if (isLeft)
         {
            if (height[leftIndex] < height[tempMin])
            {
               ans += height[tempMin] - height[leftIndex];
               leftIndex++;
            }
            else
            {
               tempMin = leftIndex;
               if (height[leftIndex] > height[righIndex])
               {
                  tempMin = righIndex;
                  righIndex--;
                  isLeft = false;
               }
               else
               {
                  leftIndex++;
               }
            }
         }
         else
         {
            if (height[righIndex] < height[tempMin])
            {
               ans += height[tempMin] - height[righIndex];
               righIndex--;
            }
            else
            {
               tempMin = righIndex;
               if (height[righIndex] > height[leftIndex])
               {
                  tempMin = leftIndex;
                  leftIndex++;
                  isLeft = true;
               }
               else
               {
                  righIndex--;
               }
            }

         }
      }

      return ans;
   }

   public static void main(String[] args)
   {
      int[] arr = { 4, 2, 0, 3, 2, 5 };

      LeetCode42 soln = new LeetCode42();
      System.out.println(soln.trap(arr));

   }

}
