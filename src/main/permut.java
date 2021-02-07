package main;
import java.util.Scanner;
import cycleprobability.Probability;
import cycles.Cycles;
/**
 * Main klassen styrer menuen, tager imod bruger input og kalder metoder fra de andre klasser.
 * */

public class permut{
	private static Scanner reader;

    	public static void main(String[] args){
		reader = new Scanner(System.in);
		boolean quit = false;
		do{
			System.out.println("Enter 1 for generating a random list og length n and counting number of cycle");
			System.out.println("Enter 2 to create n lists of length l, and calculate the properbility for number of cycle");
			int menuChoice = reader.nextInt();
			reader.nextLine();
			if(menuChoice == 1){
				menuOne();
			} else if(menuChoice == 2) {
				menuTwo();
			}
			System.out.println("Do you want to quit or perform new calculations, press Q to quit or any other key to continue");
			char quitYes = reader.next().charAt(0);
			if(quitYes == 'q' || quitYes =='Q'){
				quit = true;
			}
			
		} while(quit == false);	
		reader.close();
	}	

	public static void menuOne(){
		System.out.println("input n");
		int n = reader.nextInt();
		reader.nextLine();
		Cycles.run(n);
	}

	public static void menuTwo(){
		System.out.println("Enter the desired length of your lists:");
		int listLength = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter number of list you want to calculate probability on:");
		int numOfLists = reader.nextInt();
		Probability.run(listLength, numOfLists);

	}
}
