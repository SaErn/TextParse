/* Launcher 
 * v 1.0 
 * 2020-09-16 */
package mainPack;

public class Launcher {

	public static void main(String[] args) {

		ReadAndStore.readFile();				/* L�ser in rader fr�n fil, skickar dessa som argument i anrop till parseLine metod */
		
		ReadAndStore.printAll();				/* Skriver ut filens inneh�ll i sorterade och formaterade rader och kolumner */
		
		ListSearcher.countLetter();				/* R�knar och skriver ut hur m�nga av namnen i listan som inneh�ller bokstaven a */
		
		ListSearcher.countAndroid();			/* R�knar ut hur m�nga grupper som ska jobba med android-app */

		ListSearcher.printDuplicateTime();		/* Metoden som anropas anropar sj�lv en metod som j�mf�r om tv� grupper har samma tidst�mpel och skriver ut detta */
		
		ListSearcher.printDuplicateEmail();		/* Anropar sj�lv metod som j�mf�r om finns likadana emails i samling och skriver ut resultat */
		
		
	}

}
