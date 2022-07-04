package leetcodepractice;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode71
{

   public String simplifyPath(String path)
   {
      Stack<String> st = new Stack<String>();
      String resultStr = "/";
      for (int i = 0; i < path.length(); i++)
      {
         String str = "";
         while (i < path.length() && path.charAt(i) == '/')
         {
            i++;
         }

         while (i < path.length() && path.charAt(i) != '/')
         {
            str = str + path.charAt(i);
            i++;
         }
         if (str.equals(".."))
         {
            if (st.size() > 0)
               st.pop();
            continue;
         }

         if (str.equals("."))
         {
            continue;
         }

         if (str.length() > 0)
         {
            st.push(str);
         }
      }

      String[] strArray = new String[st.size()];
      int indx = st.size() - 1;
      while (!st.isEmpty())
      {
         strArray[indx] = st.pop();
         indx--;
      }
      for (int i = 0; i < strArray.length; i++)
      {
         if (i < strArray.length - 1)
            resultStr = resultStr + strArray[i] + "/";
         else
            resultStr = resultStr + strArray[i];
      }

      System.out.println(resultStr);
      return resultStr;
   }

   public String simplifyPath1(String path)
   {
      if (path == null || path.length() == 0)
         return null;

      path = (String) path.subSequence(1, path.length());
      String[] arr = path.split("[/]");
      Deque<String> stack = new LinkedList<String>();

      for (int i = 0; i < arr.length; i++)
      {
         if (arr[i].equals(".."))
         {
            if (!stack.isEmpty())
               stack.pop();
         }
         else if (arr[i].equals("."))
         {
            continue;
         }
         else if (!arr[i].equals(""))
         {
            stack.push("/" + arr[i]);
         }
      }

      StringBuilder sb = new StringBuilder();
      if (stack.isEmpty())
         return "/";

      while (!stack.isEmpty())
      {
         sb.append(stack.removeLast());
      }
      System.out.println(sb.toString());
      return sb.toString();
   }

   public static void main(String[] args)
   {

      LeetCode71 soln = new LeetCode71();
      soln.simplifyPath1("/a/./b/....../../c/");

   }

}
