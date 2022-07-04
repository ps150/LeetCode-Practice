package leetcodepractice;
public class LeetCode64
{

   public int minPathSum(int[][] grid)
   {
      int m = grid.length;
      int n = 0;
      

      if (m > 0)
         n = grid[0].length;

      for (int i = n - 2; i >= 0; i--)
      {
         grid[m - 1][i] = grid[m - 1][i + 1] + grid[m - 1][i];
      }

      for (int i = m - 2; i >= 0; i--)
      {
         grid[i][n - 1] = grid[i + 1][n - 1] + grid[i][n - 1];
      }

      for (int i = m - 2; i >= 0; i--)
      {
         for (int j = n - 2; j >= 0; j--)
         {
            int currentMin = grid[i + 1][j] > grid[i][j + 1] ? grid[i][j + 1] : grid[i + 1][j];
            grid[i][j] = currentMin + grid[i][j];
         }

      }
      return grid[0][0];
   }

   public static void main(String[] args)
   {
      int[][] nums = { { 1, 2, 5 }, { 3, 2, 1 } };

      LeetCode64 soln = new LeetCode64();
      System.out.println(soln.minPathSum(nums));
   }

}
