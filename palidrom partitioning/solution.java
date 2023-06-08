class Solution {
    public List<List<String>> partition(String s) {

            List<List<String>> ans = new ArrayList<>();
            fun(0,s,ans,new ArrayList<>());
            return ans;
        
    }

    static void fun(int index, String s,List<List<String>> ans , List<String> list ){

        if(index == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
      
        
        for(int i=index;i<s.length();i++){

           String sub  = s.substring(index,i+1);
           if(isPalidrome(sub)){
               list.add(sub);
               fun(i+1,s,ans,list);
               list.remove(list.size()-1);
           }

        }
    }

    static boolean isPalidrome(String s){

        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }

        return true;
    }
}