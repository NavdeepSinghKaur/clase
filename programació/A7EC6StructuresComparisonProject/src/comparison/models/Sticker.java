package comparison.models;

import java.util.Objects;

public class Sticker implements Comparable<Sticker>{
    private String name;
    private int year;

    public Sticker() {
        name = "";
        year = 0;
    }

    public Sticker(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public Sticker(Sticker st) {
        this.name = st.name;
        this.year = st.year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Sticker sticker)) return false;
        return year == sticker.year && Objects.equals(name, sticker.name);
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(Sticker st) {
        int comparison = this.name.compareTo(st.name);
        if (comparison == 0) {
            comparison = Integer.compare(this.year, st.year);
        }

        return comparison;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }

}
