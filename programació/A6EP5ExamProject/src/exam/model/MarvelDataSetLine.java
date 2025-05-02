package exam.model;

public class MarvelDataSetLine {
    private int filmID;
    private String filmTitle;
    private int filmPhase;
    private int filmReleaseDate;

    private int actorID;
    private String actorName;
    private int actorAge;
    private String actorCountry;
    private String actorRole;

    public MarvelDataSetLine(int filmID, String filmTitle, int filmPhase, int filmReleaseDate,
                             int actorID, String actorName, int actorAge, String actorCountry, String actorRole) {
        this.filmID = filmID;
        this.filmTitle = filmTitle;
        this.filmPhase = filmPhase;
        this.filmReleaseDate = filmReleaseDate;
        this.actorID = actorID;
        this.actorName = actorName;
        this.actorAge = actorAge;
        this.actorCountry = actorCountry;
        this.actorRole = actorRole;
    }

    public int getFilmID() {
        return this.filmID;
    }

    public String getFilmTitle() {
        return this.filmTitle;
    }

    public int getFilmPhase() {
        return this.filmPhase;
    }

    public int getFilmReleaseDate() {
        return this.filmReleaseDate;
    }

    public int getActorID() {
        return this.actorID;
    }

    public String getActorName() {
        return this.actorName;
    }

    public int getActorAge() {
        return this.actorAge;
    }

    public String getActorCountry() {
        return this.actorCountry;
    }

    public String getActorRole() {
        return this.actorRole;
    }

    public MarvelActor getActor() {
        return new MarvelActor(this.actorID, this.actorName, this.actorAge, this.actorCountry, this.actorRole);
    }

    public MarvelFilm getFilm() {
        return new MarvelFilm(this.filmID, this.filmTitle, this.filmPhase, this.filmReleaseDate);
    }

    @Override
    public String toString() {
        return "MarvelDataSetLine{" +
                "filmID=" + filmID +
                ", filmTitle='" + filmTitle + '\'' +
                ", filmPhase=" + filmPhase +
                ", filmReleaseDate=" + filmReleaseDate +
                ", actorID=" + actorID +
                ", actorName='" + actorName + '\'' +
                ", actorAge=" + actorAge +
                ", actorCountry='" + actorCountry + '\'' +
                ", actorRole='" + actorRole + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("EQUALS MDSL");
        boolean areEquals = false;
        if(o instanceof MarvelDataSetLine) {
            MarvelDataSetLine f = (MarvelDataSetLine) o;
            areEquals = this.filmID == f.filmID;
        }
        return areEquals;
    }
}