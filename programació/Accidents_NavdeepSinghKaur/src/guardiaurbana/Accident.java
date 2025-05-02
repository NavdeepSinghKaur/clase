package guardiaurbana;

public class Accident {
    private String numeroExpedient;
    private int codiDistricte;
    private String nomDistricte;
    private int codiBarri;
    private String nomBarri;
    private int codiCarrer;
    private String nomCarrer;
    private String numPostal;
    private String descripcioDiaSetmana;
    private int any;
    private int mesAny;
    private String nomMes;
    private int diaMes;
    private int horaDia;
    private String descripcioCausaMediata;
    private String descripcioTorn;
    private double coordenadaX;
    private double coordenadaY;
    private double longitud;
    private double latitud;

    public Accident(String numeroExpedient, int codiDistricte, String nomDistricte, int codiBarri,
                    String nomBarri, int codiCarrer, String nomCarrer, String numPostal,
                    String descripcioDiaSetmana, int any, int mesAny, String nomMes,
                    int diaMes, int horaDia, String descripcioCausaMediata, String descripcioTorn,
                    double coordenadaX, double coordenadaY, double longitud, double latitud) {
        this.numeroExpedient = numeroExpedient;
        this.codiDistricte = codiDistricte;
        this.nomDistricte = nomDistricte;
        this.codiBarri = codiBarri;
        this.nomBarri = nomBarri;
        this.codiCarrer = codiCarrer;
        this.nomCarrer = nomCarrer;
        this.numPostal = numPostal;
        this.descripcioDiaSetmana = descripcioDiaSetmana;
        this.any = any;
        this.mesAny = mesAny;
        this.nomMes = nomMes;
        this.diaMes = diaMes;
        this.horaDia = horaDia;
        this.descripcioCausaMediata = descripcioCausaMediata;
        this.descripcioTorn = descripcioTorn;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getNumeroExpedient() {
        return numeroExpedient;
    }

    public void setNumeroExpedient(String numeroExpedient) {
        this.numeroExpedient = numeroExpedient;
    }

    public int getCodiDistricte() {
        return codiDistricte;
    }

    public void setCodiDistricte(int codiDistricte) {
        this.codiDistricte = codiDistricte;
    }

    public String getNomDistricte() {
        return nomDistricte;
    }

    public void setNomDistricte(String nomDistricte) {
        this.nomDistricte = nomDistricte;
    }

    public int getCodiBarri() {
        return codiBarri;
    }

    public void setCodiBarri(int codiBarri) {
        this.codiBarri = codiBarri;
    }

    public String getNomBarri() {
        return nomBarri;
    }

    public void setNomBarri(String nomBarri) {
        this.nomBarri = nomBarri;
    }

    public int getCodiCarrer() {
        return codiCarrer;
    }

    public void setCodiCarrer(int codiCarrer) {
        this.codiCarrer = codiCarrer;
    }

    public String getNomCarrer() {
        return nomCarrer;
    }

    public void setNomCarrer(String nomCarrer) {
        this.nomCarrer = nomCarrer;
    }

    public String getNumPostal() {
        return numPostal;
    }

    public void setNumPostal(String numPostal) {
        this.numPostal = numPostal;
    }

    public String getDescripcioDiaSetmana() {
        return descripcioDiaSetmana;
    }

    public void setDescripcioDiaSetmana(String descripcioDiaSetmana) {
        this.descripcioDiaSetmana = descripcioDiaSetmana;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public int getMesAny() {
        return mesAny;
    }

    public void setMesAny(int mesAny) {
        this.mesAny = mesAny;
    }

    public String getNomMes() {
        return nomMes;
    }

    public void setNomMes(String nomMes) {
        this.nomMes = nomMes;
    }

    public int getDiaMes() {
        return diaMes;
    }

    public void setDiaMes(int diaMes) {
        this.diaMes = diaMes;
    }

    public int getHoraDia() {
        return horaDia;
    }

    public void setHoraDia(int horaDia) {
        this.horaDia = horaDia;
    }

    public String getDescripcioCausaMediata() {
        return descripcioCausaMediata;
    }

    public void setDescripcioCausaMediata(String descripcioCausaMediata) {
        this.descripcioCausaMediata = descripcioCausaMediata;
    }

    public String getDescripcioTorn() {
        return descripcioTorn;
    }

    public void setDescripcioTorn(String descripcioTorn) {
        this.descripcioTorn = descripcioTorn;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoodenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    @Override
    public String toString() {
        return "Accident [" +
                "numeroExpedient=" + numeroExpedient +
                ", codiDistricte=" + codiDistricte +
                ", nomDistricte='" + nomDistricte +
                ", codiBarri=" + codiBarri +
                ", nomBarri='" + nomBarri +
                ", codiCarrer=" + codiCarrer +
                ", nomCarrer='" + nomCarrer +
                ", numPostal='" + numPostal +
                ", descripcioDiaSetmana='" + descripcioDiaSetmana +
                ", any=" + any +
                ", mesAny=" + mesAny +
                ", nomMes='" + nomMes +
                ", diaMes=" + diaMes +
                ", horaDia=" + horaDia +
                ", descripcioCausaMediata='" + descripcioCausaMediata +
                ", descripcioTorn='" + descripcioTorn +
                ", coordenadaX=" + coordenadaX +
                ", coodenadaY=" + coordenadaY +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                ']';
    }
}
