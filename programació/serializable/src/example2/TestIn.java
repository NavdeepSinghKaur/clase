package example2;

// Serialization2 Example
// Source code file TestIn.java
// Show how to serialize an ArrayList collection.
import java.util.ArrayList;
import java.io.*;
public class TestIn {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        // Deserialize array list.
        ObjectInputStream outStream = new ObjectInputStream(
                new FileInputStream("employees.ser"));
        @SuppressWarnings("unchecked")
        ArrayList<Person> col =
                (ArrayList<Person>) outStream.readObject( );

        // Print objects in collection.
        for(Person p : col) {
            System.out.println(p);
        }

        // Close outStream.
        outStream.close( );
    }
}