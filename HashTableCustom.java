import java.util.Arrays;
import java.util.LinkedList;

public class HashTableCustom<K, V> {
    // feel free to add, update or delete any of the instance variables below
    private static final int INITIAL_CAPACITY = 10; // Starting size of the hash table
    private static final double LOAD_FACTOR_THRESHOLD = 0.7; // Load factor to trigger resizing
    private LinkedList<Entry<K, V>>[] table; // Array of LinkedLists for separate chaining
    private int size; // Number of key-value pairs in the hash table
    private String option;



    public static void main(String[] args) {
        //System.out.println("hello world");
    }
    // feel free to change the constructor below
    @SuppressWarnings("unchecked")
    public HashTableCustom() {
        // do something here
        table = (LinkedList<Entry<K, V>>[]) new LinkedList[INITIAL_CAPACITY];
        for(int i = 0; i<table.length; i++){
            table[i]=new LinkedList<>();
        }

    }

    // feel free to change the constructor below
    @SuppressWarnings("unchecked")
    public HashTableCustom(String option) {
        this.option=option;

        table = (LinkedList<Entry<K, V>>[]) new LinkedList[INITIAL_CAPACITY];
    }

    // feel free to change the inner class below
    // or if you don't want to use it, you can remove it
    // Inner class for key-value pairs
    private class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next=null;



        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        private V getValue() {
            return value;
        }
        private K getKey() {
            return key;
        }
        public void setNext(Entry<K, V> next){
            this.next=next;
        }
        public Entry<K, V> getNext(){
            return next;
        }
    }


    // Insert or update a key-value pair
    public void put(K key, V value) {
        
        resize();
        int index=Math.abs(key.hashCode()%table.length);

        
       // if(!(index)){}
       //int newIndex=0;
       while(!table[index].isEmpty()&&(!(table[index].getFirst().getKey().equals(key)))){
            index=linearProbing(index);
       }
       Entry entry= new Entry(key,value);
       table[index]=new LinkedList<Entry<K, V>>();
       table[index].add(entry);

        return;
    }
    public void putNew(K key, V value) {
        int index=Math.abs(key.hashCode()%table.length);

        
       // if(!(index)){}
       //int newIndex=0;
       while(!table[index].isEmpty()&&(!(table[index].getFirst().getKey().equals(key)))){
            index=linearProbing(index);
       }
       Entry entry= new Entry(key,value);
       table[index]=new LinkedList<Entry<K, V>>();
       table[index].add(entry);

        return;
    }
    public int linearProbing(int index){
        for(int i=index; i%table.length<table.length;i++){

            if(table[i%table.length].isEmpty()){
                return i%table.length;
            }

        }
        return 0;
    }

    // Retrieve a value by key
    public V get(K key) {
        int index=Math.abs(key.hashCode()%table.length);
        while(!table[index].isEmpty()){

            if(table[index].getFirst().getKey().equals(key)){
                return(table[index].getFirst().getValue());
            }
            index=linearProbing(index);
        }
            return null; // if key not found
    }


    // Remove a key-value pair
    public void remove(K key) {
        int index=Math.abs(key.hashCode()%table.length);
        while(!table[index].isEmpty()){
            if(table[index].getFirst().getKey().equals(key)){
                table[index]=new LinkedList<Entry<K, V>>();;

                break;
            }
            index=linearProbing(index);
        }
        return;
    }

    // Check if a key exists
    public boolean containsKey(K key) {
         int index=Math.abs(key.hashCode()%table.length);

        return (!table[index].isEmpty()); // if 
    }

    // Get the size of the hash table
    public int size() {
        return table.length;
    }

    // Resize the hash table
    private void resize() {
        float total=0;
        for(int i =0; i<table.length; i++){
            if(!table[i].isEmpty()){
                total++;
                Entry<K, V> head=table[i].getFirst();
                while(head.getNext()!=null){
                    total++;
                    head=head.getNext();
                }
            }
        }
        if(total/table.length>=LOAD_FACTOR_THRESHOLD){

            LinkedList<Entry<K, V>>[] tempTable = (LinkedList<Entry<K, V>>[]) new LinkedList[table.length];

               tempTable=Arrays.copyOf(table,table.length);
               table=(LinkedList<Entry<K, V>>[]) new LinkedList[table.length*2];
               for(int i = 0; i<table.length; i++){
                    table[i]=new LinkedList<>();
                }

            for(int i =0; i<tempTable.length;i++){
                if(!tempTable[i].isEmpty()){
                    putNew(tempTable[i].getFirst().getKey(),tempTable[i].getFirst().getValue());
                    Entry<K, V> head=tempTable[i].getFirst();
                    while(head.getNext()!=null){
                        putNew(head.getNext().getKey(),head.getNext().getValue());
                        head=head.getNext();
                    }
                }
            }
        }
        return;
    }
}