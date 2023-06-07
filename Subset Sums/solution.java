
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        fun(0,ans,arr,0);
        return ans;
    }
    
    static void fun(int index, ArrayList<Integer> ans, ArrayList<Integer> arr, int sum){
        
        if(index ==arr.size()){
            ans.add(sum);
            return;
        }
        
        //pick 
        
        fun(index+1,ans,arr,sum+arr.get(index));
        
        //not pick;
        
        fun(index+1,ans,arr,sum);
    }
}