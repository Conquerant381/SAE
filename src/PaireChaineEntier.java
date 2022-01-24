public class PaireChaineEntier {
    private String chaine;
    private int entier;

    public PaireChaineEntier(String chaine, int entier) {
        this.chaine = chaine;
        this.entier = entier;
    }

    public String getchaine() {
        return this.chaine;
    }

    public void setchaine(String chaine) {
        this.chaine = chaine;
    }

    public int getEntier() {
        return this.entier;
    }

    public void setEntier(int entier) {
        this.entier = entier;
    }

    public String afficher() {
        return (this.chaine + " - " + this.entier);
    }

}
