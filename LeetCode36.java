package leetcodepractice;
import java.util.HashMap;
import java.util.Map;

public class LeetCode36
{
   Map<Character, Boolean> charactermap = new HashMap<Character, Boolean>();

   public boolean isValidSudoku(char[][] board)
   {
      // check all columns.
      boolean isColumnsValid = checkEachColumnsValue(board, 0, true);
      charactermap.clear();
      // Check all rows.
      boolean isRowsValid = checkEachRowsValue(board, 0, true);
      charactermap.clear();
      int i = 0;
      int j = 0;
      boolean currentBool = true;
      // Check all sub square.
      while (i <= 6 && j <= 6)
      {
         currentBool = currentBool && checkSmallSquareValues(board, i, j, true);
         if (j >= 6)
         {
            i = i + 3;
            j = 0;
            continue;
         }
         j = j + 3;
      }
      return isColumnsValid && isRowsValid && currentBool;

   }

   private boolean checkEachColumnsValue(char[][] board, int currentRow, boolean currentSate)
   {
      if (currentRow == 9)
         return currentSate;
      boolean isValid = true;
      for (int column = 0; column < 9; column++)
      {
         char currentChar = board[currentRow][column];
         if (charactermap.containsKey(currentChar))
         {
            return false;
         }
         else
         {
            isValid = true;
            if (currentChar != '.')
               charactermap.put(currentChar, true);
         }
      }
      charactermap.clear();
      return checkEachColumnsValue(board, currentRow + 1, isValid);

   }

   private boolean checkEachRowsValue(char[][] board, int currentColumn, boolean currentSate)
   {
      if (currentColumn == 9)
         return currentSate;
      boolean isValid = true;
      for (int row = 0; row < 9; row++)
      {
         char currentChar = board[row][currentColumn];
         if (charactermap.containsKey(currentChar))
         {
            return false;
         }
         else
         {
            isValid = true;
            if (currentChar != '.')
               charactermap.put(currentChar, true);
         }
      }
      charactermap.clear();
      return checkEachRowsValue(board, currentColumn + 1, isValid);
   }

   private boolean checkSmallSquareValues(char[][] board, int currentx, int currentY, boolean currentStatus)
   {
      boolean isValid = true;
      if (currentx > 6 && currentY > 6)
      {
         return currentStatus;
      }
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            char c = board[currentx + i][currentY + j];
            if (charactermap.containsKey(c))
            {
               return false;
            }
            else
            {
               if (c != '.')
               {
                  charactermap.put(c, true);
               }
            }
         }
      }
      charactermap.clear();
      return isValid;
   }

   public static void main(String[] args)
   {
      char[][] board = { { '.', '.', '.', '.', '.', '.', '5', '.', '.' },
            { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
            { '9', '3', '.', '.', '2', '.', '4', '.', '.' }, { '.', '.', '7', '.', '.', '.', '3', '.', '.' },
            { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '3', '4', '.', '.', '.', '.' },
            { '.', '.', '.', '.', '.', '3', '.', '.', '.' }, { '.', '.', '.', '.', '.', '5', '2', '.', '.' } };
      LeetCode36 soln = new LeetCode36();
      System.out.println(soln.isValidSudoku(board));

   }

}
