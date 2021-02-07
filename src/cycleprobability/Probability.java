package cycleprobability;
import java.util.ArrayList;
import java.util.Collections;
import cycles.Cycles;
/**
 * Udregner sandsynlighed for antal kredse i en liste af længde n
 * Laver grafisk repræsentation af kredsenes normalfordeling
 * */

public class Probability{
	public static void run(int listLength, int numOfLists){
		listLength = listLength+1;//der skal bruges en liste med der reelle antal, jf. nulindeksering
		//først laves numOfLists antal lister af listLength og antallet af kredse findes, 
		//numOfCycles tildeles antal kredse pr. liste
		int[] numOfCycles = new int[numOfLists];
		for(int i = 0; i < numOfLists; i++){
			numOfCycles[i] = Cycles.cycleCount(listLength);
		}
		//Der laves en ordnet liste af længde listLength
		int[] orderedList = new int[listLength];
		for(int j = 0; j < listLength; j++){
			orderedList[j] = j; 
		}
		//der laves en liste der indeholder antallet af kredse 
		int[] countList = new int[listLength];
		for(int k = 0; k < orderedList.length; k++){ //loop over ordnet liste	
			for(int l = 0; l < numOfLists; l++){ //loop over antal kredse, numOfCylces.length = numOfLists
				if(numOfCycles[l] == k){ //hvis kredse i numOfCycles lige med ydre iterator, tæl en kreds
					countList[k] = countList[k] + 1;
				}
			}
		}
		// "grafisk repræsentation" af fordelingen af kredse
		for(int m = 0; m < countList.length; m++){
			System.out.print(m+": ");
			int temp = 0;
			for(int n = 0; n < countList[m]; n++){
				if(numOfLists < 500){
					System.out.print('*');
				}
				temp = temp + 1;
			}
			double probability = (double)temp/numOfLists*100;
			System.out.println( String.format("Occurences: "+temp+" "+"Percentage: "+"%.2f", probability)+"%");
		}
		
	}
}
