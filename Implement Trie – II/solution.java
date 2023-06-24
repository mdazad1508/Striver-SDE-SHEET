import java.util.* ;
import java.io.*; 
public class Trie {
    
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
        curr.countEndWith++;
    }

    public int countWordsEqualTo(String word) {
        
        Trie curr = this;

        for(int i=0;i<word.length();i++){
            char letter = word.charAt(i);

            if(curr.characters[letter-'a']==null ){
                return 0;
            }else{
                curr = curr.characters[letter-'a'];
            }
        }
        
        return curr.countEndWith;
        // if(curr.isWordEnd) return curr.prefixCount;
        // return 0;
    }

    public int countWordsStartingWith(String word) {
        
         Trie curr = this;

        for(int i=0;i<word.length();i++){
            char letter = word.charAt(i);

            if(curr.characters[letter-'a']==null ){
                return 0;
            }else{
                curr = curr.characters[letter-'a'];
            }
        }
         
        return curr.prefixCount;
    }

    public void erase(String word) {
        // Write your code here.

        Trie curr = this;

        for(int i=0;i<word.length();i++){
            char letter = word.charAt(i);

            curr = curr.characters[letter-'a'];
            curr.prefixCount--;
        }
        
        curr.countEndWith--;
        
    }
