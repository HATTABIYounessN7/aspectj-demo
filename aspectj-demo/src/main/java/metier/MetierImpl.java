package metier;

import java.util.HashMap;
import java.util.Map;

public class MetierImpl implements Metier {
    private Map<Long, Compte> comptes = new HashMap<>();

    @Override
    public void addCompte(Compte compte) {
        comptes.put(compte.getCode(), compte);
    }

    @Override
    public void verser(Long code, double montant) {
        Compte compte = comptes.get(code);
        compte.setSolde(compte.getSolde() + montant);
    }

    @Override
    public void retirer(Long code, double montant) {
        Compte compte = comptes.get(code);
        compte.setSolde(compte.getSolde() - montant);
    }

    @Override
    public Compte getCompte(Long code) {
        return comptes.get(code);
    }
}
