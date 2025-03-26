package example2;

// Serialization2 Example
// Source code file Executive.java
// Show how to serialize an ArrayList collection.
public class Executive extends Employee {

    private static final long serialVersionUID = 3L;
    private double _bonus;

    public Executive(String _name, char _gender, int _age,
                     int _id, double _salary, double _bonus) {
        super(_name, _gender, _age, _id, _salary);
        this._bonus = _bonus;
    }

    @Override
    public String toString( ) {
        return super.toString( ) + " " + _bonus;
    }

    @Override
    public double getCompensation( ) {
        return _salary + _bonus;
    }
}
