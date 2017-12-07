package Entity;

import java.sql.Date;
import java.util.Objects;





public class Examen {

    private int id;
    private String idTag;
    private String classs;
    private String module;
    private String salle;
    private String responsable;
    private String enseignant;
    private int duree;
    private Date dateHeur;
    private Date hSortie;
    private Date hRetour;

    public Examen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdTag() {
        return idTag;
    }

    public void setIdTag(String idTag) {
        this.idTag = idTag;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDateHeur() {
        return dateHeur;
    }

    public void setDateHeur(Date dateHeur) {
        this.dateHeur = dateHeur;
    }

    public Date gethSortie() {
        return hSortie;
    }

    public void sethSortie(Date hSortie) {
        this.hSortie = hSortie;
    }

    public Date gethRetour() {
        return hRetour;
    }

    public void sethRetour(Date hRetour) {
        this.hRetour = hRetour;
    }

    @Override
    public String toString() {
        return "Examen{" + "id=" + id + ", idTag=" + idTag + ", classs=" + classs + ", module=" + module + ", salle=" + salle + ", responsable=" + responsable + ", enseignant=" + enseignant + ", duree=" + duree + ", dateHeur=" + dateHeur + ", hSortie=" + hSortie + ", hRetour=" + hRetour + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.idTag);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Examen other = (Examen) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.idTag, other.idTag)) {
            return false;
        }
        return true;
    }





}