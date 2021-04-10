package fr.univ.rouen.cv21rest.service;

import fr.univ.rouen.cv21rest.dto.CVDTO;
import fr.univ.rouen.cv21rest.exception.CVNotFoundException;
import fr.univ.rouen.cv21rest.exception.InvalidCVException;

import java.util.List;

/**
 * Interface permettant d'implémenter le service associé à la gestion des CV.
 */
public interface CVService {

    /**
     * Renvoie la liste des CV
     *
     * @return la liste des cv
     */
    List<CVDTO> getAll();

    /**
     * Renvoie le cv identifié par {id}
     *
     * @param id L'identidiant du cv
     * @return le cv identifié par {id}
     * @throws CVNotFoundException si le CV est introuvable
     */
    CVDTO getById(long id);

    /**
     * Créer un nouveau CV et renvoie ce cv muni de son ID
     *
     * @param cv le cv à créer
     * @return Le devis préalablement enregistré
     * @throws InvalidCVException si le CV est invalide
     */
    CVDTO create(CVDTO cv);

    /**
     * Met à jour un nouveau CV identifié par {id} et renvoie ce cv muni de son id.
     *
     * @param id L'identifiant du cv à mettre à jour
     * @param cv le cv à mettre à jour
     * @return Le devis préalablement enregistré
     * @throws InvalidCVException si le CV est invalide
     * @throws CVNotFoundException si le CV est introuvable
     */
    CVDTO update(long id, CVDTO cv);

    /**
     * Supprime un CV identifié par l'id {id}
     *
     * @param id L'identifiant du cv à supprimer
     * @throws CVNotFoundException si le CV est introuvable
     */
    void delete(long id);
}
