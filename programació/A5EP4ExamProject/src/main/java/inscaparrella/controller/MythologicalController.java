package main.java.inscaparrella.controller;

import main.java.inscaparrella.model.God;
import main.java.inscaparrella.model.Hero;
import main.java.inscaparrella.model.MythologicalCharacter;
import main.java.inscaparrella.utils.MythologicalCharacterType;
import main.java.inscaparrella.utils.MythologyOrigin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MythologicalController {
    private ArrayList<MythologicalCharacter> characters;

    public MythologicalController() {
        characters = new ArrayList<>();
    }

    public void loadMythologicalCharacters(String filename) throws FileNotFoundException, IOException {
        FileReader freader = new FileReader(filename);
        BufferedReader breader = new BufferedReader(freader);

        breader.lines().forEach((String line) -> {
            String lelems[] = line.split(";");
            God god;
            Hero hero;

            if(MythologicalCharacterType.GOD.name().equals(lelems[0])) {
                god = new God(lelems[1], Integer.valueOf(lelems[2]), MythologyOrigin.valueOf(lelems[3]), lelems[4]);
                this.characters.add(god);
            } else if (MythologicalCharacterType.HERO.name().equals(lelems[0])){
                hero = new Hero(lelems[1], Integer.valueOf(lelems[2]), MythologyOrigin.valueOf(lelems[3]));
                this.characters.add(hero);
            }
        });

        this.characters.sort(null);

        breader.close();
    }

    public ArrayList<MythologicalCharacter> getMythologicalCharacters(MythologicalCharacterType type, MythologyOrigin origin) {
        ArrayList<MythologicalCharacter> charactersToReturn = new ArrayList<>();

        for (MythologicalCharacter character : characters) {
            if (character.getType().equals(type) && character.getOrigin().equals(origin)) {
                if (character instanceof Hero) {
                    charactersToReturn.add(new Hero((Hero) character));
                } else if (character instanceof God) {
                    charactersToReturn.add(new God((God) character));
                }
            }
        }

        return charactersToReturn;
    }

    public Hero addFavorableGod(MythologyOrigin origin, String hname, String gname) {
        God god = null;
        Hero hero = null;
        Hero returnHero = null;
        for (MythologicalCharacter character : characters) {
            if (character.getName().equals(gname)) {
                if (character.getOrigin().equals(origin) && character.getType().equals(MythologicalCharacterType.GOD)) {
                    god = (God) character;
                }
            } else if (character.getName().equals(hname)) {
                if (character.getOrigin().equals(origin) && character.getType().equals(MythologicalCharacterType.HERO)) {
                    hero = (Hero) character;
                }
            }
        }
        if (hero != null && god != null) {
        hero.setFavourableGodName(god.getName());
        }
        returnHero = new Hero(hero);

        return returnHero;
    }

    public Hero addUnfavorableGod(MythologyOrigin origin, String hname, String gname) {
        God god = null;
        Hero hero = null;
        Hero returnHero = null;
        for (MythologicalCharacter character : characters) {
            if (character.getName().equals(gname)) {
                if (character.getOrigin().equals(origin) && character.getType().equals(MythologicalCharacterType.GOD)) {
                    god = new God((God) character);
                }
            } else if (character.getName().equals(hname)) {
                if (character.getOrigin().equals(origin) && character.getType().equals(MythologicalCharacterType.HERO)) {
                    hero = new Hero((Hero) character);
                }
            }
        }
        if (god != null && hero != null) {
            hero.setUnFavourableGodName(god.getName());
        }
        returnHero = new Hero(hero);

        return returnHero;
    }

    public MythologicalCharacter invoke(MythologicalCharacterType origin, String name) {
        MythologicalCharacter characterToReturn = null;
        for (MythologicalCharacter character : characters) {
            if (character.getType().equals(origin) && character.getName().equals(name)) {
                character.invokeAction();
                if (character instanceof God) {
                    characterToReturn = new God((God) character);
                } else if (character instanceof Hero) {
                    characterToReturn = new Hero((Hero) character);
                }
            }
        }

        return characterToReturn;
    }

    @Override
    public String toString() {
        String textToReturn = "";

        for (MythologicalCharacter character : characters) {
            textToReturn += character.toString() + "\n";
        }

        return textToReturn;
    }
}
