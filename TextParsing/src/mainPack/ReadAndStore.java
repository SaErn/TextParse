/* Read and Store 
 * v 1.0 
 * 2020-09-16 */
package mainPack;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAndStore {

	private final static Charset ENCODING = StandardCharsets.UTF_8;

	private static boolean firstLineRemoved = false; /* false tills f�rsta raden av inl�st dokument ignorerad */
	private static ArrayList<String> newGroup; /* Lagrar inl�st grupp */
	private static ArrayList<ArrayList<String>> groupList = new ArrayList<ArrayList<String>>(); /*
																								 * Lagrar alla grupper
																								 */

	public static ArrayList<ArrayList<String>> getList() {

		return groupList;
	}

	/*
	 * L�ser in enskilda rader fr�n fil och skickar dessa som argument i parseLine
	 * metoden. K�rs till scanner ej kan h�mta fler rader fr�n dokument
	 */
	public static void readFile() {

		try (Scanner scanner = new Scanner(Paths.get("sample.csv"), ENCODING)) {
			while (scanner.hasNextLine()) {
				parseLine(scanner.nextLine());
			}
		} catch (IOException e) {

		}
	}

	/*
	 * Tar emot string best�ende av rad inl�st fr�n dokument som delas upp baserat
	 * p� kommateckens position. De uppdelade bitarna text lagras i varsin string
	 * som sen skickas som argument till storeGroup metoden. F�rsta raden text
	 * ignoreras d� denna ej inneh�ller relevant information K�rs till timeStamp
	 * variabel ej l�ngre tar emot n�got v�rde, dvs. n�r scanner b�rjar l�sa raderna
	 * i dokumentet som bara best�r av kommatecken
	 */
	public static void parseLine(String line) {

		try (Scanner scanner = new Scanner(line)) {
			scanner.useDelimiter(",");
			
			if (scanner.hasNext()) {
				
				String timeStamp = scanner.next();
				
				if (timeStamp.isBlank() == false) {
			
					String member1 = scanner.next();
					String member2 = scanner.next();
					String email1 = scanner.next();
					String email2 = scanner.next();
					String ownAndroid = scanner.next();
					String assignment = scanner.next();

					member1 = member1.trim();
					member2 = member2.trim();
					email1 = email1.trim();
					email2 = email2.trim();
					ownAndroid = ownAndroid.trim();
					assignment = assignment.trim();
					timeStamp = timeStamp.trim();

					if (firstLineRemoved) {
						storeGroup(timeStamp, member1, email1, member2, email2, ownAndroid, assignment);
					}
					firstLineRemoved = true;

				}

			} else {

			}
		}
	}

	/*
	 * Skapar arraylist som lagrar mottagna stringar fr�n parseLine(). Dessa
	 * representerar en grupp som sen sparas i ArrayList med ArrayListor i.
	 */
	public static void storeGroup(String timeStamp, String member1, String email1, String member2, String email2,
			String ownAndroid, String assignment) {

		newGroup = new ArrayList<String>();

		newGroup.add(timeStamp);
		newGroup.add(member1);
		newGroup.add(member2);
		newGroup.add(email1);
		newGroup.add(email2);
		newGroup.add(ownAndroid);
		newGroup.add(assignment);
		groupList.add(newGroup);

	}

	/*
	 * Skriver ut texten insamlad fr�n dokumentet i sorterade och formaterade rader
	 * och kolumner. G�r igenom listan med grupper, h�mtar och skriver ut
	 * informationen som finns sparade f�r respektive. System.out.printf() skriver
	 * ut formaterade strings. F�rsta argumentet st�r f�r hur string argumenten som
	 * f�ljer ska formateras. %-8s betyder f�ljande % f�ljt av bokstaven "s" betyder
	 * att det ska vara en string Minustecknet visar vilken sida padding ska sitta
	 * p� Heltalet visar hur m�nga mellanrum till padding
	 */
	public static void printAll() {

		String time;
		String member1;
		String member2;
		String email1;
		String email2;
		String androidOwner;
		String assignment;

		System.out.printf("%-8s%-15s%-22s%-15s%-22s%-22s%-22s%-22s\n", "Group", "Member 1", "Email 1", "Member 2",
				"Email 2", "Own Android?", "Assignment", "Time");

		for (int i = 0; i < groupList.size(); i++) {

			time = groupList.get(i).get(0);
			member1 = groupList.get(i).get(1);
			member2 = groupList.get(i).get(2);
			email1 = groupList.get(i).get(3);
			email2 = groupList.get(i).get(4);
			androidOwner = groupList.get(i).get(5);
			assignment = groupList.get(i).get(6);

			System.out.format("%-8s%-15s%-22s%-15s%-22s%-22s%-22s%-22s\n", i + 1, member1, email1, member2, email2,
					androidOwner, assignment, time);
		}

	}

}
