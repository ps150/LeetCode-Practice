package leetcodepractice;
public class LeetCode59
{
   public int[][] generateMatrix(int n)
   {
      int[][] matrix = new int[n][n];
      int currentRowTopIndex = 0;
      int currentColumnLeftIndex = 0;
      int count = 1;
      int columnsRightIndex = n - 1;
      int rowBottomIndex = n - 1;

      while (count <= n * n)
      {
         for (int i = currentColumnLeftIndex; i <= columnsRightIndex; i++)
         {
            matrix[currentRowTopIndex][i] = count;
            count++;
         }

         for (int i = currentRowTopIndex + 1; i <= rowBottomIndex; i++)
         {
            matrix[i][columnsRightIndex] = count;
            count++;
         }
         for (int i = columnsRightIndex - 1; i >= currentColumnLeftIndex; i--)
         {
            matrix[rowBottomIndex][i] = count;
            count++;
         }

         for (int i = rowBottomIndex - 1; i >= currentRowTopIndex + 1; i--)
         {
            matrix[i][currentColumnLeftIndex] = count;
            count++;
         }

         currentColumnLeftIndex++;
         currentRowTopIndex++;
         columnsRightIndex--;
         rowBottomIndex--;
      }

      return matrix;

   }

   public static void main(String[] args)
   {
      LeetCode59 soln = new LeetCode59();
      int n = 9;
      int[][] matrix = soln.generateMatrix(n);
      for (int i = 0; i < n; i++)
      {
         for (int j = 0; j < n; j++)
         {
            System.out.print(matrix[i][j] + "\t");
         }
         System.out.println();
      }

   }

}
