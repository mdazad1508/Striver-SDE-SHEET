class Solution {
    public String longestCommonPrefix(String[] strs) {

        Trie t = new Trie();
        for(int i=0;i<strs.length;i++){
            t.add(strs[i]);
        }
        int index = -1;

        Trie curr = t;

        for(int i=0;i<strs[0].length();i++){
            char ch = strs[0].charAt(i);
            curr = curr.letters[ch-'a'];
            if(curr.prefixCount ==strs.length){
               index = i;
            }else{
                break;
            }
            
        }

        return strs[0].substring(0,index+1);

    }

}

class Trie{
    Trie [] letters ;
    int prefixCount ;
    boolean isEnd;

    Trie(){
        this.letters = new Trie[26];
        this.prefixCount = 0;
        this.isEnd  = false;
    }

    void add(String s){
        Trie curr = this;

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
            if(curr.letters[ch-'a']==null){
                curr.letters[ch-'a'] = new Trie();
            }
          
           curr = curr.letters[ch-'a'];
           curr.prefixCount ++;

        }
        curr.isEnd = true;
    }
}