public class Programmer extends ComputerScientist{
    private String favoriteLang;
    private boolean bProjectManager;
    private String projectName;

    public Programmer() {
        super.setNom("");
        super.setCognoms("");
        super.setEdat(0);
        super.setTitol("");
        super.setAnyGraduacio(0);
        super.setExperienciaLaboral(0);
        super.setSou(0);
        this.favoriteLang = "";
        this.bProjectManager = false;
        this.projectName = "";
    }

    public Programmer(String nom, String cognoms, int edat, String titol, int anyGraduacio, int experienciaLaboral, double sou, String favoriteLang, boolean bProjectManager, String projectName) {
        super.setNom(nom);
        super.setCognoms(cognoms);
        super.setEdat(edat);
        super.setTitol(titol);
        super.setAnyGraduacio(anyGraduacio);
        super.setExperienciaLaboral(experienciaLaboral);
        super.setSou(sou);
        this.favoriteLang = favoriteLang;
        this.bProjectManager = bProjectManager;
        this.projectName = projectName;
    }

    public Programmer(Programmer programmer) {
        super.setNom(programmer.getNom());
        super.setCognoms(programmer.getCognoms());
        super.setEdat(programmer.getEdat());
        super.setTitol(programmer.getTitol());
        super.setAnyGraduacio(programmer.getAnyGraduacio());
        super.setExperienciaLaboral(programmer.getExperienciaLaboral());
        super.setSou(programmer.getSou());
        this.favoriteLang = programmer.getFavoriteLang();
        this.bProjectManager = programmer.isbProjectManager();
        this.projectName = programmer.getProjectName();
    }

    public String getFavoriteLang() {
        return favoriteLang;
    }

    public void setFavoriteLang(String favoriteLang) {
        this.favoriteLang = favoriteLang;
    }

    public boolean isbProjectManager() {
        return bProjectManager;
    }

    public void setbProjectManager(boolean bProjectManager) {
        this.bProjectManager = bProjectManager;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String onGoingWork(){
        String onGoingWorkReturnText;
        if (this.isbProjectManager()) {
            onGoingWorkReturnText = "Sóc el ProjectManager del projecte " + this.getProjectName() + " que està implementat utilitzant el llenguatge " + this.getFavoriteLang();
        } else {
            onGoingWorkReturnText = "Estic treballant en el projecte " + this.getProjectName() + " utilitzant el llenguatge de programació " + this.getFavoriteLang();
        }
        return onGoingWorkReturnText;
    }
}
