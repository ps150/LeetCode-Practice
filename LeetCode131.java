package leetcodepractice;
import java.util.ArrayList;
import java.util.List;

public class LeetCode131
{
   public List<List<String>> partition(String s)
   {
      List<String> resultList = new ArrayList<String>();
      List<List<String>> lit = new ArrayList<List<String>>();
      allPossibleSubstring(s, 0, resultList, lit);
      for (List<String> tr : lit)
      {
         for (String str : tr)
            System.out.println(str);

         System.out.println("------------------------------");
      }

      System.out.println(lit.size());
      return null;
   }

   private void allPossibleSubstring(String str, int strtIndex, List<String> resultList, List<List<String>> list)
   {

      if (strtIndex >= str.length())
      {
         list.add(new ArrayList<String>(resultList));
         return;
      }

      for (int i = strtIndex; i < str.length(); i++)
      {
         resultList.add(str.substring(strtIndex, i + 1));
         allPossibleSubstring(str, i + 1, resultList, list);
         resultList.remove(resultList.size() - 1);
      }
   }

   public static void main(String[] args)
   {
      LeetCode131 soln = new LeetCode131();
      soln.partition("abcdef");
   }

}
