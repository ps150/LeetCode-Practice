package leetcodepractice;
public class LeetCode74
{
   public boolean searchMatrix(int[][] matrix, int target)
   {
      int noRow = matrix.length;
      int noColumns = 0;
      if (noRow > 0)
         noColumns = matrix[0].length;
      else
      {
         return false;
      }

      if (noColumns == 0)
         return false;
      int rowNum = getRowNum(matrix, noRow, noColumns, target);

      if (rowNum == -1)
         return false;
      return binarySearchTarget(matrix, rowNum, 0, noColumns, target);

   }

   private boolean binarySearchTarget(int[][] aMatrix, int aRowNum, int start, int end, int aTarget)
   {
      if (end >= start)
      {
         int mid = (start + end) / 2;
         if (aMatrix[aRowNum][mid] == aTarget)
            return true;
         else
         {
            if (aMatrix[aRowNum][mid] < aTarget)
            {
               return binarySearchTarget(aMatrix, aRowNum, mid + 1, end, aTarget);
            }
            else
            {
               return binarySearchTarget(aMatrix, aRowNum, start, mid - 1, aTarget);
            }
         }
      }
      return false;
   }

   private int getRowNum(int[][] aMatrix, int rowCount, int columnsCount, int target)
   {
      for (int i = 0; i < rowCount; i++)
      {
         if (aMatrix[i][columnsCount - 1] >= target)
         {
            return i;
         }
      }
      return -1;
   }

   public static void main(String[] args)
   {
      int[][] nums = { {} };
      LeetCode74 soln = new LeetCode74();
      System.out.println(soln.searchMatrix(nums, 33));
   }

}
