import java.util.ArrayList;
import java.util.Locale;

public class UtilitairePaireChaineEntier {


    public static int indicePourChaine(ArrayList<PaireChaineEntier> listePaires, String chaine) {
        for (int i = 0; i < listePaires.size(); i++) {
            if (listePaires.get(i).getchaine().compareTo(chaine) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int entierPourChaine(ArrayList<PaireChaineEntier> listePaires, String chaine) {
        for (int i = 0; i < listePaires.size(); i++) {
            //La comparaison se fait en IgnoreCase pour eviter les problemes liee au majuscules potentiels
            if (listePaires.get(i).getchaine().compareToIgnoreCase(chaine) == 0) {
                return listePaires.get(i).getEntier();
            }
        }
        return 0;
    }

    public static String chaineMax(ArrayList<PaireChaineEntier> listePaires) {
        int IndMax = 0;
        int ScoreMax = 0;
        for (int i = 0; i < listePaires.size(); i++) {
            if (listePaires.get(i).getEntier() > ScoreMax) {
                IndMax = i;
                ScoreMax = listePaires.get(i).getEntier();
            }
        }
        return listePaires.get(IndMax).getchaine();
    }


    public static float moyenne(ArrayList<PaireChaineEntier> listePaires) {
        int total = 0;
        for (int i = 0; i < listePaires.size(); i++) {
            total += listePaires.get(i).getEntier();
            }
        return total/listePaires.size();
    }

}
