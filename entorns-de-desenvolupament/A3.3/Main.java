public class Main {
    public static int cercaSubcadena(String text, String subcadena) {
       
        int longText = text.length();
        int longSub = subcadena.length();
        int posicio = -1;


        if (longSub == 0 || longSub > longText || text == null || subcadena == null ) {
            posicio = -1;
        } else{
            int i = 0;
            int j = 0;
            while (i < (longText - longSub) && posicio == -1) {
                if(subcadena.charAt(0) == text.charAt(i)){
                    posicio = i;
                    while( j < longSub && posicio > -1){
                        if(text.charAt(i) == subcadena.charAt(j)){
                            j ++;
                            i ++;
                        } else posicio = -1;
                    }
                }
                i = i + 1;
            }
        }
        return posicio;
    }


}
