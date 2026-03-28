import java.util.*;

class HeapMax {
    // we go with arraylist instead of array for size flexibility
    private ArrayList<Integer> data;

    // default constructor
    public HeapMax() {
      data = new ArrayList<Integer>(0);
    }

    // DO NOT MODIFY THIS METHOD
    public ArrayList<Integer> getData() {
      return data;
    }

    // insert a new element and restore max heap property
    public void insert(int element) {
      data.add(element);
      int index = data.size()-1;
      while(index>0 && (index-1)/2>=0 && (data.get(index)>data.get((index-1)/2))){
          int temp=data.get((index-1)/2);
          data.set((index-1)/2,data.get(index));
          data.set(index,temp);
          index=(index-1)/2;
          
        }
    }

    // return max
    public int getMax() {
      // remove this line

      if(data.size()>0){
        return data.get(0);
      }
      return 0;
    }

    // remove max and restore max heap property
    public int removeMax() {
      // remove this line
      int largest=data.get(0);
      if(data.size()>0){
      int temp=data.get(data.size()-1);
      data.set(data.size()-1,data.get(0));
      data.set(0,temp);
      data.remove(data.size() - 1);
      heapify(0);
      }
      return largest;
    }



    public int heapify(int index){
      int largestChild=0;
        
        int temp=0;
      while(2*index+1<data.size()){
        int largestChildIndex=2*index+1;
        if(2*index+2<data.size()){
          if(data.get(index*2+1)>data.get(index*2+2)){
            largestChild=data.get(index*2+1);
            
          }
          else{
            largestChild=data.get(index*2+2);
            largestChildIndex++;
          }
        }
        else{
          largestChild=data.get(index*2+1);
        }
        if( data.get(index)<largestChild){
          temp = data.get(index);
          data.set(index,largestChild);
          data.set(largestChildIndex, temp);
          index=largestChildIndex;

        }
        else{
          break;
        }

      }


      return 0;
    }



    // heap builder
    public void build(int[] arr) {
      if(data.size()==0){
        for(int i =0; i<arr.length; i++){
          data.add(arr[i]);
        }
        for(int j=data.size()/2-1;j>=0;j--){
          heapify(j);
        }
      }
    }

    // print out heap as instructed in the handout
    public void display() {
      int index=0;
      while(2*index+1<=data.size()){
        for(int i =0; i<=index;i++){
          System.out.print(data.get(index+i)+" ");
        }
        System.out.print("\n");
        index=2*index+1;
      }
      
    for(int j=index;j<data.size();j++){
      System.out.print(data.get(j)+" ");
    }
    System.out.print("\n");
    //System.out.println(data);
  }
}
