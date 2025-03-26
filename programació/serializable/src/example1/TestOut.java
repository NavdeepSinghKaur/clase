package example1;// Serialization1 Example
// Source code file example1.TestOut.java
// Show how to serialize a single object.

import java.io.*;
public class TestOut {

    public static void main(String[] args)
            throws FileNotFoundException, IOException {

        // Create object.
        Person p = new Person("Alice", 'F', 19);
        System.out.println(p);

        // Serialize object.
        ObjectOutputStream outStream = new ObjectOutputStream(
                new FileOutputStream("person.ser"));
        outStream.writeObject(p);

        // Close object.
        outStream.close( );
    }
}
