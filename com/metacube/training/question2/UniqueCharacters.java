package com.metacube.training.question2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class is used to count the number of unique characters in a string and
 * cache to store previous string result
 * 
 * @author admin
 *
 */

public class UniqueCharacters {

	private Map<String,Integer> cache;
	
	public Map<String, Integer> getCache() {
		return cache;
	}
	public void setCache(Map<String, Integer> cache) {
		this.cache = cache;
	}
	public UniqueCharacters() {
		
		this.cache=new HashMap<String, Integer>();
	}
	
	/**
	 * Method to count the number of unique characters in a string
	 * 
	 * @param string
	 * @return count of unique characters
	 */

	public int countUniqueCharacters(String inputString){
		
		Set<Character> uniqueChar=new HashSet<Character>();
		
		if(inputString==null || inputString.equals(" ")){
			
			throw new AssertionError("input string is invalid");
			
		}
		else{
			if(cache.containsKey(inputString)){
				return cache.get(inputString);
			}
			else{
				
				inputString=inputString.toLowerCase();
				
				for(int i=0;i<inputString.length();++i){
					
					char charAtIndex=inputString.charAt(i);
					
					if(charAtIndex==' '){
						continue;
					}
					else{
						if(!uniqueChar.contains(charAtIndex)){
							uniqueChar.add(charAtIndex);
						}
					}
				}
			}
		}
		cache.put(inputString, uniqueChar.size());
		return uniqueChar.size();
	}
	
	
}
