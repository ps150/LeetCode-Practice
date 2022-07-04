package leetcodepractice;
public class LeetCode62
{
   public int uniquePaths(int m, int n)
   {
      int[][] resultMatrix = new int[m][n];

      for (int i = m - 1; i >= 0; i--)
      {
         resultMatrix[i][n - 1] = 1;
      }
      for (int i = n - 1; i >= 0; i--)
      {
         resultMatrix[m - 1][i] = 1;
      }

      for (int i = m - 2; i >= 0; i--)
      {
         for (int j = n - 2; j >= 0; j--)
         {
            resultMatrix[i][j] = resultMatrix[i + 1][j] + resultMatrix[i][j + 1];
         }
      }

      return resultMatrix[0][0];
   }

   public static void main(String[] args)
   {
      LeetCode62 soln = new LeetCode62();
      System.out.println(soln.uniquePaths(3, 3));
   }

}
