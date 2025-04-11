package ciutatverda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AparcaBici {

    int nRef;
    String carrer;
    int num;
    Date dataInspeccio;
    int nElems;
    boolean senyalVertical;
    String equipament;
    String observacions;
    boolean compartitambMoto;
    boolean protegitambPilona;


    public AparcaBici(int nRef, String carrer, int num, Date dataInspeccio, int nElems, boolean senyalVertical,
                      String equipament, String observacions, boolean compartitambMoto, boolean protegitambPilona) {
        super();
        this.nRef = nRef;
        this.carrer = carrer;
        this.num = num;
        this.dataInspeccio = dataInspeccio;
        this.nElems = nElems;
        this.senyalVertical = senyalVertical;
        this.equipament = equipament;
        this.observacions = observacions;
        this.compartitambMoto = compartitambMoto;
        this.protegitambPilona = protegitambPilona;
    }

    public AparcaBici(String line)
    {
        String[] p = line.split(";");

        this.nRef = Integer.parseInt(p[0]);
        this.carrer = p[1];
        this.num = p[2].equals("") ? -1 : Integer.parseInt(p[2]);
        try {
            this.dataInspeccio = new SimpleDateFormat("dd/MM/yyyy").parse(p[3]);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.nElems = Integer.parseInt(p[4]);
        this.senyalVertical = p[5].equals("SI") ? true : false;
        this.equipament = p[6];
        this.observacions = p[7];
        this.compartitambMoto = p[8].equals("SI") ? true : false;
        this.protegitambPilona = p[9].equals("SI") ? true : false;
    }

    @Override
    public String toString() {
        return "AparcaBici [nRef=" + nRef + ", carrer=" + carrer + ", num=" + num + ", dataInspeccio=" + dataInspeccio
                + ", nElems=" + nElems + ", senyalVertical=" + senyalVertical + ", equipament=" + equipament
                + ", observacions=" + observacions + ", compartitambMoto=" + compartitambMoto + ", protegitambPilona="
                + protegitambPilona + "]";
    }

    public int getnRef() {
        return nRef;
    }

    public String getCarrer() {
        return carrer;
    }

    public int getNum() {
        return num;
    }

    public Date getDataInspeccio() {
        return dataInspeccio;
    }

    public int getnElems() {
        return nElems;
    }

    public boolean isSenyalVertical() {
        return senyalVertical;
    }

    public String getEquipament() {
        return equipament;
    }

    public String getObservacions() {
        return observacions;
    }

    public boolean isCompartitambMoto() {
        return compartitambMoto;
    }

    public boolean isProtegitambPilona() {
        return protegitambPilona;
    }




}
