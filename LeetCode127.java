package leetcodepractice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class LeetCode127
{
   public int ladderLength(String beginWord, String endWord, List<String> wordList)
   {

      // Since all words are of same length.
      int L = beginWord.length();

      // Dictionary to hold combination of words that can be formed,
      // from any given word. By changing one letter at a time.
      Map<String, List<String>> allComboDict = new HashMap<>();

      wordList.forEach(word -> {
         for (int i = 0; i < L; i++)
         {
            // Key is the generic word
            // Value is a list of words which have the same intermediate generic word.
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
            List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
            transformations.add(word);
            allComboDict.put(newWord, transformations);
         }
      });

      return 0;
   }

   public static void main(String[] args)
   {
      List<String> item = new ArrayList<String>();
      item.add("hot");
      item.add("dot");
      item.add("dog");
      item.add("lot");
      item.add("log");
      item.add("cog");

      LeetCode127 soln = new LeetCode127();
      System.out.println(soln.ladderLength("hit", "cog", item));
   }

}
