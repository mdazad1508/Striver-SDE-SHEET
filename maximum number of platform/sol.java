
class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
       Arrays.sort(arr);
       Arrays.sort(dep);
       
       int i = 1;
       int j = 0;
       
       
       int ans = 1;
       int platform = 1;
       
       while(i <arr.length){
           
           if(arr[i]<= dep[j]){
               //you need extra platform
               platform ++;
               i++;
           }else{
               //one of the platfrom will be vacant;
               platform --;
               j++;
           }
           
           ans = Math.max(ans,platform);
       }
       
       return ans;
    }
    
}