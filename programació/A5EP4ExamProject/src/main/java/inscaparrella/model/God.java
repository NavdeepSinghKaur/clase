package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.GodAction;
import main.java.inscaparrella.utils.HeroAction;
import main.java.inscaparrella.utils.MythologicalCharacterType;
import main.java.inscaparrella.utils.MythologyOrigin;

import java.util.Random;

public class God extends MythologicalCharacter {
    private String sacredDomain; // actuacio
    private GodAction action; // accio

    public God() {
        super();
        this.sacredDomain = "";
        super.setType(MythologicalCharacterType.GOD);
        this.action = GodAction.NONE;
    }

    public God(String name, int genere, MythologyOrigin origin, String sacredDomain) {
        super(name, MythologicalCharacterType.GOD, genere, origin);
        this.sacredDomain = sacredDomain;
        this.action = GodAction.NONE;
    }

    public God(God god) {
        super(god);
        this.sacredDomain = god.getSacredDomain();
        this.action = god.action;
    }

    public String getSacredDomain() {
        return sacredDomain;
    }

    public void setSacredDomain(String sacredDomain) {
        this.sacredDomain = sacredDomain;
    }

    @Override
    public void invokeAction() {
        Random random = new Random();

        int actionThatGets = random.nextInt(0, 5);

        switch (actionThatGets) {
            case 0:
                this.action = GodAction.NONE;
                break;
            case 1:
                this.action = GodAction.ENDOW_INTELLIGENCE;
                break;
            case 2:
                this.action = GodAction.ENDOW_BEAUTY;
                break;
            case 3:
                this.action = GodAction.ENDOW_POWER;
                break;
            case 4:
                this.action = GodAction.ENDOW_STRENGTH;
                break;
        }
    }

    @Override
    public String toString() {
        String textToReturn = super.toString();
        String godType = "";
        if (super.getGenere() == 0) {
            godType = "El Déu";
        } else if (super.getGenere() == 1) {
            godType = "La Deesa";
        }
        if (this.action == GodAction.NONE) {
            textToReturn += "\t" + godType +" encara no ha estat invocat";
        } else if (this.action == GodAction.ENDOW_INTELLIGENCE) {
            textToReturn += "\t" + godType + " ha dotat de intel·ligència a qui l0ha invocat";
        } else if (this.action == GodAction.ENDOW_POWER) {
            textToReturn += "\t" + godType + " ha dotat de poder a qui l'ha invocat";
        } else if (this.action == GodAction.ENDOW_STRENGTH) {
            textToReturn += "\t" + godType + " ha dotat de força a qui l'ha invocat";
        } else if (this.action == GodAction.ENDOW_BEAUTY) {
            textToReturn += "\t" + godType + " ha dotat de bellesa a qui l'ha invocat";
        }

        return textToReturn;
    }
}
