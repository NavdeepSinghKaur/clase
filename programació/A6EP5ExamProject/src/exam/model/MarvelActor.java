package exam.model;

import java.util.Objects;

public class MarvelActor {
    private int id;
    private String name;
    private int age;
    private String country;
    private String role;

    public MarvelActor(int id, String name, int age, String country, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getCountry() {
        return this.country;
    }

    public String getRole() {
        return this.role;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        boolean areEquals = false;
        if(obj instanceof MarvelActor) {
            MarvelActor a = (MarvelActor) obj;
            areEquals = this.id == a.id;
        }
        return areEquals;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}