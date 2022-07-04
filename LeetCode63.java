package leetcodepractice;
public class LeetCode63
{
   public int uniquePathsWithObstacles(int[][] obstacleGrid)
   {
      int m = obstacleGrid.length;
      int n = 0;

      if (m > 0)
      {
         n = obstacleGrid[0].length;
      }

      if (obstacleGrid[m - 1][n - 1] == 1)
         return 0;

      boolean isObstaclesFound = false;
      for (int i = m - 1; i >= 0; i--)
      {
         if (obstacleGrid[i][n - 1] == 0 && !isObstaclesFound)
         {
            obstacleGrid[i][n - 1] = 1;
         }
         else
         {
            isObstaclesFound = true;
            obstacleGrid[i][n - 1] = 0;
         }
      }
      isObstaclesFound = false;
      for (int i = n - 2; i >= 0; i--)
      {
         if (obstacleGrid[m - 1][i] == 0 && !isObstaclesFound)
         {
            obstacleGrid[m - 1][i] = 1;
         }
         else
         {
            isObstaclesFound = true;
            obstacleGrid[m - 1][i] = 0;
         }
      }

      for (int i = m - 2; i >= 0; i--)
      {
         for (int j = n - 2; j >= 0; j--)
         {
            if (obstacleGrid[i][j] == 0)
               obstacleGrid[i][j] = obstacleGrid[i + 1][j] + obstacleGrid[i][j + 1];
            else
            {
               obstacleGrid[i][j] = 0;
            }
         }
      }

      return obstacleGrid[0][0];
   }

   public static void main(String[] args)
   {
      int[][] nums = { { 1, 2, 5 }, { 3, 2, 1 } };
      LeetCode63 soln = new LeetCode63();
      System.out.println(soln.uniquePathsWithObstacles(nums));

   }

}
