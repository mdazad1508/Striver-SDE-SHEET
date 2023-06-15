class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){

            if(isOpen(s.charAt(i))){
                st.push(s.charAt(i));
            }else{
                 
                 if(st.isEmpty()) return false;

                if(isMatchingPair(st.peek(),s.charAt(i))){
                    st.pop();
                }else{
                    return false;
                }
            }
        }

        return st.size()==0;
 
    }
    static boolean isOpen(char c){
        return c =='(' || c=='{' || c=='[';
    }
    static boolean isClose(char c){
        return c ==')' || c=='}' || c==']';
    }
    static boolean isMatchingPair(char a, char b){

        return (a=='(' && b==')') || (a=='{' && b=='}') || (a=='[' && b==']');
    }
}