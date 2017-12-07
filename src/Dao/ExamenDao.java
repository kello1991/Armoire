package Dao;

import DataBase.connection;
import Entity.Examen;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExamenDao {

    private Connection conn = new connection().connecterDB();


    public List<Examen> getExams() {
        String requete = "select * from examen ORDER BY id ";
        List<Examen> examenList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Examen v = new Examen();
                v.setId(resultat.getInt(1));
                v.setIdTag(resultat.getString(2));
                v.setClasss(resultat.getString(3));
                v.setModule(resultat.getString(4));
                v.setDateHeur(resultat.getDate(5));
                v.setEnseignant(resultat.getString(6));
                v.setSalle(resultat.getString(7));
                v.setDuree(resultat.getInt(8));
                v.setResponsable(resultat.getString(9));
                v.setHeure(resultat.getString(10));


                examenList.add(v);
            }
        } catch (SQLException ex) {
            System.out.println("error " + ex.getMessage());

        }
        return examenList;
    }

    public List<Examen> getExamsByClass(String classe) {
        String requete = "select * from examen WHERE classs='"+classe+"' ORDER BY id ";

        List<Examen> examenList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Examen v = new Examen();
                v.setId(resultat.getInt(1));
                v.setIdTag(resultat.getString(2));
                v.setClasss(resultat.getString(3));
                v.setModule(resultat.getString(4));
                v.setDateHeur(resultat.getDate(5));
                v.setEnseignant(resultat.getString(6));
                v.setSalle(resultat.getString(7));
                v.setDuree(resultat.getInt(8));
                v.setResponsable(resultat.getString(9));
                v.setHeure(resultat.getString(10));



                examenList.add(v);
            }
        } catch (SQLException ex) {
            System.out.println("error " + ex.getMessage());

        }
        System.out.println("Class");
        System.out.println(examenList);
        return examenList;
    }

    public List<Examen> getExamsByModule(String module) {
        String requete = "select * from examen WHERE module='"+module+"' ORDER BY id ";
        List<Examen> examenList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Examen v = new Examen();
                v.setId(resultat.getInt(1));
                v.setIdTag(resultat.getString(2));
                v.setClasss(resultat.getString(3));
                v.setModule(resultat.getString(4));
                v.setDateHeur(resultat.getDate(5));
                v.setEnseignant(resultat.getString(6));
                v.setSalle(resultat.getString(7));
                v.setDuree(resultat.getInt(8));
                v.setResponsable(resultat.getString(9));
                v.setHeure(resultat.getString(10));



                examenList.add(v);
            }
        } catch (SQLException ex) {
            System.out.println("error " + ex.getMessage());

        }
        System.out.println("Module");
        System.out.println(examenList);
        return examenList;
    }

    public List<Examen> getExamsByClassAndModule(String module, String classe) {
        String requete = "select * from examen WHERE module ="+module+" AND classs ="+classe+"ORDER BY id ";
        List<Examen> examenList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Examen v = new Examen();
                v.setId(resultat.getInt(1));
                v.setIdTag(resultat.getString(2));
                v.setClasss(resultat.getString(3));
                v.setModule(resultat.getString(4));
                v.setDateHeur(resultat.getDate(5));
                v.setEnseignant(resultat.getString(6));
                v.setSalle(resultat.getString(7));
                v.setDuree(resultat.getInt(8));
                v.setResponsable(resultat.getString(9));
                v.setHeure(resultat.getString(10));


                examenList.add(v);
            }
        } catch (SQLException ex) {
            System.out.println("error " + ex.getMessage());

        }
        return examenList;
    }

    public List<Examen> getExamsByDate(Date date) {
        String requete = "select * from examen ORDER BY id ";

        List<Examen> examenList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Examen v = new Examen();
                v.setId(resultat.getInt(1));
                v.setIdTag(resultat.getString(2));
                v.setClasss(resultat.getString(3));
                v.setModule(resultat.getString(4));
                v.setDateHeur(resultat.getDate(5));
                v.setEnseignant(resultat.getString(6));
                v.setSalle(resultat.getString(7));
                v.setDuree(resultat.getInt(8));
                v.setResponsable(resultat.getString(9));
                v.setHeure(resultat.getString(10));



                System.out.println(date);
                System.out.println(v.getDateHeur());


                if (date.toString().equals(v.getDateHeur().toString())){

                examenList.add(v);
                }
            }
        } catch (SQLException ex) {
            System.out.println("error " + ex.getMessage());

        }
        return examenList;
    }


}

