import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Categorie {

    private String nom; // le nom de la catégorie p.ex : sport, politique,...
    private ArrayList<PaireChaineEntier> lexique; //le lexique de la catégorie

    // constructeur
    public Categorie(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<PaireChaineEntier> getLexique() {
        return lexique;
    }

    // initialisation du lexique de la catégorie à partir du contenu d'un fichier texte
    public void initLexique(String nomFichier) {
        lexique = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(nomFichier);
            Scanner scanner = new Scanner(file);
            String ligne;
            int index;
            String chaine;
            int entier;

            while (scanner.hasNextLine()) {
                ligne = scanner.nextLine();
                index = ligne.indexOf(":");
                chaine = ligne.substring(0,index);
                entier = parseInt(ligne.substring(index+1));
                lexique.add(new PaireChaineEntier(chaine, entier));
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //calcul du score d'une dépêche pour la catégorie
    public int score(Depeche d) {
        return 0;
    }
}
