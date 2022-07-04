package leetcodepractice;
import java.util.ArrayList;
import java.util.List;

public class LeetCode95
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

   public List<TreeNode> generateTrees(int n)
   {
      if (n == 0)
         return new ArrayList<TreeNode>();

      List<TreeNode> headList = new ArrayList<TreeNode>();
      List<TreeNode> headList1 = new ArrayList<TreeNode>();
      for (int i = 1; i <= n; i++)
      {
         headList1.addAll(mergeLeftAndRightChildWithRoot(i, headList, createTree(1, i - 1), createTree(i + 1, n)));
         headList.clear();
      }

      return headList1;
   }

   private List<TreeNode> createTree(int leftIndex, int rightIndex)
   {
      List<TreeNode> headList = new ArrayList<TreeNode>();

      if (rightIndex < leftIndex)
      {
         headList.add(null);
         return headList;
      }
      for (int i = leftIndex; i <= rightIndex; i++)
      {
         mergeLeftAndRightChildWithRoot(i, headList, createTree(leftIndex, i - 1), createTree(i + 1, rightIndex));
      }

      return headList;

   }

   private List<TreeNode> mergeLeftAndRightChildWithRoot(int currentIndex, List<TreeNode> headList, List<TreeNode> leftChilds,
         List<TreeNode> rightChilds)
   {
      for (TreeNode left : leftChilds)
      {
         for (TreeNode right : rightChilds)
         {
            TreeNode t = new TreeNode(currentIndex);
            t.right = right;
            t.left = left;
            headList.add(t);
         }
      }
      if (leftChilds.isEmpty())
      {
         for (TreeNode right : rightChilds)
         {
            TreeNode t = new TreeNode(currentIndex);
            t.right = right;
            t.left = null;
            headList.add(t);
         }
      }

      if (rightChilds.isEmpty())
      {
         for (TreeNode left : leftChilds)
         {
            TreeNode t = new TreeNode(currentIndex);
            t.right = null;
            t.left = left;
            headList.add(t);
         }
      }
      if (rightChilds.isEmpty() && leftChilds.isEmpty())
      {
         TreeNode t = new TreeNode(currentIndex);
         t.right = null;
         t.left = null;
         headList.add(t);
      }
      return headList;
   }

   public void inorderTraversal(TreeNode root)
   {
      fillInorderInList(root);
   }

   private void fillInorderInList(TreeNode aRoot)
   {
      if (aRoot == null)
      {
         // System.out.println("null");
         return;
      }
      System.out.println(aRoot.val);
      fillInorderInList(aRoot.left);
      fillInorderInList(aRoot.right);
   }

   public static void main(String[] args)
   {
      LeetCode95 soln = new LeetCode95();
      List<TreeNode> headList = soln.generateTrees(4);
      int count = 0;
      for (TreeNode t : headList)
      {
         soln.fillInorderInList(t);
         System.out.println("----------------------------");
         count++;
      }
      System.out.println("----Count ----" + count);
   }

}
