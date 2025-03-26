package example1;// Serialization1 Example
// Source code file example1.Person.java
// Show how to serialize a single object.
import java.io.Serializable;
public class Person implements Serializable {

    private static final long serialVersionUID = -1039792104475340045L;
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
