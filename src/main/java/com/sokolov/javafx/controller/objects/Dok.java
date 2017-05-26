package com.sokolov.javafx.controller.objects;


public class Dok {

    private final String nn;
    private final String name_user;
    private final String date_zap;
    private final String date_op;
    private final String tipdokg;
    private final String id_organiz;

    public Dok(String nn, String name_user, String date_zap, String date_op, String tipdokg, String id_organiz) {
        this.nn = nn;
        this.name_user = name_user;
        this.date_zap = date_zap;
        this.date_op = date_op;
        this.tipdokg = tipdokg;
        this.id_organiz = id_organiz;
    }

    public String getNn() {

        return nn;
    }

    public String getName_user() {
        return name_user;
    }

    public String getDate_zap() {
        return date_zap;
    }

    public String getDate_op() {
        return date_op;
    }

    public String getTipdokg() {
        return tipdokg;
    }

    public String getId_organiz() {
        return id_organiz;
    }
}
