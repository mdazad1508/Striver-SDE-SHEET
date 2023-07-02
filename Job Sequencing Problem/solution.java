class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
       //we perform any job in last of its deadline;
       
       int maxDeadline =0;
       
       for(int i=0;i<arr.length;i++){
           maxDeadline  = Math.max(maxDeadline,arr[i].deadline);
       }
       
       //so we have till maximum deadline to perform any job;
       
       int [] performed = new int[maxDeadline+1];
       for(int i=1;i<performed.length;i++){
           performed[i] = -1;
       }
       
       //sort the job according to maximum profit
       
       Arrays.sort(arr,(a,b)->(b.profit-a.profit));
       
       
       int count =0;
       int profit =0;
       
       for(int i=0;i<arr.length;i++){
           
           Job x = arr[i];
           
           //for last day of deadline
           for(int j= x.deadline;j>0;j--){
               
               if(performed[j]==-1){
                   //not performed
                   performed[j]=x.id;
                   count++;
                   profit+=x.profit;
                   break;
               }
           }
       }
       
       return new int[]{count,profit};
    }
}
