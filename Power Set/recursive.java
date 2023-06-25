//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        
        List<String> ans = new ArrayList<>();
        StringBuilder sb =new StringBuilder();
        fun(0,s,sb,ans);
        ans.remove("");
        Collections.sort(ans);
        return ans;
        
    
    }
    static void fun(int index, String s ,StringBuilder sb, List<String> list){
        
        if(index==s.length()){
            list.add(sb.toString());
            return;
        }
        
        
        //take 
        
        fun(index+1,s,sb.append(s.charAt(index)),list);
        
        //not take ;
        sb.deleteCharAt(sb.length()-1);
        
        fun(index+1,s,sb,list);
        
    }
}