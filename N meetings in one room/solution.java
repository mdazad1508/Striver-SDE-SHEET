 class Pair implements Comparable<Pair>{
    int start;
    int end;
    
    Pair(int start, int end){
        this.start= start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Pair p2){
        
        if(this.end != p2.end){
            return this.end- p2.end;
        }else{
            return this.start -p2.start;
        }
    }
}

class Solution 
{
    public static int maxMeetings(int start[], int end[], int n)
    {
      Pair [] interval = new Pair[start.length];
      
      for(int i=0;i<start.length;i++){
          interval[i] = new Pair(start[i],end[i]);
      }
      
      Arrays.sort(interval);
      
      int count =1;
      int currEnd = interval[0].end;
      
      for(int i=1;i<interval.length;i++){
          
          if(interval[i].start > currEnd){
              count++;
              currEnd = interval[i].end;
          }
         
          
      }
      
      return count;
      
    }
}