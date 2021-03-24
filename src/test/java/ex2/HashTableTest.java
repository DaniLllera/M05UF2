package ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashTableTest {

    @Test
    void put() {
        HashTable hashTable = new HashTable();

        hashTable.put("1","1");
        System.out.println(hashTable.toString());


        hashTable.put("2","2");
        System.out.println(hashTable.toString());

        hashTable.put("13","Hola");
        System.out.println(hashTable.toString());
        System.out.println("Numero que genera el has code:" + " " +"13".hashCode());

        Assertions.assertEquals("13".hashCode() % hashTable.size(), 2);

        hashTable.put("24","QUE");
        System.out.println(hashTable.toString());
        System.out.println("Numero que genera el has code:" + " " +"24".hashCode());
        Assertions.assertEquals("25".hashCode() % hashTable.size(), 2);


    }
}