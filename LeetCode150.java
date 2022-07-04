package leetcodepractice;

import java.util.Stack;

public class LeetCode150
{
   private interface Operation
   {
      public int doOperate(int a, int b);
   }

   Operation sumOpt = (a, b) -> a + b;

   Operation subtractOpt = (a, b) -> a - b;

   Operation multiplyOpt = (a, b) -> a * b;

   Operation divideOpt = (a, b) -> a / b;

   public int evalRPN(String[] tokens)
   {
      return calculateResult(tokens);
   }

   private int calculateResult(String[] aTokens)
   {
      Stack<Integer> st = new Stack<Integer>();
      for (int i = 0; i < aTokens.length; i++)
      {
         if (!calculateOpt(aTokens[i], st))
         {
            String str = aTokens[i];
            Integer in = Integer.parseInt(str);
            st.push(in);
         }
      }
      return st.pop();
   }

   private boolean calculateOpt(String token, Stack<Integer> st)
   {
      int firstItem, secondItem, result;
      switch (token)
      {
         case "+":
            firstItem = st.pop();
            secondItem = st.pop();
            result = sumOpt.doOperate(secondItem, firstItem);
            st.push(result);
            return true;
         case "-":
            firstItem = st.pop();
            secondItem = st.pop();
            result = subtractOpt.doOperate(secondItem, firstItem);
            st.push(result);
            return true;
         case "*":
            firstItem = st.pop();
            secondItem = st.pop();
            result = multiplyOpt.doOperate(secondItem, firstItem);
            st.push(result);
            return true;
         case "/":
            firstItem = st.pop();
            secondItem = st.pop();
            result = divideOpt.doOperate(secondItem, firstItem);
            st.push(result);
            return true;
         default:
            return false;
      }

   }

   public static void main(String[] args)
   {
      String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
      LeetCode150 soln = new LeetCode150();
      System.out.println(soln.evalRPN(tokens));
   }

}
