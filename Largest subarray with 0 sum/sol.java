 //won't work if array contains only positives 
 // for only positives use shrinking expanding subarray
class GfG
{
    int maxLen(int arr[], int n)
    {
        int k=0 ;  //target
        
        HashMap<Integer,Integer> hmap = new HashMap<>();
        //key-prefixSum and val- index;
        
        int maxLength =0;
        int sum =0;
        
        for(int i=0;i<arr.length;i++){
            
            sum+= arr[i];
            
            if(sum==k){
                //it is a valid subarray from index 0; which is maximum length; that's why there is else , nahi to ussey remove kar skte hai , kyuki remaining wale se ussey chota length hi aayega
                int len = i+1;
                maxLength = Math.max(maxLength,len);
            }else{
                
                //it is not a valid subaary but let me check if there exist remSum prevously,
                // it remaining sum exists means from remSum index to i is my valid subaary
                
                int rem = sum-k;
                
                if(hmap.containsKey(rem)){
                    int lenRem = i-hmap.get(rem);
                    maxLength = Math.max(maxLength, lenRem);
                }
                
            }
            
            //if same prefixsum contains previously , you don't wanna replace it with 
            //new one , because that will increase the index and will decrease subaary length
            
            if(!hmap.containsKey(sum)) hmap.put(sum,i);
            
        }
        
        return maxLength;
    }
}