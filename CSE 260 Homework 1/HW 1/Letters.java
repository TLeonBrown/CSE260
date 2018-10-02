//Tian Brown, 111597217
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Letters {
	
	public static void main (String [] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a file name.");
		String filename = scan.nextLine();
		scan.close();
		
		Set<Character> vowels = new HashSet<>();
		int numVowels = 0;
		int numConsonants = 0;
		
		FileReader fr = new FileReader(filename);
		
		int i;
		while ((i = fr.read()) != -1) {
			char ch = (char)i;
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || 
					ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
				numVowels++;
				vowels.add(ch);
			}
			else if (ch != '.' || ch != ',' || ch != '?' || ch != '/' || ch != '-' || ch != ' '){
				numConsonants++;
			}
		}
		
		Iterator<Character> it = vowels.iterator();
		
		System.out.println("Number of vowels: " + numVowels);
		System.out.print("Vowels: ");
		while (it.hasNext()) {
			System.out.print(it.next().toString() + " ");
		}
		System.out.println("Number of consonants: " + numConsonants);

		
	}	

}
