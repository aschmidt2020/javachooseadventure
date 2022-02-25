package demo;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
	public static String getRandomItem(String[] list){
		Random rand = new Random();
		int randomNumber = rand.nextInt(list.length);
		String resultString = list[randomNumber];
		return resultString;
	};
	
	public static String getNewRandomItemString (String[] list, String previousItem){
		Random rand = new Random();
		int randomNumber = rand.nextInt(list.length);
		String resultString = list[randomNumber];
		while(resultString == previousItem) {
			randomNumber = rand.nextInt(list.length);
			resultString = list[randomNumber];
		}
		return resultString;
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String newLineString = System.getProperty("line.separator");
		
		String[] settings = {"Washington D.C.", "Amazon Rainforest", "Abandoned Factory"};
		String[] weapons = {"Bare Hands", "Pirate's Sword", "Nunchucks"};
		String[] villains = {"Joker", "Dr. Octopus", "Thanos"};
		
//		get initial values
		String settingString = getRandomItem(settings);
		String weaponString = getRandomItem(weapons);
		String villainString = getRandomItem(villains);
//		
//		add to array list and print each value
		ArrayList<String> myAdventure = new ArrayList<String>();
		myAdventure.add(settingString);
		myAdventure.add(weaponString);
		myAdventure.add(villainString);

		System.out.println("Current Adventure (setting, weapon, villain) is...");
		for(String nameString : myAdventure) {
			System.out.println(nameString);
		}
		
//		while loop for confirming adventure
		boolean confirmed = false;
		while(confirmed == false) {
			System.out.println("What would you like to change about your adventure? 0-Nothing, confirm!, 1-Setting, 2-Weapon, 3-Villain");
			String response = sc.nextLine();
			switch(response) {
				case "0":
					System.out.println("Confirmed!" + newLineString +
							"Your adventure is..." + newLineString + 
							"Setting: " + myAdventure.get(0) + newLineString + 
							"Weapon: " + myAdventure.get(1) + newLineString + 
							"Villain: " + myAdventure.get(2));
					confirmed = true;
					break;
				case "1":
					String oldSettingString = myAdventure.get(0);
					String newSettingString = getNewRandomItemString(settings, oldSettingString);
					myAdventure.set(0, newSettingString);
					System.out.println("Prev setting = " + oldSettingString + newLineString + "New setting = " + newSettingString);
					break;
				case "2":
					String oldWeaponString = myAdventure.get(1);
					String newWeaponString = getNewRandomItemString(weapons, oldWeaponString);
					myAdventure.set(1, newWeaponString);
					System.out.println("Prev weapon = " + oldWeaponString + newLineString + "New weapon = " + newWeaponString);
					break;
				case "3":
					String oldVillainString = myAdventure.get(2);
					String newVillainString = getNewRandomItemString(villains, oldVillainString);
					myAdventure.set(2, newVillainString);
					System.out.println("Prev villain = " + oldVillainString + newLineString + "New villain = " + newVillainString);
					break;
			};	
			
		};
	
	}

}
