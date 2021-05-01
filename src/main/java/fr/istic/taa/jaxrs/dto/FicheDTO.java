package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.Fiche;

public class FicheDTO {
    private String libelle;
    private Long id;
    private String lieu;
    private String url;
    private String note;
    private String date;
    private String collaborateurFullName;
    private Long dureeTache;
    private String commit;
    private String collaborateurRole;
    private String sectionStatus;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCollaborateurFullName() {
        return collaborateurFullName;
    }

    public void setCollaborateurFullName(String collaborateurFullName) {
        this.collaborateurFullName = collaborateurFullName;
    }

    public String getCollaborateurRole() {
        return collaborateurRole;
    }

    public void setCollaborateurRole(String collaborateurRole) {
        this.collaborateurRole = collaborateurRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDureeTache() {
        return dureeTache;
    }

    public void setDureeTache(Long dureeTache) {
        this.dureeTache = dureeTache;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public String getSectionStatus() {
        return sectionStatus;
    }

    public void setSectionStatus(String sectionStatus) {
        this.sectionStatus = sectionStatus;
    }

    public static FicheDTO fromFiche(Fiche fiche) {
        FicheDTO ficheDTO = new FicheDTO();
        ficheDTO.setId(fiche.getId());
        ficheDTO.setCollaborateurFullName(fiche.getCollaborateur().getPrenom()
                + " " + fiche.getCollaborateur().getNom());
        ficheDTO.setCollaborateurRole(fiche.getCollaborateur().getRole());
        ficheDTO.setCommit(fiche.getCommit());
        ficheDTO.setLibelle(fiche.getLibelle());
        ficheDTO.setDate(fiche.getDate().toString());
        ficheDTO.setLieu(fiche.getLieu());
        ficheDTO.setDureeTache(fiche.getDureeTache());
        ficheDTO.setUrl(fiche.getUrl());
        ficheDTO.setNote(fiche.getNote());
        //ficheDTO.setSectionStatus(fiche.getSection().getStatus().toString());
        return ficheDTO;
    }
}
