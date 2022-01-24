import java.io.FileInputStream;
import java.util.ArrayList;
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

            while (scanner.hasNextLine()) {
            String ligne = scanner.nextLine();
            int separateur = ligne.indexOf(":");
            String motCle = ligne.substring(0,separateur);
            int poids = parseInt(ligne.substring(separateur+1));
            PaireChaineEntier unLexique = new PaireChaineEntier(motCle, poids);
            lexique.add(unLexique);
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
