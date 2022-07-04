package leetcodepractice;
import java.util.HashMap;
import java.util.Map;

/////////////////////////////////////////////////////////////////////////////
// Property of Informatica.
// (C) Copyright 2020 Informatica LLC
// All Rights Reserved.
/////////////////////////////////////////////////////////////////////////////

public class LeetCode134
{
   int gasIncar = 0;

   public int canCompleteCircuit(int[] gas, int[] cost)
   {
      Map<Integer, Boolean> neededGasMap = new HashMap<Integer, Boolean>();
      for (int i = 0; i < gas.length; i++)
      {
         int gasNeeded = gas[i] - cost[i];
         neededGasMap.put(i, gasNeeded > 0 ? true : false);
         if (gasNeeded < 0)
            continue;
         gasIncar = gasNeeded;
         if (isPossibleFromIndex(gas, cost, i + 1, i, neededGasMap))
            return i;
      }
      return -1;
   }

   private boolean isPossibleFromIndex(int[] aGas, int[] aCost, int currentIndex, int startIndex,
         Map<Integer, Boolean> aNeededGasMap)
   {
      if (currentIndex >= aGas.length)
         currentIndex = 0;

      if (currentIndex == startIndex)
         return true;

      gasIncar = gasIncar + aGas[currentIndex] - aCost[currentIndex];
      if (gasIncar >= 0)
      {
         return isPossibleFromIndex(aGas, aCost, currentIndex + 1, startIndex, aNeededGasMap);
      }
      return false;
   }

   public static void main(String[] args)
   {
      int[] gas = { 3, 1, 1 };
      int[] cost = { 1, 2, 2 };

      LeetCode134 soln = new LeetCode134();
      int i = soln.canCompleteCircuit(gas, cost);
      System.out.println(i);

   }

}
