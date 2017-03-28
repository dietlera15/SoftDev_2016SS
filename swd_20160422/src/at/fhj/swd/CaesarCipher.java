package at.fhj.swd;

public class CaesarCipher implements Cipher {
	@Override
	public String encrypt(String plainText, String keyStr) {
		int key = Integer.parseInt(keyStr);
		return applyCaesar(plainText, key);
	}

	@Override
	public String decrypt(String plainText, String keyStr) {
		int key = Integer.parseInt(keyStr);
		return applyCaesar(plainText, -key);
	}
		
	protected String applyCaesar(String text, int key){
		char[] result = new char[text.length()];
			
		for(int i = 0; i < text.length(); i++){
			char curLetter = text.charAt(i);
			
			if((curLetter >= 'A' && curLetter <= 'Z'))
			{
				curLetter  =  (char) ('A' +( ((curLetter - 'A') + key)  % 26));
			}
			else if (curLetter >= 'a' && curLetter <= 'z')
			{
				curLetter =  (char) ('a' +( ((curLetter - 'a') + key)  % 26));
			}
			result[i] = curLetter;
				
		}
		
		return new String(result);
		
	}
	
}
