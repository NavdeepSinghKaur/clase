package example2;

// Serialization2 Example
// Source code file Employee.java
// Show how to serialize an ArrayList collection.
public class Employee extends Person {

    private static final long serialVersionUID = 2L;
    private int _id;
    protected double _salary;

    public Employee(String _name, char _gender, int _age,
                    int _id, double _salary) {

        super(_name, _gender, _age);
        this._id = _id;
        this._salary = _salary;
    }

    @Override
    public String toString() {
        return super.toString( )  + " " +
                _id + " " + _salary;
    }

    public double getCompensation( ) {
        return _salary;
    }
}