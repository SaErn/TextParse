/* List Searcher 
 * v 1.0 
 * 2020-09-16*/
package mainPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ListSearcher {

	/*
	 * Testar hur många av namnen på deltagarna från dem olika som innehåller
	 * bokstaven "a" och räknar dessa. Gör detta genom att itererar genom hela
	 * listan med grupper och först hämta alla medlem 1 och testa om stort eller
	 * litet "a" har någon indexposition i ordet, dvs namnet har bokstav a. Sen görs
	 * samma sak med alla medlem 2 från grupperna. Skriver till sist ut resultatet.
	 */
	public static void countLetter() {
		char smallA = 'a';
		char bigA = 'A';

		ArrayList<ArrayList<String>> groupList = ReadAndStore.getList();
		int nrFound = 0;

		for (int i = 1; i < 3; i++) {
			for (int j = 0; j < groupList.size(); j++) {

				if (groupList.get(j).get(i).indexOf(smallA) != -1 || groupList.get(j).get(i).indexOf(bigA) != -1) {
					nrFound++;
				}
			}
		}
		System.out.println("\nNr of people with A in their name: " + nrFound);

	}

	/*
	 * Itererar igenom listan med grupp-arrayListor och testar vilka som innehåller
	 * ordet "android" på indexplatsen som håller string som står för vilken
	 * uppgift(assignment) gruppen blivit tilldelade(android app eller arduino).
	 * Skriver sedan ut hur många som ska jobba med android
	 */
	public static void countAndroid() {
		ArrayList<ArrayList<String>> groupList = ReadAndStore.getList();
		int nrAndroid = 0;

		for (int j = 0; j < groupList.size(); j++) {

			if (groupList.get(j).get(6).contains("Android")) {
				nrAndroid++;
			}
		}
		System.out.println("\nNr of groups that will work with Android app: " + nrAndroid);
	}

	/*
	 * Anropar findDuplicateTime() som returnera lista med grupper som har samma
	 * tidstämpel, dessa skrivs sen ut i konsoll
	 */
	public static void printDuplicateTime() {
		ArrayList<String> duplicates = findDuplicateTime();

		for (int i = 0; i < duplicates.size(); i++) {
			System.out.println(duplicates.get(i));
		}

	}

	/*
	 * Letar igenom listan med grupper efter grupper som har samma tidstämpel.
	 * Lagrar alla tidstämplar i en String-array så tiderna kan jämföras med
	 * equals(). När metoden stöter på duplikater av tiderna så lagras dessa i en
	 * särskild lista(duplicates) som sen reurneras till metod som printar
	 */
	public static ArrayList<String> findDuplicateTime() {
		ArrayList<ArrayList<String>> groupList = ReadAndStore.getList();
		String[] timesForCompare = new String[groupList.size()];
		ArrayList<String> duplicates = new ArrayList<String>();

		for (int i = 0; i < groupList.size(); i++) {
			timesForCompare[i] = groupList.get(i).get(0);
		}

		for (int i = 0; i <= timesForCompare.length; i++) {
			for (int j = i + 1; j < timesForCompare.length; j++) {
				if (timesForCompare[i].equals(timesForCompare[j])) {
					duplicates.add("\nGroups " + (i + 1) + " and " + (j + 1) + " have the same Timestamp "
							+ timesForCompare[i]);
				}
			}
		}

		return duplicates;

	}

	/*
	 * Samma som printDuplicateTime ovan fast denna anropar istället
	 * findDuplicateEmail()
	 */
	public static void printDuplicateEmail() {
		ArrayList<String> duplicates = findDuplicateEmail();

		for (int i = 0; i < duplicates.size(); i++) {
			System.out.println(duplicates.get(i));
		}

	}

	/*
	 * Hämtar listan med grupper. Skapar två String-array som är dubbelt så stora
	 * som listan med grupper då dem ska hålla alla personer på listan i enskilda
	 * index. Även här används ArrayList duplicates för att spara mail och namn på
	 * dem personer som visat sig ha samma mail. SaveSlot används så alla personer
	 * och emails sparas i rätt ordning. Itererar sen lika många gånger som
	 * duplikater metoden stött på och lagrar dessa fall i listan duplicates
	 */
	public static ArrayList<String> findDuplicateEmail() {
		ArrayList<ArrayList<String>> groupList = ReadAndStore.getList();
		String[] emailsForCompare = new String[groupList.size() * 2];
		String[] mailOwnerName = new String[groupList.size() * 2];
		ArrayList<String> duplicates = new ArrayList<String>();
		int saveSlot = 0;

		for (int i = 0; i < groupList.size(); i++) {
			emailsForCompare[saveSlot] = groupList.get(i).get(3);
			mailOwnerName[saveSlot] = groupList.get(i).get(1);
			saveSlot++;
			emailsForCompare[saveSlot] = groupList.get(i).get(4);
			mailOwnerName[saveSlot] = groupList.get(i).get(2);
			saveSlot++;

		}

		for (int i = 0; i <= emailsForCompare.length; i++) {
			for (int j = i + 1; j < emailsForCompare.length; j++) {
				if (emailsForCompare[i].equals(emailsForCompare[j])) {
					duplicates.add("\nWarning! User " + mailOwnerName[i] + " and " + mailOwnerName[j]
							+ " have the same Email:  " + emailsForCompare[i]);
				}
			}
		}

		return duplicates;

	}

}
