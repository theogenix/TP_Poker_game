import java.util.Comparator;

public class Carte {
    private Couleur couleur;
    private Valeur valeur;
    public Carte(Couleur couleur, Valeur valeur){
        this.valeur=valeur;
        this.couleur=couleur;
    }
    public Couleur getCouleur()
    {
        return couleur;
    }
    public void setSuit(Couleur setCouleur)
    {
        this.couleur = couleur;
    }
    public Valeur getValeur()
    {
        return valeur;
    }

    public void setValeur(Valeur valeur)
    {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return this.valeur.toString()+" de "+this.couleur.toString();
    }
}

class CouleurComparator implements Comparator<Carte> {
    @Override
    public int compare(Carte a, Carte b) {
        return a.getCouleur().toString().compareTo(b.getCouleur().toString());
    }
}
class ValeurComparator implements Comparator<Carte> {
    @Override
    public int compare(Carte a, Carte b) {
        return a.getValeur().getValeur() - b.getValeur().getValeur();
    }
}

class CarteComparator implements Comparator<Carte> {
    @Override
    public int compare(Carte a, Carte b) {
        if(a.getCouleur() != b.getCouleur()){
            return a.getCouleur().toString().compareTo(b.getCouleur().toString());
        } else {
            return a.getValeur().getValeur() - b.getValeur().getValeur();
        }
    }
}
