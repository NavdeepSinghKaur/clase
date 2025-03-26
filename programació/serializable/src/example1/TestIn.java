package example1;// Serialization1 Example
// Source code file example1.TestIn.java
// Show how to deserialize a single object.

import java.io.*;
public class TestIn {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        // Declare inStream object.
        ObjectInputStream inStream = new ObjectInputStream(
                new FileInputStream("person.ser"));

        // Deserialize example1.Person object.
        Person p = (Person) inStream.readObject( );

        // Print example1.Person object.
        System.out.println(p);

        // Close inStream object.
        inStream.close( );
    }
}