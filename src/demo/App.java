package demo;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
	public static int GetRandomNumber(int lengthOfList){
		Random rand = new Random();
		int randomNumber = rand.nextInt(lengthOfList);
		return randomNumber;
	};
	
	public static int GetNewRandomNumber(int lengthOfList, int previousNumber){
		Random rand = new Random();
		int randomNumber = rand.nextInt(lengthOfList);
		while(randomNumber == previousNumber) {
			randomNumber = rand.nextInt(lengthOfList);
		}
		return randomNumber;
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String newLineString = System.getProperty("line.separator");
		String[] settings = {"Washington D.C.", "Amazon Rainforest", "Abandoned Factory"};
		String[] weapons = {"Bare Hands", "Pirate's Sword", "Nunchucks"};
		String[] villains = {"Joker", "Dr. Octopus", "Thanos"};
		
//		get initial values
		int randomNumberSetting = GetRandomNumber(3);
		int randomNumberWeapon = GetRandomNumber(3);
		int randomNumberVillain = GetRandomNumber(3);
		
		String resultSettingString = settings[randomNumberSetting];
		String resultWeaponString = weapons[randomNumberWeapon];
		String resultVillainString = villains[randomNumberVillain];

//		add to array list and print each value
		ArrayList<String> myAdventure = new ArrayList<String>();
		myAdventure.add(resultSettingString);
		myAdventure.add(resultWeaponString);
		myAdventure.add(resultVillainString);
		
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
					int indexSetting = GetNewRandomNumber(3, randomNumberSetting);
					String newSettingString = settings[indexSetting];
					myAdventure.set(0, newSettingString);
					System.out.println("Prev setting = " + oldSettingString + newLineString + "New setting = " + newSettingString);
					break;
				case "2":
					String oldWeaponString = myAdventure.get(1);
					int indexWeapon = GetNewRandomNumber(3, randomNumberWeapon);
					String newWeaponString = weapons[indexWeapon];
					myAdventure.set(1, newWeaponString);
					System.out.println("Prev weapon = " + oldWeaponString + newLineString + "New weapon = " + newWeaponString);
					break;
				case "3":
					String oldVillainString = myAdventure.get(2);
					int indexVillain = GetNewRandomNumber(3, randomNumberVillain);
					String newVillainString = villains[indexVillain];
					myAdventure.set(2, newVillainString);
					System.out.println("Prev villain = " + oldVillainString + newLineString + "New villain = " + newVillainString);
					break;
			};	
			
		};
	
	}

}
