package inscaparrella.model;

public class Owner {
    private String name;
    private String surname1;
    private String surname2;
    private String id;

    public Owner(String name, String surname1, String surname2, String id) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname1() {
        return this.surname1;
    }

    public String getSurname2() {
        return this.surname2;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        //return this.id.hashCode();
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean areEquals = false;
        if(obj instanceof Owner) {
            Owner owner = (Owner) obj;
            //areEquals = this.id.equals(owner.id);
            areEquals = (this.name.equals(owner.name) && this.surname1.equals(owner.surname1)
                    && this.surname2.equals(owner.surname2) && this.id.equals(owner.id));
        }
        return areEquals;
    }

    @Override
    public String toString() {
        String str = this.name + " " + this.surname1 + " ";
        if(!this.surname2.isEmpty()) str += this.surname2 + " ";
        str += "(" + this.id + ")";

        return str;
    }
}
