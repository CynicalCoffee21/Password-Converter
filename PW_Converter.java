import java.util.Scanner;
/**
 * This program is essentially a way to turn sentences/phrases/words into password acceptable alternatives.
 * It replaces spaces with underscores, and certain letters with numbers/symbols.
 * 
 * For example, here are some words/phrases and their converted alternatives (according to the program):
 *     password  :  p@ssw0rd
 *     bad password phrase  :  b@d_p@ssw0rd_phr@s3
 *     Applicable test sentence for the program.  :  4ppl!c@bl3_t3st_s3nt3nc3_f0r_th3_pr0gr@m.
 * 
 * It is somewhat predictable after a while, or if you know how it works (which isn't that complicated really)
 * but it's still a decent way of turning regular text passwords into something a little more secure.
 * 
 * @author Ryan Buchanan
 *
 */
public class PW_Converter {
	
	private static char[] VOWEL = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
	private static char[] SYMBOL = { '@', '3', '!', '0', '*', '4', '3', '1', '0', '*'};
	
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		String in = "";
		System.out.println("******************************************************************************");
		System.out.println("* This system will take a word, phrase, or sentence and swap certain         *\n" +
						   "* letters/spaces with numbers/symbols to convert it into a decent password.  *\n" +
						   "* Feel free to include any of your own symbols or numbers and capitalization *\n" +
						   "* doesn't matter, other than determining certain symbols.                    *");
		System.out.println("******************************************************************************");
		while( true ){
			
			Scanner input = new Scanner( System.in );

			System.out.println("Please enter a phrase/sentence you wish to convert and hit enter, or type exit to quit the program. ");
			in = input.nextLine();
			in.trim();
			
			if( in.equals("exit") || in.equals("Exit") || in.equals("EXIT") ) {
				System.out.println("Goodbye.");
				input.close();
				System.exit(0);
			}
			
			System.out.println("Recieved : " + in);
			
			String spaceless = spaceToUnderscore(in);
			String symboled = vowelToSymbol(spaceless);
			
			System.out.println("\nNew : " + symboled + "\n");
		}

	}	
	/**
	 * Replaces all the spaces in the given string with underscores
	 * @param pw given String
	 * @return space-less String
	 */
	private static String spaceToUnderscore(String pw) {
		StringBuilder spaceless = new StringBuilder();		
		for(int i = 0; i < pw.length(); i++){
			char subject = pw.charAt(i);
			if( subject == ' ') {
				spaceless.append('_');
			} else {
				spaceless.append(subject);
			}
		}
		return spaceless.toString();
	}
	/**
	 * Converts certain letters to symbols. The array says vowels, but it excludes u/U.
	 * The symbol array also includes numbers and not just symbols.
	 * @param pw given String
	 * @return returns a fully converted $tr!ng
	 */
	private static String vowelToSymbol(String pw){
		StringBuilder symboled = new StringBuilder();
		boolean found = false;
		for(int i = 0; i < pw.length(); i++){
			char subject = pw.charAt(i);
			for(int j = 0; j < VOWEL.length; j++ ) {
				if( subject == VOWEL[j]) {
					symboled.append(SYMBOL[j]);
					found = true;
					break;
				} 
			}
			if(found == true) {
				found = false;
				continue;
			} else
				symboled.append(subject);			
		}		
		return symboled.toString();
	}
}
