package leetcodepractice;
import java.util.PriorityQueue;

public class HitCounter
{
   PriorityQueue<Integer> timeStampQueue;

   /** Initialize your data structure here. */
   public HitCounter()
   {
      timeStampQueue = new PriorityQueue<Integer>();

   }

   /**
    * Record a hit.
    * 
    * @param timestamp - The current timestamp (in seconds granularity).
    */
   public void hit(int timestamp)
   {
      if (!timeStampQueue.isEmpty())
      {
         int olderTimeStamp = timeStampQueue.peek();
         while (!timeStampQueue.isEmpty() && timestamp - olderTimeStamp >= 300)
         {
            timeStampQueue.poll();
            if (!timeStampQueue.isEmpty())
               olderTimeStamp = timeStampQueue.peek();
         }
      }
      timeStampQueue.add(timestamp);
   }

   /**
    * Return the number of hits in the past 5 minutes.
    * 
    * @param timestamp - The current timestamp (in seconds granularity).
    */
   public int getHits(int timestamp)
   {
      if (!timeStampQueue.isEmpty())
      {
         int olderTimeStamp = timeStampQueue.peek();
         while (!timeStampQueue.isEmpty() && timestamp - olderTimeStamp >= 300)
         {
            timeStampQueue.poll();
            if (!timeStampQueue.isEmpty())
               olderTimeStamp = timeStampQueue.peek();
         }
      }
      return timeStampQueue.size();
   }

   public static void main(String[] args)
   {

   }

}
