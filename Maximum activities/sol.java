import java.util.*;

public class Solution { 
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here

       ArrayList<Interval> arr= new ArrayList<>();


        for(int i=0;i<start.size();i++){

            arr.add(new Interval(start.get(i), end.get(i)));
           
        }

        Collections.sort(arr);

        int count =1;
        int currEnd = arr.get(0).end;

        for(int i=1;i<arr.size();i++){

            if(arr.get(i).start >= currEnd){
                count++;
                currEnd = arr.get(i).end;
            }
        }

        return count;
    }
}

class Interval implements Comparable<Interval>{
    int start;
    int end;

    Interval(int start,int end){
        this.start = start;
        this.end  = end;
    }

    @Override
    public int compareTo(Interval other){
        if(this.end != other.end){
            return this.end-other.end;
        }else{
           return this.start - other.start;
        }
    }
}