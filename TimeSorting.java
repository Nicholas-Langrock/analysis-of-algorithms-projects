import java.util.*;
import java.util.Random;
import java.util.Arrays;

public class HeapMaxApp{
	public static void main(String[] args) {
		// in case if you want to test your solution

    int[][] matrix = randomMatrix(100,100);
    getKthBiggestNaive(matrix,3);
    getKthBiggest(matrix,3);

    //System.out.println(calcTime(matrix, 5,"getKthBiggestNaive"));
    //System.out.println(calcTime(matrix, 5,"getKthBiggest"));
	}

  // return a 2D array with m rows and n columns
  // the 2D array is sorted both row-wise and column-wise
  public static int[][] randomMatrix(int m, int n) {
    // placeholder
    Random rand = new Random();
    int[][] matrix = new int[m][n];
    for(int j =0;j<m;j++){
      for(int i =0;i<n;i++){
        if(j==0){
          matrix[j][i]= rand.nextInt(100000000);
        }
        else{
          matrix[j][i]= rand.nextInt(matrix[j-1][i]+1); //matrix[j-1][i]+1
        }

      }
      Arrays.sort((matrix[j]));
    }
    for(int i =0;i<m;i++){
      //System.out.println(Arrays.toString(matrix[i]));
    }
    return matrix;
  }

  // return the kth largest element from matr
  // you can assume that k is between 1 and matr.length * matr[0].length
  public static int getKthBiggestNaive(int[][] matr, int k) {
    // remove this line
    int m=matr.length;
    int n =matr[0].length;
    int arrLength=(n)*(m);
    int arrIndex=0;
    int kthLargest=0;
    int[] arr= new int[arrLength];
    for(int j =0;j<m;j++){
      for(int i =0;i<n;i++){
        
        arr[arrIndex]=matr[j][i];
        arrIndex++;
      }

    }
    insertionSort(arr);
    for(int i=0;i<k;i++){
      kthLargest=arr[arrLength-1-i];
    }
    
    //System.out.println(Arrays.toString(arr));
    //System.out.println(kthLargest);
    
    return kthLargest;
  }
  public static int[] insertionSort(int[] arr) {
    // keep this line
    for (int i=0; i<arr.length; i++){
        for (int j=i; j>0; j--){
            if((arr[j-1]>arr[j])){
                int temp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=temp;
            }
        }
    }
    return arr;
}

  // return the kth largest element from matr
  // you can assume that k is between 1 and matr.length * matr[0].length
  public static int getKthBiggest(int[][] matr, int k) {
    // remove this line
    HeapMax heap = new HeapMax();
    int m=matr.length;
    int n =matr[0].length;
    int arrLength=(n)*(m);
    int arrIndex=0;
    int kthLargest=0;
    int[] arr= new int[arrLength];
    for(int j =0;j<m;j++){
      for(int i =0;i<n;i++){
        
        arr[arrIndex]=matr[j][i];
        arrIndex++;
      }

    }

      heap.build(arr);
      //heap.display();
      for(int i=0;i<k;i++){
        kthLargest=heap.removeMax();
      }
    //System.out.println(kthLargest);
    return kthLargest;
  }

  // calculate the time it takes to find the kth largest element from matr
  // algorithName is either getKthBiggest or getKthBiggestNaive
  public static double calcTime(int[][] matr, int k, String algorithName) {
    // remove this line


		long start=System.nanoTime();
		if(algorithName.equals("getKthBiggest")){
			getKthBiggest(matr,k);
		}
		
		else if(algorithName.equals("getKthBiggestNaive")){
			getKthBiggestNaive(matr,k);
		}
		long end=(System.nanoTime()-start)/1000;
		
		return end;

  }
}
