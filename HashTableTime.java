import java.util.*;
import java.util.Random;
import java.util.Arrays;

public class HashTableTime {
    private static HashTableCustom hashTable = new HashTableCustom();
    public static void main(String[] args) {

        for(int i=100; i<=100000;i+=100){
            hashTable = new HashTableCustom();
            long pullStart=System.nanoTime();
            calcPullTime(i);
           long pullEnd=(System.nanoTime()-pullStart)/1000;
            
           long searchStart=System.nanoTime();
           calcSearchTime(i);
           long searchEnd=(System.nanoTime()-searchStart)/1000;

           long removeStart=System.nanoTime();
           calcSearchTime(i);
           long removeEnd=(System.nanoTime()-removeStart)/1000;
           System.out.println(i+","+pullEnd+","+searchEnd+","+removeEnd);



		}

        }
	

    public static void calcPullTime(int size) {

		
        Random rand = new Random();
         
		for(int i=0; i<=size;i++){
            
            int randKey = rand.nextInt(5000);
            int randValue = rand.nextInt(5000);
            hashTable.put(randKey,randValue);
        }
    }
    public static void calcSearchTime(int size) {

		
        Random rand = new Random();
         
		for(int i=0; i<=size;i++){
            
            int randKey = rand.nextInt(5000);
            int randValue = rand.nextInt(5000);
            hashTable.get(randKey);
        }
    }
    public static void calcRemoveTime(int size) {
        

		
        Random rand = new Random();
         
		for(int i=0; i<=size;i++){
            
            int randKey = rand.nextInt(5000);
            int randValue = rand.nextInt(5000);
            hashTable.remove(randKey);
        }
    }
}