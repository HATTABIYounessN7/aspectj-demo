package metier;

public interface Metier {
    void addCompte(Compte cp);

    void verser(Long code, double mt);

    void retirer(Long code, double mt);

    Compte getCompte(Long code);
}
