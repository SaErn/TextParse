/* Launcher 
 * v 1.0 
 * 2020-09-16 */
package mainPack;

public class Launcher {

	public static void main(String[] args) {

		ReadAndStore.readFile();				/* Läser in rader från fil, skickar dessa som argument i anrop till parseLine metod */
		
		ReadAndStore.printAll();				/* Skriver ut filens innehåll i sorterade och formaterade rader och kolumner */
		
		ListSearcher.countLetter();				/* Räknar och skriver ut hur många av namnen i listan som innehåller bokstaven a */
		
		ListSearcher.countAndroid();			/* Räknar ut hur många grupper som ska jobba med android-app */

		ListSearcher.printDuplicateTime();		/* Metoden som anropas anropar själv en metod som jämför om två grupper har samma tidstämpel och skriver ut detta */
		
		ListSearcher.printDuplicateEmail();		/* Anropar själv metod som jämför om finns likadana emails i samling och skriver ut resultat */
		
		
	}

}
