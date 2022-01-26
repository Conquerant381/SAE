import jdk.jshell.execution.Util;

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

        int ScoreCulture = 0, nbDepecheCulture = 0;
        int ScoreEco = 0, nbDepecheEco = 0;
        int ScoreEnv = 0, nbDepecheEnv = 0;
        int ScorePolitique = 0, nbDepechePolitique = 0;
        int ScoreSport = 0, nbDepecheSport = 0;

        String categorieTrouve;
        int reponseCorrecte;

        try {
            FileWriter file = new FileWriter(nomFichier);

            // Boucle sur toutes les dépêches
            for (int i = 0; i < depeches.size(); i++) {

                // Création et mise à jour d'un tableau de score pour la dépêche pour chaque catégorie
                ArrayList<PaireChaineEntier> catScore = new ArrayList<>();
                for (int j = 0; j < categories.size(); j++) {
                    catScore.add(new PaireChaineEntier(categories.get(j).getNom(), categories.get(j).score(depeches.get(i))));
                }

                // Détermination de la catégorie de la dépêche
                categorieTrouve = UtilitairePaireChaineEntier.chaineMax(catScore);

                // Comparaison de la catégorie trouvée avec la catégorie indiquée dans la dépêche
                if (depeches.get(i).getCategorie().compareTo(categorieTrouve) == 0) {
                    reponseCorrecte = 1;
                } else {
                    reponseCorrecte = 0;
                }

                // Mise à jour du tableau de résultat pour la catégorie de la dépêche
                switch (depeches.get(i).getCategorie()) {
                    case "CULTURE":
                        ScoreCulture += reponseCorrecte;
                        nbDepecheCulture++;
                        break;
                    case "ECONOMIE":
                        ScoreEco += reponseCorrecte;
                        nbDepecheEco++;
                        break;
                    case "ENVIRONNEMENT-SCIENCES":
                        ScoreEnv += reponseCorrecte;
                        nbDepecheEnv++;
                        break;
                    case "POLITIQUE":
                        ScorePolitique += reponseCorrecte;
                        nbDepechePolitique++;
                        break;
                    case "SPORTS":
                        ScoreSport += reponseCorrecte;
                        nbDepecheSport++;
                        break;
                    default:
                        // Ne dois jamais être là
                }
                // Affichage de la catégorie trouvée pour la dépêche
                file.write(String.format("%03d", i+1) + ":" + categorieTrouve + "\n");
            }

            // Calcul des moyennes
            float moyenneCulture = ScoreCulture*100/nbDepecheCulture;
            float moyenneEco = ScoreEco*100/nbDepecheEco;
            float moyenneEnv = ScoreEnv*100/nbDepecheEnv;
            float moyennePolitique = ScorePolitique*100/nbDepechePolitique;
            float moyenneSport = ScoreSport*100/nbDepecheSport;

            // Affichage des moyennes
            file.write("CULTURE:\t\t\t\t" + moyenneCulture + "%\n");
            file.write("ECONOMIE:\t\t\t\t" + moyenneEco + "%\n");
            file.write("ENVIRONNEMENT-SCIENCES:\t" + moyenneEnv + "%\n");
            file.write("POLITIQUE:\t\t\t\t" + moyennePolitique + "%\n");
            file.write("SPORTS:\t\t\t\t\t" + moyenneSport + "%\n");
            file.write("MOYENNE:\t\t\t\t" + ((moyenneCulture+moyenneEco+moyenneEnv+moyennePolitique+moyenneSport)/5) + "%\n");


            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        //Chargement des dépêches en mémoire
        System.out.println("chargement des dépêches");
        ArrayList<Depeche> depeches = lectureDepeches("./depeches.txt");

        /*
        for (int i = 0; i < depeches.size(); i++) {
            depeches.get(i).afficher();
        }
        */

        // Création de la catégorie
        Categorie categorieCulture = new Categorie("CULTURE");
        Categorie categorieEco = new Categorie("ECONOMIE");
        Categorie categorieEnvironment = new Categorie("ENVIRONNEMENT-SCIENCES");
        Categorie categoriePolitique = new Categorie("POLITIQUE");
        Categorie categorieSport = new Categorie("SPORTS");

        // Initialisation du lexique
        categorieCulture.initLexique("./culture.txt");
        categorieEco.initLexique("./eco.txt");
        categorieEnvironment.initLexique("./environment.txt");
        categoriePolitique.initLexique("./politique.txt");
        categorieSport.initLexique("./sport.txt");

        // ArrayList des 5 Categories
        ArrayList<Categorie> Categorie = new ArrayList();
        Categorie.add(categorieCulture);
        Categorie.add(categorieEco);
        Categorie.add(categorieEnvironment);
        Categorie.add(categoriePolitique);
        Categorie.add(categorieSport);

/*
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

        // Test Score
        for (int i = 0; i < 499; i++) {
            System.out.println(i + 1 + " " + categorieSport.score(depeches.get(i)));
        }

        // Création du vecteur de scores
        ArrayList<PaireChaineEntier> catScore = new ArrayList<>();

        // Mise à jour du vecteur de scores pour la dépêche n°150
        for (int i = 0; i < Categorie.size(); i++) {
            catScore.add(new PaireChaineEntier(Categorie.get(i).getNom(), Categorie.get(i).score(depeches.get(150))));
        }

        // Nom de la catégorie ayant le score maximal
        System.out.println(UtilitairePaireChaineEntier.chaineMax(catScore));*/

        classementDepeches(depeches, Categorie, "Classement.txt");

    }

}


