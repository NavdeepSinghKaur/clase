package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.GodAction;
import main.java.inscaparrella.utils.HeroAction;
import main.java.inscaparrella.utils.MythologicalCharacterType;
import main.java.inscaparrella.utils.MythologyOrigin;

import java.util.Random;

public class Hero extends MythologicalCharacter {
    private String favourableGodName;
    private String unFavourableGodName;
    private HeroAction action; // actuacio

    public Hero() {
        super();
        super.setType(MythologicalCharacterType.HERO);
        this.favourableGodName = "";
        this.unFavourableGodName = "";
        this.action = HeroAction.NONE;
    }

    public Hero(String name, int genere, MythologyOrigin origin) {
        super(name, MythologicalCharacterType.HERO, genere, origin);
        this.action = HeroAction.NONE;
    }

    public Hero(Hero hero) {
        super(hero);
        this.favourableGodName = hero.getFavourableGodName();
        this.unFavourableGodName = hero.getUnFavourableGodName();
        this.action = hero.action;
    }

    public String getFavourableGodName() {
        return favourableGodName;
    }

    public void setFavourableGodName(String favourableGodName) {
        this.favourableGodName = favourableGodName;
    }

    public String getUnFavourableGodName() {
        return unFavourableGodName;
    }

    public void setUnFavourableGodName(String unFavourableGodName) {
        this.unFavourableGodName = unFavourableGodName;
    }

    @Override
    public void invokeAction() {
        Random random = new Random();

        int actionThatGets = random.nextInt(0, 5);

        switch (actionThatGets) {
            case 0:
                this.action = HeroAction.NONE;
                break;
            case 1:
                this.action = HeroAction.GO_WAR;
                break;
            case 2:
                this.action = HeroAction.KILL_MONSTER;
                break;
            case 3:
                this.action = HeroAction.GO_EXPEDITION;
                break;
            case 4:
                this.action = HeroAction.SAVE_LOVED;
                break;
        }
    }

    @Override
    public String toString() {
        String textToReturn = super.toString();
        textToReturn += "\t" + "Deïtat favorable: " + favourableGodName + "\n";
        textToReturn += "\t" + "Deïtat desfavorable: " + unFavourableGodName + "\n";
        String heroType = "";
        if (super.getGenere() == 0) {
            heroType = "L'heroïna";
        } else if (super.getGenere() == 1) {
            heroType = "L'heroi";
        }
        if (this.action == HeroAction.NONE) {
            textToReturn += "\t" + heroType +" encara no ha estat invocat";
        } else if (this.action == HeroAction.GO_WAR) {
            textToReturn += "\t" + heroType + " ha anat a la guerra a favor de qui l'ha invocat";
        } else if (this.action == HeroAction.KILL_MONSTER) {
            textToReturn += "\t" + heroType + " ha matat a un monstre";
        } else if (this.action == HeroAction.GO_EXPEDITION) {
            textToReturn += "\t" + heroType + " ha marxat d'expedició";
        } else if (this.action == HeroAction.SAVE_LOVED) {
            textToReturn += "\t" + heroType + " ha salvat un ésser estimat de qui l'ha invocat";
        }

        return textToReturn;
    }
}
