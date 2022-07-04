package leetcodepractice;

public class LeetCode130
{
   public void solve(char[][] board)
   {
      int row = board.length;
      if (row == 0)
         return;

      int column = board[0].length;
      for (int i = 1; i < row - 1; i++)
      {
         for (int j = 1; j < column - 1; j++)
         {
            char c = board[i][j];
            if (c == 'O')
            {
               if (isValidaToConvert(i, j, row - 1, column - 1, board))
               {
                  board[i][j] = 'X';
               }
            }
         }

      }

   }

   private boolean isValidaToConvert(int currentRow, int currentColumn, int rowLen, int columnsLen, char[][] aBoard)
   {

      if (aBoard[currentRow][currentColumn] == 'N' || (aBoard[currentRow][currentColumn] == 'O'
            && (currentColumn >= columnsLen || currentRow >= rowLen || currentColumn <= 0 || currentRow <= 0)))
      {
         return false;
      }

      if (aBoard[currentRow][currentColumn] == 'Y' || aBoard[currentRow][currentColumn] == 'X')
      {
         return true;
      }

      aBoard[currentRow][currentColumn] = 'V';

      if (currentRow + 1 < rowLen && aBoard[currentRow + 1][currentColumn] != 'V')
      {
         isValidaToConvert(currentRow + 1, currentColumn, rowLen, columnsLen, aBoard);
      }
      return false;
   }

   public static void main(String[] args)
   {
      char[][] c = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
      LeetCode130 soln = new LeetCode130();
      soln.solve(c);
      for (char[] charArray : c)
      {
         for (int i = 0; i < charArray.length; i++)
         {
            System.out.print(charArray[i]);
         }
         System.out.println();
      }
   }
}
