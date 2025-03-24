package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.MythologicalCharacterType;
import main.java.inscaparrella.utils.MythologyOrigin;

import java.util.Objects;

public abstract class MythologicalCharacter implements Comparable<MythologicalCharacter>{
    private String name;
    protected MythologicalCharacterType type;
    protected int genere;
    private MythologyOrigin origin;

    public MythologicalCharacter() {
        this.name = "";
        this.genere = 0;
        this.type = MythologicalCharacterType.NONE;
        this.origin = MythologyOrigin.NONE;
    }
    public MythologicalCharacter(String name, MythologicalCharacterType type, int genere, MythologyOrigin origin) {
        this.name = name;
        this.type = type;
        this.genere = genere;
        this.origin = origin;
    }

    public MythologicalCharacter(MythologicalCharacter mc) {
        this.name = mc.getName();
        this.type = mc.getType();
        this.genere = mc.getGenere();
        this.origin = mc.getOrigin();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MythologicalCharacterType getType() {
        return type;
    }

    public void setType(MythologicalCharacterType type) {
        this.type = type;
    }

    public int getGenere() {
        return genere;
    }

    public void setGenere(int genere) {
        this.genere = genere;
    }

    public MythologyOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(MythologyOrigin origin) {
        this.origin = origin;
    }

    public abstract void invokeAction();

    @Override
    public boolean equals(Object obj) {
        boolean bEquals = false;
        if (obj instanceof MythologicalCharacter otherCharacter) {
            bEquals = this.name.equals(otherCharacter.getName()) && this.getType() == otherCharacter.getType() && this.origin == otherCharacter.getOrigin();
        }

        return bEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, genere, origin);
    }

    @Override
    public int compareTo(MythologicalCharacter character) {
        int valueToReturn = this.origin.compareTo(character.getOrigin());

        if (valueToReturn == 0) {
            valueToReturn = this.getType().compareTo(character.getType());
            if (valueToReturn == 0) {
                valueToReturn = this.getName().compareTo(character.getName());
            }
        }

        return valueToReturn;
    }

    @Override
    public String toString() {
        String textToReturn =  this.name + " (mitologia";

        if (this.origin.equals(MythologyOrigin.NONE)) {
            textToReturn += ": no té)";
        } else if (this.origin.equals(MythologyOrigin.GREEK)) {
            textToReturn += "grega)";

        } else if (this.origin.equals(MythologyOrigin.NORSE)) {
            textToReturn += "nòrdica)";

        } else {
            textToReturn += "egipcia)";
        }

        return textToReturn;
    }
}
