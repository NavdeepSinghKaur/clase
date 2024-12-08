public class Main {
    public static int comptarLletres(String txt, char lletra){
       
        int i, comptar;
        txt = txt.toLowerCase();
        lletra = Character.toLowerCase(lletra);

        i = 0;
        comptar = 0;
        while (i<txt.length()) {
            if(txt.charAt(i)== lletra) comptar = comptar + 1;
            i = i + 1;
        }
       
        return comptar;
    }

    public static void main (String args[]) {
        System.out.println(comptarLletres("Els alumnes de la classe", 'E'));
    }
}