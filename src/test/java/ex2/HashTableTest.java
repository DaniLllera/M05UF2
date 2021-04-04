package ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class HashTableTest {

    @org.junit.jupiter.api.Test
    void put() {
        System.out.println("PUT");
        HashTable hashTable = new HashTable();

        hashTable.put("1","1");
        System.out.println("TEST1 Inserir un element que no col·lisiona dins una taula vuida.\n");
        System.out.println(hashTable.toString());
        System.out.println(" ");
        Assertions.assertEquals("\n bucket[1] = [1, 1]", hashTable.toString());

        System.out.println("TEST2 Inserir un element que no col·lisiona dins una taula no vuida.\n");
        hashTable.put("2","2");
        System.out.println(hashTable.toString());
        System.out.println(" ");
        Assertions.assertEquals("\n bucket[1] = [1, 1]\n bucket[2] = [2, 2]", hashTable.toString());


        System.out.println("TEST 3 Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 2a posició dins el mateix bucket.\n");

        hashTable.put("13","3");
        System.out.println(hashTable.toString());
        System.out.println(" ");
        Assertions.assertEquals("\n bucket[1] = [1, 1]\n bucket[2] = [2, 2] -> [13, 3]", hashTable.toString());

        System.out.println("TEST 4 Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 3a posició dins el mateix bucket.\n");

        hashTable.put("24","4");
        System.out.println(hashTable.toString());
        System.out.println(" ");
        Assertions.assertEquals("\n bucket[1] = [1, 1]\n bucket[2] = [2, 2] -> [13, 3] -> [24, 4]", hashTable.toString());

        System.out.println("TEST 5 Inserir un elements que ja existeix (update) sobre un element que no col·lisiona dins una taula vuida.\n");
        hashTable.put("1", "18");
        System.out.println(hashTable.toString());
        System.out.println(" ");

        Assertions.assertEquals("\n bucket[1] = [1, 18]\n bucket[2] = [2, 2] -> [13, 3] -> [24, 4]", hashTable.toString());

    }

    @Test
    void get(){
        System.out.println("GET");

        HashTable hashTable = new HashTable();
        System.out.println("TEST 1 Obtenir un element que no col·lisiona dins una taula vuida.\n");
        hashTable.put("1","30");
        hashTable.get("1");
        Assertions.assertEquals("30",hashTable.get("1"));
        System.out.println(hashTable.toString());
        System.out.println(hashTable.get("1"));
        System.out.println(" ");

        System.out.println("TEST 2 Obtenir un element que col·lisiona dins una taula (1a posició dins el mateix bucket).\n");
        hashTable.put("12", "90");
        hashTable.get("1");
        Assertions.assertEquals("30",hashTable.get("1"));
        System.out.println(hashTable.toString());
        System.out.println(hashTable.get("1"));
        System.out.println(" ");

        System.out.println("TEST 3 Obtenir un element que col·lisiona dins una taula (2a posició dins el mateix bucket).\n");
        hashTable.get("12");
        Assertions.assertEquals("90",hashTable.get("12"));
        System.out.println(hashTable.toString());
        System.out.println(hashTable.get("12"));
        System.out.println(" ");

        System.out.println("TEST 4 Obtenir un element que col·lisiona dins una taula (3a posició dins el mateix bucket).\n");
        hashTable.put("23","80");
        hashTable.get("23");
        Assertions.assertEquals("80",hashTable.get("23"));
        System.out.println(hashTable.toString());
        System.out.println(hashTable.get("23"));
        System.out.println(" ");

        System.out.println("TEST 5 Obtenir un elements que no existeix perquè la seva posició està buida.\n");
        hashTable.get("7");
        Assertions.assertNull(hashTable.get("7"));
        System.out.println(hashTable.toString());
        System.out.println(hashTable.get("7"));
        System.out.println(" ");

        System.out.println("TEST 6 Obtenir un elements que no existeix, tot i que la seva posició està ocupada per un altre que no col·lisiona.\n");
        hashTable.put("0", "0");
        hashTable.get("22");
        Assertions.assertNull(hashTable.get("22"));
        System.out.println(hashTable.toString());
        System.out.println(hashTable.get("22"));
        System.out.println(" ");

        System.out.println("TEST 7 Obtenir un elements que no existeix, tot i que la seva posició està ocupada per 3 elements col·lisionats.\n");
        hashTable.get("34");
        Assertions.assertNull(hashTable.get("34"));
        System.out.println(hashTable.toString());
        System.out.println(hashTable.get("34"));
    }

    @Test
    void drop(){
        System.out.println("DROP");

        HashTable hashTable = new HashTable();

        hashTable.put("1","1");
        hashTable.put("2","2");

        hashTable.put("13","40");
        hashTable.put("24","25");
        System.out.println(hashTable.toString());

        System.out.println("TEST 1 Esborrar un element que no col·lisiona dins una taula.\n");
        hashTable.drop("1");
        Assertions.assertEquals("\n bucket[2] = [2, 2] -> [13, 40] -> [24, 25]", hashTable.toString());
        System.out.println(hashTable.toString());

        System.out.println("TEST 2 Esborrar un element que si col·lisiona dins una taula (2a posició dins el mateix bucket).\n");

        hashTable.drop("13");
        Assertions.assertEquals("\n bucket[2] = [2, 2] -> [24, 25]", hashTable.toString());
        System.out.println(hashTable.toString());

        System.out.println("TEST 3 Esborrar un element que si col·lisiona dins una taula (3a posició dins el mateix bucket).\n");
        hashTable.put("13","40");
        System.out.println(hashTable.toString());
        hashTable.drop("13");
        System.out.println(hashTable.toString());

        System.out.println("TEST 4 Eliminar un elements que no existeix perquè la seva posició està buida.\n");
        hashTable.drop("7");
        Assertions.assertEquals("\n bucket[2] = [2, 2] -> [24, 25]", hashTable.toString());

    }
    @Test
    void count_sizeput(){
        System.out.println("PUT");
        HashTable hashTable = new HashTable();

        hashTable.put("1","1");
        System.out.println("TEST1 Inserir un element que no col·lisiona dins una taula vuida.\n");
        System.out.println(hashTable.toString());
        System.out.println(" ");
        Assertions.assertEquals("\n bucket[1] = [1, 1]", hashTable.toString());
        Assertions.assertEquals(1, hashTable.count());
        System.out.println(hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
        System.out.println(hashTable.size());

        System.out.println("TEST2 Inserir un element que no col·lisiona dins una taula no vuida.\n");
        hashTable.put("2","2");
        System.out.println(hashTable.toString());
        System.out.println(" ");
        Assertions.assertEquals("\n bucket[1] = [1, 1]\n bucket[2] = [2, 2]", hashTable.toString());
        Assertions.assertEquals(2, hashTable.count());
        System.out.println(hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
        System.out.println(hashTable.size());

        System.out.println("TEST 3 Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 2a posició dins el mateix bucket.\n");

        hashTable.put("13","3");
        System.out.println(hashTable.toString());
        System.out.println(" ");
        Assertions.assertEquals("\n bucket[1] = [1, 1]\n bucket[2] = [2, 2] -> [13, 3]", hashTable.toString());
        Assertions.assertEquals(3, hashTable.count());
        System.out.println(hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
        System.out.println(hashTable.size());

        System.out.println("TEST 4 Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 3a posició dins el mateix bucket.\n");

        hashTable.put("24","4");
        System.out.println(hashTable.toString());
        System.out.println(" ");
        Assertions.assertEquals("\n bucket[1] = [1, 1]\n bucket[2] = [2, 2] -> [13, 3] -> [24, 4]", hashTable.toString());
        Assertions.assertEquals(4, hashTable.count());
        System.out.println(hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
        System.out.println(hashTable.size());

        System.out.println("TEST 5 Inserir un elements que ja existeix (update) sobre un element que no col·lisiona dins una taula vuida.\n");
        hashTable.put("1", "18");
        System.out.println(hashTable.toString());
        System.out.println(" ");

        Assertions.assertEquals("\n bucket[1] = [1, 18]\n bucket[2] = [2, 2] -> [13, 3] -> [24, 4]", hashTable.toString());
        Assertions.assertEquals(4, hashTable.count());
        System.out.println(hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
        System.out.println(hashTable.size());
    }

    @Test
    void count_sizedrop(){
        System.out.println("DROP");

        HashTable hashTable = new HashTable();

        hashTable.put("1","1");
        hashTable.put("2","2");

        hashTable.put("13","40");
        hashTable.put("24","25");
        System.out.println(hashTable.toString());

        System.out.println("TEST 1 Esborrar un element que no col·lisiona dins una taula.\n");
        hashTable.drop("1");
        Assertions.assertEquals("\n bucket[2] = [2, 2] -> [13, 40] -> [24, 25]", hashTable.toString());
        System.out.println(hashTable.toString());
        Assertions.assertEquals(3, hashTable.count());
        System.out.println(hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
        System.out.println(hashTable.size());

        System.out.println("TEST 2 Esborrar un element que si col·lisiona dins una taula (2a posició dins el mateix bucket).\n");

        hashTable.drop("13");
        Assertions.assertEquals("\n bucket[2] = [2, 2] -> [24, 25]", hashTable.toString());
        System.out.println(hashTable.toString());
        Assertions.assertEquals(2, hashTable.count());
        System.out.println(hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
        System.out.println(hashTable.size());

        System.out.println("TEST 3 Esborrar un element que si col·lisiona dins una taula (3a posició dins el mateix bucket).\n");
        hashTable.put("13","40");
        System.out.println(hashTable.toString());
        hashTable.drop("13");
        System.out.println(hashTable.toString());
        Assertions.assertEquals(2, hashTable.count());
        System.out.println(hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
        System.out.println(hashTable.size());

        System.out.println("TEST 4 Eliminar un elements que no existeix perquè la seva posició està buida.\n");
        hashTable.drop("7");
        Assertions.assertEquals("\n bucket[2] = [2, 2] -> [24, 25]", hashTable.toString());

        Assertions.assertEquals(2, hashTable.count());
        System.out.println(hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
        System.out.println(hashTable.size());
    }
}