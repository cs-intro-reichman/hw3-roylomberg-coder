/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		int n = str1.length();
		char c = ' ';
		int idx; 



		if (str1.length() == str2.length()){
		for(int i =0; i < n; i ++ ){

			 c = str1.charAt(i);
			 if (str2.indexOf(c) != -1){
				idx = str2.indexOf(c);
				str2 = str2.substring(0, idx) +str2.substring(idx +1);
			 }
			 else{
				return false;
			 }
			}
			return true;

			}
			
			return false;
		}
		

		
		
	
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String result =""; 
		for(int i=0; i < str.length();i++){
			char c = str.charAt(i);
			if( c >= 'a' && c <= 'z'){
				result += c;
			}
			else if (c >= 'A' && c <='Z') {
				c = Character.toLowerCase(c);
				result +=c;
			}
			

		}
	   return result;
	}

		
	 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		int length = str.length();
		String str2 = "";
		char c;

		for(int i = 0; i < length; i++){
		int idx = (int)(Math.random()* str.length());
		c = str.charAt(idx);
		str = str.substring(0,idx) +str.substring(idx +1); 
		str2 += c;


		}
		return str2;
	}
}
