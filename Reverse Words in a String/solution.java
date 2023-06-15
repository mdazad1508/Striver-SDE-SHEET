class Solution {
    public String reverseWords(String s){
        
        String [] parts = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<parts.length;i++){
              
            if(parts[parts.length-1-i].equals("")){
                continue;
            }

            sb.append(parts[parts.length-1-i]);
            sb.append(" ");
        }

        return sb.toString().trim();

    }
}