package ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashTableTest {

    @org.junit.jupiter.api.Test
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
        Assertions.assertEquals("24".hashCode() % hashTable.size(), 2);
    }

    @Test
    void get(){
        HashTable hashTable = new HashTable();

        hashTable.put("1","Hola");
        hashTable.get("1");
        Assertions.assertEquals("Hola",hashTable.get("1"));
        System.out.println(hashTable.toString());

        hashTable.put("12", "Adios");
        hashTable.get("1");

        Assertions.assertEquals("Hola",hashTable.get("1"));
        System.out.println(hashTable.toString());
        System.out.println(hashTable.get("1"));


        hashTable.get("12");
        Assertions.assertEquals("Adios",hashTable.get("12"));
        System.out.println(hashTable.toString());
        System.out.println(hashTable.get("12"));


        hashTable.put("23","Hey!");
        hashTable.get("23");
        Assertions.assertEquals("Hey!",hashTable.get("23"));
        System.out.println(hashTable.toString());
        System.out.println(hashTable.get("23"));

        hashTable.get("7");
        Assertions.assertNull(hashTable.get("7"));
        System.out.println(hashTable.toString());
        System.out.println(hashTable.get("7"));
    }
    @Test
    void drop(){

        HashTable hashTable = new HashTable();

        hashTable.put("1","1");
        hashTable.put("2","2");

        hashTable.put("13","Hola");
        hashTable.put("24","Hola");
        System.out.println(hashTable.toString());

        hashTable.drop("1");
        System.out.println(hashTable.toString());


        hashTable.drop("13");
        System.out.println(hashTable.toString());

        hashTable.drop("24");
        System.out.println(hashTable.toString());

        hashTable.drop("7");
        System.out.println(hashTable.toString());

    }
}