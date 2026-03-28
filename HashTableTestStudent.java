public class HashTableTestStudent {
    public static void main(String[] args){
        HashTableCustom hashTable=new HashTableCustom();

        hashTable.put(90,1444);
         System.out.println(hashTable.get(90));
        hashTable.put(90,144);
        System.out.println(hashTable.get(90));
        System.out.println(hashTable.get(90));
        hashTable.remove(90);
        System.out.println(hashTable.get(90));

    
    }
}
