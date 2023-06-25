
class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        List<String> list = new ArrayList<>();
        int n = s.length();
        // 2^n -1 = (1<<n)-1
        
        //to check any bit is set or not ex 100 
        // 100 & 1 <<2 !=0 then set ,else not set;
        
        for(int i=0;i<= (1<<n)-1 ;i++){
            String sub ="";
            for(int j=0;j<n;j++){
                
                if((i & (1<<j)) !=0){
                    sub += s.charAt(j);
                }
            }
            
            if(sub==""){
                continue;
            }
            list.add(sub);
        }
        
        Collections.sort(list);
        
        return list;
    
    }
   
}

