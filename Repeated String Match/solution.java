class Solution {
    public int repeatedStringMatch(String a, String b) {

        if(a.length()==0 ){
            return -1;
        }

        if(b.length()==0){
            return 0;
        }

        StringBuilder sb= new StringBuilder(a);
        int noOfRepeats = b.length()/a.length() + 2;  // (important)
        int count = 1;

        for(int i=1;i<=noOfRepeats;i++){
            
            if(sb.toString().contains(b)){
                return count;
            }else{
                sb.append(a);
                count++;
            }
        }

        return -1;
        
    }
}