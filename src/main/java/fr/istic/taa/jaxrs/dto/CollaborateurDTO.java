package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.Collaborateur;
import fr.istic.taa.jaxrs.domain.Fiche;

import java.util.ArrayList;
import java.util.List;

import static fr.istic.taa.jaxrs.dto.FicheDTO.fromFiche;

public class CollaborateurDTO {
    private String email;
    private String nom;
    private String prenom;
    private List<FicheDTO> fiches = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<FicheDTO> getFiches() {
        return fiches;
    }

    public void setFiches(List<FicheDTO> fiches) {
        this.fiches = fiches;
    }

    public static CollaborateurDTO fromCollaborateur(Collaborateur clb) {
        CollaborateurDTO dto = new CollaborateurDTO();
        dto.setEmail(clb.getEmail());
        dto.setPrenom(clb.getPrenom());
        dto.setNom(clb.getNom());
        List<FicheDTO> fiches = new ArrayList<>();
        for (Fiche fiche: clb.getFiches()) {
            fiches.add(fromFiche(fiche));
        }
        dto.setFiches(fiches);

        return dto;
    }
}
