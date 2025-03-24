package potitos2.potitos;

public class Ingredient {
    String name;
    String[] ingredients;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + this.name + '\'' +
                '}';
    }
}