public class ComputerGraphicsExpert extends ComputerScientist {
    private String gameEngine;
    private int platform; // 0 - None (Default) - 1 Linux - 2 Windwos - 3 Linux + Windows
    private boolean bUsesCuda;

    public ComputerGraphicsExpert() {
        super.setNom("");
        super.setCognoms("");
        super.setEdat(0);
        super.setTitol("");
        super.setAnyGraduacio(0);
        super.setExperienciaLaboral(0);
        super.setSou(0);
        this.gameEngine = "";
        this.platform = 0;
        this.bUsesCuda = false;
    }

    /**
     * @param name
     * @param lastName
     * @param edat
     * @param title
     * @param graduationYear
     * @param experience
     * @param salary
     * @param gameEngine
     * @param platform Values: 0 None - 1 Linux - 2 Windows - 3 Linux + Windows
     * @param usesCuda
     */
    public ComputerGraphicsExpert(String name, String lastName, int edat, String title, int graduationYear, int experience, double salary, String gameEngine, int platform, boolean usesCuda) {
        super.setNom(name);
        super.setCognoms(lastName);
        super.setEdat(edat);
        super.setTitol(title);
        super.setAnyGraduacio(graduationYear);
        super.setExperienciaLaboral(experience);
        super.setSou(salary);
        this.gameEngine = gameEngine;
        this.platform = platform;
        this.bUsesCuda = usesCuda;
    }

    public ComputerGraphicsExpert(ComputerGraphicsExpert computerGraphicsExpert) {
        super.setNom(computerGraphicsExpert.getNom());
        super.setCognoms(computerGraphicsExpert.getCognoms());
        super.setEdat(computerGraphicsExpert.getEdat());
        super.setTitol(computerGraphicsExpert.getTitol());
        super.setAnyGraduacio(computerGraphicsExpert.getAnyGraduacio());
        super.setExperienciaLaboral(computerGraphicsExpert.getExperienciaLaboral());
        super.setSou(computerGraphicsExpert.getSou());
        this.gameEngine = computerGraphicsExpert.getGameEngine();
        this.platform = computerGraphicsExpert.getPlatform();
        this.bUsesCuda = computerGraphicsExpert.isbUsesCuda();
    }

    public String getGameEngine() {
        return gameEngine;
    }

    public void setGameEngine(String gameEngine) {
        this.gameEngine = gameEngine;
    }

    public int getPlatform() {
        return this.platform;
    }
    public String getPlatformText() {
        String returnPlatform;
        if (this.platform == 1) {
            returnPlatform = "Linux";
        } else if (this.platform == 2) {
            returnPlatform = "Windows";
        } else if (this.platform == 3) {
            returnPlatform = "Linux + Windows";
        } else {
            returnPlatform = "N/A";
        }

        return returnPlatform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public boolean isbUsesCuda() {
        return bUsesCuda;
    }

    public void setbUsesCuda(boolean bUsesCuda) {
        this.bUsesCuda = bUsesCuda;
    }

    @Override
    public String onGoingWork() {
        String onGoingWorkReturnText;
        if (this.isbUsesCuda()) {
            onGoingWorkReturnText = "Estic creant un joc que utilitza el motor " + this.getGameEngine() + ". Un cop acabat, estarà disponible per a les plataformes " + this.getPlatformText() + ". A més a més, està optimitzat utilitzant la tecnologia CUDA.";
        } else {
            onGoingWorkReturnText = "Estic creant un joc que utilitza el motor " + this.getGameEngine() + ". Un cop acabat estarà disponible per a les plataformes " + this.getPlatform() + ".";
        }
        return onGoingWorkReturnText;
    }
}
