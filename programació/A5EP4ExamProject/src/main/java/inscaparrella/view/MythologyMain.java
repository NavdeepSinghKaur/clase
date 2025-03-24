package main.java.inscaparrella.view;

import main.java.inscaparrella.controller.MythologicalController;
import main.java.inscaparrella.model.MythologicalCharacter;
import main.java.inscaparrella.utils.MythologicalCharacterType;
import main.java.inscaparrella.utils.MythologyOrigin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MythologyMain {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner keyboard = new Scanner(System.in);
        MythologicalController controller = new MythologicalController();
        MythologicalCharacterType types[] = MythologicalCharacterType.values();
        MythologyOrigin origins[] = MythologyOrigin.values();
        ArrayList<MythologicalCharacter> characters;
        MythologicalCharacter character;
        int option, toption, ooption, goption, hoption, fgoption, ugoption;
        String fgname, ugname;

        controller.loadMythologicalCharacters("files" + File.separator + "mythology.txt");

        //Per comprovar la lectura de fitxer, descomenteu aquest codi
        for(int i=0; i<origins.length; i++) {
            for(int j=0; j<types.length; j++) {
                if(types[j] != MythologicalCharacterType.NONE && origins[i] != MythologyOrigin.NONE) {
                    System.out.println(types[j] + " - " + origins[i]);
                    System.out.println(mythologicalCharactersToString(controller.getMythologicalCharacters(types[j], origins[i])));
                }
            }
        }

        do {
            System.out.println("~~~ MITOLOGIES DEL MÓN ANTIC ~~~~");
            System.out.println("\t0. Sortir");
            System.out.println("\t1. Consultar els éssers mitològics d'una cultura");
            System.out.println("\t2. Invocar un Déu");
            System.out.println("\t3. Invocar un Heroi");
            System.out.println("\t4. Assignar els Déus a un Heroi");
            System.out.println("\t5. Mostrat tot el món mitològic");
            System.out.print("Opció: ");
            option = keyboard.nextInt();

            switch(option) {
                case 0:
                    System.out.println("Tancant...");
                    break;
                case 1:
                    System.out.println("Escull tipus de personatge i la mitologia");
                    System.out.println("Tipus");
                    System.out.println(typesToMenuString(types));
                    System.out.println("Orígens");
                    System.out.println(originsToMenuString(origins));
                    System.out.print("Opcions (tipus origen): ");
                    toption = keyboard.nextInt();
                    ooption = keyboard.nextInt();

                    System.out.println(types[toption] + " - " + origins[ooption]);
                    System.out.println(mythologicalCharactersToString(controller.getMythologicalCharacters(types[toption], origins[ooption])));
                    break;
                case 2:
                    System.out.println("Escull la mitologia del Déu que vols invocar");
                    System.out.println("Orígens");
                    System.out.println(originsToMenuString(origins));
                    System.out.print("Opció: ");
                    ooption = keyboard.nextInt();

                    characters = controller.getMythologicalCharacters(MythologicalCharacterType.GOD, origins[ooption]);
                    if(characters.size() == 0) System.out.println("Aquesta mitologia no té cap Déu");
                    else {
                        System.out.println("Ecull el Déu que vols invocar (" + MythologicalCharacterType.GOD + " - " + origins[ooption] + ")");
                        System.out.println(mythologicalCharactersToMenuString(characters));
                        System.out.print("Opció: ");
                        goption = keyboard.nextInt();

                        character = controller.invoke(MythologicalCharacterType.GOD, characters.get(goption).getName());
                        System.out.println(character.toString());
                    }
                    break;
                case 3:
                    System.out.println("Escull la mitologia de l'Heroi que vols invocar");
                    System.out.println("Orígens");
                    System.out.println(originsToMenuString(origins));
                    System.out.print("Opció: ");
                    ooption = keyboard.nextInt();

                    characters = controller.getMythologicalCharacters(MythologicalCharacterType.HERO, origins[ooption]);
                    if(characters.size() == 0) System.out.println("Aquesta mitologia no té cap Heroi");
                    else {
                        System.out.println("Ecull l'Heroi que vols invocar (" + MythologicalCharacterType.HERO + " - " + origins[ooption] + ")");
                        System.out.println(mythologicalCharactersToMenuString(characters));
                        System.out.print("Opció: ");
                        hoption = keyboard.nextInt();

                        character = controller.invoke(MythologicalCharacterType.HERO, characters.get(hoption).getName());
                        System.out.println(character.toString());
                    }
                    break;
                case 4:
                    System.out.println("Escull la mitologia de l'Heroi que vols invocar");
                    System.out.println("Orígens");
                    System.out.println(originsToMenuString(origins));
                    System.out.print("Opció: ");
                    ooption = keyboard.nextInt();

                    characters = controller.getMythologicalCharacters(MythologicalCharacterType.GOD, origins[ooption]);

                    System.out.println("Escull el Déu que li és favorable i el que li és desfavorable");
                    System.out.println("Déus");
                    System.out.println(mythologicalCharactersToMenuString(characters));
                    System.out.println("Opcions (favorable desfavorable): ");
                    fgoption = keyboard.nextInt();
                    ugoption = keyboard.nextInt();

                    fgname = characters.get(fgoption).getName();
                    ugname = characters.get(ugoption).getName();

                    characters = controller.getMythologicalCharacters(MythologicalCharacterType.HERO, origins[ooption]);

                    if(characters.size() == 0) System.out.println("Aquesta mitologia no té cap Heroi");
                    else {
                        System.out.println("Ecull l'Heroi que vols modificar (" + MythologicalCharacterType.HERO + " - " + origins[ooption] + ")");
                        System.out.println(mythologicalCharactersToMenuString(characters));
                        System.out.print("Opció: ");
                        hoption = keyboard.nextInt();

                        controller.addFavorableGod(origins[ooption], characters.get(hoption).getName(), fgname);
                        controller.addUnfavorableGod(origins[ooption], characters.get(hoption).getName(), ugname);

                        System.out.println(controller.getMythologicalCharacters(MythologicalCharacterType.HERO, origins[ooption]).get(hoption).toString());
                    }
                    break;
                case 5:
                    System.out.println(controller.toString());
                    break;
                default:
                    System.out.println("Opció incorrecta");
            }

        } while(option != 0);
    }

    private static String mythologicalCharactersToString(ArrayList<MythologicalCharacter> characters) {
        String str = "";

        if(characters.size() == 0) System.out.println("-- No se'n té cap registre --");
        for(int pos=0; pos<characters.size(); pos++) {
            str += characters.get(pos).toString() + "\n";
        }

        return str;
    }

    private static String mythologicalCharactersToMenuString(ArrayList<MythologicalCharacter> characters) {
        String str = "";

        if(characters.size() == 0) System.out.println("-- No se'n té cap registre --");
        for(int pos=0; pos<characters.size(); pos++) {
            str += "\t" + pos + ". " + characters.get(pos).getName() + "\n";
        }

        return str;
    }

    private static String typesToMenuString(MythologicalCharacterType types[]) {
        String str = "";

        for(int pos=1; pos< types.length; pos++) {
            str += "\t" + pos + ". " + types[pos] + "\n";
        }

        return str;
    }

    private static String originsToMenuString(MythologyOrigin origins[]) {
        String str = "";

        for(int pos=1; pos< origins.length; pos++) {
            str += "\t" + pos + ". " + origins[pos] + "\n";
        }

        return str;
    }
}
