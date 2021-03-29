package fr.istic.taa.jaxrs.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "TouteslesFiches", query = "select f from Fiche as f"),
                @NamedQuery(name = "ToutesLesFichesAujoudhui", query = "select f from Fiche  as f WHERE f.date = :date")
        }
)
public class Fiche implements Serializable {
    private Long id;
    private String libelle;
    private String lieu;
    private String url;
    private String note;
    private Date date;
    private Collaborateur collaborateur;
    private Long dureeTache;
    private String commit;
    private Section section;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

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

    public Long getDureeTache() {
        return dureeTache;
    }

    public void setDureeTache(Long dureeTache) {
        this.dureeTache = dureeTache;
    }

    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = new Date();
    }

    @ManyToOne
    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToOne
    public Section getSection() {
        return section;
    }


    @Override
    public String toString() {
        return "Fiche{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", lieu='" + lieu + '\'' +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                ", date=" + date +
                '}';
    }
}
