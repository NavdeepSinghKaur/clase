package example2;

// Serialization2 Example
// Source code file Person.java
// Show how to serialize an ArrayList collection.
import java.io.Serializable;
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private String _name;
    private char _gender;
    private int _age;

    public Person(String _name, char _gender, int _age) {
        this._name = _name;
        this._gender = _gender;
        this._age = _age;
    }

    @Override
    public String toString() {
        return _name + " " + _gender  + " " + _age;
    }
}