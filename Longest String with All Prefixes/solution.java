import java.util.* ;
import java.io.*; 

class Solution {

  public static String completeString(int n, String[] a) {
    // Write your code here.
      Trie t  = new Trie();
    for(int i=0;i<n;i++){
        t.insert(a[i]);
    }

    String ans ="";

    for(int i=0;i<n;i++){
      
      boolean isValidAns = true;
      for(int j=0;j<a[i].length();j++){
        String prefix = a[i].substring(0,j+1);
        if(t.search(prefix)==false){
          isValidAns = false;
          break;
        }
      }

      if(isValidAns){
        if(a[i].length()>ans.length()){
          ans = a[i];
        }else if(a[i].length()==ans.length()){
          boolean isLexo = true; 
           for(int k=0;k<a[i].length();k++){
              if(a[i].charAt(k)<ans.charAt(k)){
                break;
              }else if(a[i].charAt(k)>ans.charAt(k)){
                isLexo=false;
                break;
              }else{
                continue;
              }
          }

          if(isLexo){
            ans = a[i];
          }

        }
      }
    
    }
    
    if(ans.length()==0) return "None";
    return ans;

  }
}
 class Trie {
    
    Trie[] characters ;
    boolean isWordEnd;
    int prefixCount;
    int countEndWith =0;
    public Trie() {
        characters =new Trie[26];
        isWordEnd =false;
        prefixCount = 0;
    }

    public void insert(String word) {
        Trie curr = this;

        for(int i=0;i<word.length();i++){
            char letter = word.charAt(i);

            if(curr.characters[letter-'a']==null){
                curr.characters[letter-'a'] = new Trie();
            }
           
            curr = curr.characters[letter-'a'];
            curr.prefixCount++;
        }

        curr.isWordEnd = true;

    }
    public boolean search(String word) {

        Trie curr = this;

        for(int i=0;i<word.length();i++){
           char letter = word.charAt(i);
            if(curr.characters[letter-'a']==null){
                return false;
            }else{
                curr = curr.characters[letter-'a'];
            }
        }

        return curr.isWordEnd ;
        
    }
}
