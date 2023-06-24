import java.util.ArrayList;

public class Solution 
{

	public static int countDistinctSubstrings(String s) 
	{
        int count =0;
		Trie t = new Trie();
		for(int i=0;i<s.length();i++){

			for(int j=i+1;j<=s.length();j++){
               
			   if(!t.search(s.substring(i,j))){
                 t.insert(s.substring(i,j));
                 count++;
			   }
			  
			}
		}
		return count+1;
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