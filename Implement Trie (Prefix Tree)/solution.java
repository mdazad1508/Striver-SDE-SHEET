class Trie {

    Trie[] characters ;
    boolean isWordEnd;
    
    public Trie() {
        characters =new Trie[26];
        isWordEnd =false;
        
    }
    
    public void insert(String word) {

        Trie curr = this;

        for(int i=0;i<word.length();i++){
            char letter = word.charAt(i);

            if(curr.characters[letter-'a']==null){
                curr.characters[letter-'a'] = new Trie();
            }
           
            curr = curr.characters[letter-'a'];
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
    
    public boolean startsWith(String prefix) {

        Trie curr = this;

        for(int i=0;i<prefix.length();i++){
           char letter = prefix.charAt(i);
            if(curr.characters[letter-'a']==null){
                return false;
            }else{
                curr = curr.characters[letter-'a'];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */