package exam.model;

import java.util.Objects;

public class MarvelFilm {
    private int id;
    private String title;
    private int phase;
    private int releaseDate;

    public MarvelFilm(int id, String title, int phase, int releaseDate) {
        this.id = id;
        this.title = title;
        this.phase = phase;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPhase() {
        return this.phase;
    }

    public int getReleaseDate() {
        return this.releaseDate;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        boolean areEquals = false;
        if(obj instanceof MarvelFilm) {
            MarvelFilm f = (MarvelFilm) obj;
            areEquals = this.id == f.id;
        }
        return areEquals;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", phase=" + phase +
                ", releaseDate=" + releaseDate +
                '}';
    }
}