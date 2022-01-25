import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Classification {


    private static ArrayList<Depeche> lectureDepeches(String nomFichier) {
        //creation d'un tableau de dépêches
        ArrayList<Depeche> depeches = new ArrayList<>();
        try {
            // lecture du fichier d'entrée
            FileInputStream file = new FileInputStream(nomFichier);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                String id = ligne.substring(3);
                ligne = scanner.nextLine();
                String date = ligne.substring(3);
                ligne = scanner.nextLine();
                String categorie = ligne.substring(3);
                ligne = scanner.nextLine();
                String lignes = ligne.substring(3);
                while (scanner.hasNextLine() && !ligne.equals("")) {
                    ligne = scanner.nextLine();
                    if (!ligne.equals("")) {
                        lignes = lignes + '\n' + ligne;
                    }
                }
                Depeche uneDepeche = new Depeche(id, date, categorie, lignes);
                depeches.add(uneDepeche);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return depeches;
    }


    public static void classementDepeches(ArrayList<Depeche> depeches, ArrayList<Categorie> categories, String nomFichier) {
    }


    public static ArrayList<PaireChaineEntier> initDico(ArrayList<Depeche> depeches, String categorie) {
        ArrayList<PaireChaineEntier> resultat = new ArrayList<>();
        return resultat;

    }

    public static void calculScores(ArrayList<Depeche> depeches, String categorie, ArrayList<PaireChaineEntier> dictionnaire) {
    }

    public static int poidsPourScore(int score) {
        return 0;
    }

    public static void generationLexique(ArrayList<Depeche> depeches, String categorie, String nomFichier) {

    }

    public static void main(String[] args) {
        Scanner lecteur = new Scanner(System.in);
/*
        //Chargement des dépêches en mémoire
        System.out.println("chargement des dépêches");
        ArrayList<Depeche> depeches = lectureDepeches("./depeches.txt");

        for (int i = 0; i < depeches.size(); i++) {
            depeches.get(i).afficher();
        }*/

        // Création de la catégorie
        Categorie categorieSport = new Categorie("Sport");

        // Initialisation du lexique
        categorieSport.initLexique("./sport.txt");

        // Affichage du contenu de l'objet
        System.out.println("Contenu de la catégorie Sport :");
        System.out.println("Nom     : " + categorieSport.getNom());
        for (int i = 0; i < categorieSport.getLexique().size(); i++) {
            System.out.println("Lexique : " + categorieSport.getLexique().get(i).afficher());
        }

        // Saisie d'un mot par l'utilisateur
        System.out.print("Veuiller saisir un mot : ");
        String mot = lecteur.nextLine();

        // Vérification de la présence du mot dans le lexique
        System.out.println("Valeur de " + mot + " = " + UtilitairePaireChaineEntier.entierPourChaine(categorieSport.getLexique(), mot));

        Categorie CatScore = new Categorie("Score");
        CatScore.score();

    }


}

