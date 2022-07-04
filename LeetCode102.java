package leetcodepractice;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102
{
   public class TreeNode
   {
      int val;

      TreeNode left;

      TreeNode right;

      TreeNode()
      {
      }

      TreeNode(int val)
      {
         this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right)
      {
         this.val = val;
         this.left = left;
         this.right = right;
      }

   }

   public List<List<Integer>> levelOrder(TreeNode root)
   {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      if (root == null)
         return list;

      Queue<TreeNode> nextLevelQueue = new LinkedList<TreeNode>();

      Queue<TreeNode> currentNodeQueue = new LinkedList<TreeNode>();
      currentNodeQueue.add(root);

      while (!currentNodeQueue.isEmpty() || !nextLevelQueue.isEmpty())
      {
         List<Integer> currentLevelItem = new ArrayList<Integer>();
         if (!currentNodeQueue.isEmpty())
         {
            while (!currentNodeQueue.isEmpty())
            {
               TreeNode currentNode = currentNodeQueue.poll();
               if (currentNode != null)
               {
                  currentLevelItem.add(currentNode.val);
                  nextLevelQueue.add(currentNode.left);
                  nextLevelQueue.add(currentNode.right);
               }
            }
         }
         else
         {
            while (!nextLevelQueue.isEmpty())
            {
               TreeNode currentNode = nextLevelQueue.poll();
               if (currentNode != null)
               {
                  currentLevelItem.add(currentNode.val);
                  currentNodeQueue.add(currentNode.left);
                  currentNodeQueue.add(currentNode.right);
               }

            }
         }
         if (currentLevelItem.size() > 0)
            list.add(currentLevelItem);
      }

      return list;
   }

   public static void main(String[] args)
   {

   }

}
