package leetcodepractice;

public class LeetCode79
{
   int rowCount = 0;

   int columnCount = 0;

   public boolean exist(char[][] board, String word)
   {

      rowCount = board.length;
      if (rowCount == 0)
         return false;

      columnCount = board[0].length;
      boolean[][] visited = new boolean[rowCount][columnCount];

      if (word.length() < 0)
         return false;

      char firstChar = word.charAt(0);
      boolean isFound = false;
      for (int i = 0; i < rowCount; i++)
      {
         for (int j = 0; j < columnCount; j++)
         {
            if (board[i][j] == firstChar)
            {
               // first char matched, search others.
               isFound = searchFullWord(board, word, 0, i, j, visited);
            }
            if (isFound)
               return isFound;
         }
      }

      return isFound;
   }

   private boolean searchFullWord(char[][] aBoard, String aWord, int aCurrentIndex, int rowIndex, int columnIndex,
         boolean[][] visited)
   {

      if (rowIndex >= rowCount || rowIndex < 0 || columnIndex >= columnCount || columnIndex < 0)
      {
         return false;
      }

      if (visited[rowIndex][columnIndex])
      {
         return false;
      }

      if (aBoard[rowIndex][columnIndex] != aWord.charAt(aCurrentIndex))
      {
         return false;
      }

      if (aCurrentIndex == aWord.length() - 1)
      {
         return true;
      }
      visited[rowIndex][columnIndex] = true;

      boolean ifound = searchFullWord(aBoard, aWord, aCurrentIndex + 1, rowIndex + 1, columnIndex, visited)
            || searchFullWord(aBoard, aWord, aCurrentIndex + 1, rowIndex - 1, columnIndex, visited)
            || searchFullWord(aBoard, aWord, aCurrentIndex + 1, rowIndex, columnIndex + 1, visited)
            || searchFullWord(aBoard, aWord, aCurrentIndex + 1, rowIndex, columnIndex - 1, visited);

      visited[rowIndex][columnIndex] = false;

      return ifound;

   }

   public static void main(String[] args)
   {
      char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
      String word = "ABCESEEEFS";
      LeetCode79 soln = new LeetCode79();
      System.out.println(soln.exist(board, word));
   }

}
