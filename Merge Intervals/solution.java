class Solution {

    class Interval{
        int start;
        int end;
        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        ArrayList<Interval> list = new ArrayList<>();
        
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=0;i<intervals.length-1;i++){

            if(end >= intervals[i+1][0]){
                end = Math.max(end,intervals[i+1][1]);
            }else{
                list.add(new Interval(start, end));
                start = intervals[i+1][0];
                end = intervals[i+1][1];
            }
        }

        list.add(new Interval(start,end));

        int [][] ans = new int[list.size()][2];

        for(int i=0;i<ans.length;i++){
            ans[i][0] = list.get(i).start;
            ans[i][1]  = list.get(i).end;
        }

        return ans;
        
    }
}