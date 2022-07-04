package leetcodepractice;
import java.util.ArrayList;
import java.util.List;

public class LeetCode94
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

   public List<Integer> inorderTraversal(TreeNode root)
   {
      List<Integer> inorderItemList = new ArrayList<Integer>();
      fillInorderInList(root, inorderItemList);
      return inorderItemList;
   }

   private void fillInorderInList(TreeNode aRoot, List<Integer> inorderItemList)
   {
      if (aRoot == null)
         return;

      fillInorderInList(aRoot.left, inorderItemList);
      inorderItemList.add(aRoot.val);
      fillInorderInList(aRoot.right, inorderItemList);

   }

   public static void main(String[] args)
   {
      // TODO Auto-generated method stub

   }

}
