package com.indonesia.openapi.dto.daerah.payload.Request;

public class KabupatenReques {

    private String id;
    private String idprov;
    private String namaProv;
    private String namaKab;
    private String namaKec;
    private String namaKel;
    private String idKel;
    private String idKec;


    public String getNamaKec() {
        return this.namaKec;
    }

    public void setNamaKec(String namaKec) {
        this.namaKec = namaKec;
    }

    public String getNamaKel() {
        return this.namaKel;
    }

    public void setNamaKel(String namaKel) {
        this.namaKel = namaKel;
    }

    public String getIdKel() {
        return this.idKel;
    }

    public void setIdKel(String idKel) {
        this.idKel = idKel;
    }

    public String getIdKec() {
        return this.idKec;
    }

    public void setIdKec(String idKec) {
        this.idKec = idKec;
    }



    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdprov() {
        return this.idprov;
    }

    public void setIdprov(String idprov) {
        this.idprov = idprov;
    }

    public String getNamaProv() {
        return this.namaProv;
    }

    public void setNamaProv(String namaProv) {
        this.namaProv = namaProv;
    }

    public String getNamaKab() {
        return this.namaKab;
    }

    public void setNamaKab(String namaKab) {
        this.namaKab = namaKab;
    }


    
}
