package cycles;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Programmet beder brugeren om et tal n
 * Ud fra dette tal genereres en list med n elementer, fra 0 til n-1
 * Elementerne i listen blandes tilfældigt
 * Herefter tæller programmet antallet af kredse i listen.
 * */

public class Cycles{
	private static boolean[] checked;
	private static ArrayList<Integer> list;
	
	/**run()
	 * Tager et tal n, opretter en list af længde n
	 * Fylder listen med tal fra 0 til n-1 og blander disse i tilfældig rækkefølge
	 * Kalder Cycles() i et loop og tæller antallet af kredse
	 **/

    	public static void run(int n){
		list  = new ArrayList<Integer>();
		checked = new boolean[n];
		int i = 0;
		while(i<n){
			list.add(i, i);
			i++;
		}	
		Collections.shuffle(list);
		int j=0;
		while(j<n){
			System.out.print(" "+list.get(j)+" ");
			j++;
		}	
		System.out.println(" ");
		int cCount = 0;
		for(int k = 0; k<n; k++){
			if(checked[k]==false){
				cCount = cCount + cycles(k, list.get(k));
			}
		}
		System.out.println(cCount);
		}

	/** cycleCount()
	 * Samme metode som ovenfor, men integer
	 * returnere antal kredse i en given liste
	 **/

	public static int cycleCount(int n){
		list  = new ArrayList<Integer>();
		checked = new boolean[n];
		int i = 0;
		while(i<n){
			list.add(i, i);
			i++;
		}	
		Collections.shuffle(list);
		int j=0;	
		int cCount = 0;
		for(int k = 0; k<n; k++){
			if(checked[k]==false){
				cCount = cCount + cycles(k, list.get(k));
			}
		}
		return cCount;
	}
	
	/** cycles()
	 *  Tjekker sammen med et for-loop i de ovenstående metoder antal kredse i list
	 **/

	public static int cycles(int index, int value){
		int c=0;
		if(checked[index] == false){
			if(index==value){ //check om værdi der står på dette indeks svarer til index, i så fald er det en kreds
				checked[index] = true; //marker at vi har været der
				c = 1; //returner 1 fordi der er fundet 1 kreds
			}else{ //marker indeks som checked og lav rekusivt kald med dette indeks' værdi til index hvor hvor værdien hører til med værdien der står på det andet indeks
				checked[index] = true; //som ovenfor
				c = cycles(value, list.get(value)); // det rekursive kald
			}
		} else { //dette fanger når en kreds slutter, da checked også tjekkes i for-loopet i main
			c = 1;
		}
		return c;
	}
}
