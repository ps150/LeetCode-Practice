package leetcodepractice;
import java.util.ArrayList;
import java.util.List;

public class LeetCode113
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

   public List<List<Integer>> pathSum(TreeNode root, int sum)
   {
      List<List<Integer>> resultArr = new ArrayList<List<Integer>>();
      List<Integer> itemsList = new ArrayList<Integer>();
      itemsList.add(root.val);
      findAllApthOfGivenSum(root, sum - root.val, resultArr, itemsList);
      return resultArr;
   }

   private void findAllApthOfGivenSum(TreeNode aRoot, int aSum, List<List<Integer>> aResultArr, List<Integer> itemsList)
   {
      if (aSum == 0)
      {
         if (aRoot.left == null && aRoot.right == null)
         {
            List<Integer> copyList = new ArrayList<Integer>(itemsList);
            aResultArr.add(copyList);
            itemsList.remove(itemsList.size() - 1);
            return;
         }
      }
      if (aRoot.left != null)
      {
         itemsList.add(aRoot.left.val);
         findAllApthOfGivenSum(aRoot.left, aSum - aRoot.left.val, aResultArr, itemsList);
      }

      if (aRoot.right != null)
      {
         itemsList.add(aRoot.right.val);
         findAllApthOfGivenSum(aRoot.right, aSum - aRoot.right.val, aResultArr, itemsList);
      }

      itemsList.remove(itemsList.size() - 1);
   }

   public static void main(String[] args)
   {

   }

}
