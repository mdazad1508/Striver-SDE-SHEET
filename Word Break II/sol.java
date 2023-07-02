import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		
		ArrayList<String> list  = new ArrayList<>();
		fun(0,"",s,dictionary,list);
		return list;
	}
	static void fun(int index,String ans, String s,ArrayList<String> dictionary,ArrayList<String> list){
        
		if(index==s.length()){
			list.add(ans.substring(0,ans.length()-1));
			return;
		}

		for(int i=index;i<s.length();i++){

			String sub = s.substring(index,i+1);

			if(dictionary.contains(sub)){
                
				fun(i+1,ans+sub+" ",s,dictionary,list);
			}
		}
	}
}