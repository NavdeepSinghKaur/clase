package example2;

// Serialization2 Example
// Source code file TestOut.java
// Show how to serialize an ArrayList collection.
import java.util.ArrayList;
import java.io.*;
public class TestOut {

    public static void main(String[] args) throws IOException {

        ArrayList<Person> col = new ArrayList<Person>( );

        // Add objects from Employee hierarchy to collection.
        col.add(new Person("Alice", 'F', 23));
        col.add(new Employee("Thomas", 'M', 34, 1234, 65000));
        col.add(new Executive(
                "Gloria", 'F', 48, 3456, 134000, 90000));

        // Serialize array list.
        ObjectOutputStream outStream = new ObjectOutputStream(
                new FileOutputStream("employees.ser"));
        outStream.writeObject(col);

        // Close outStream.
        outStream.close( );
    }
}

