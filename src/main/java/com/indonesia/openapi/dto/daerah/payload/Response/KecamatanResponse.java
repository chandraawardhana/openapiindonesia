package com.indonesia.openapi.dto.daerah.payload.Response;

public class KecamatanResponse {
    
    private String idKec;
    private String idKab;
    private String idProv;
    private String namaProv;
    private String namaKab;
    private String namaKec;


    public String getIdKec() {
        return this.idKec;
    }

    public void setIdKec(String idKec) {
        this.idKec = idKec;
    }

    public String getIdKab() {
        return this.idKab;
    }

    public void setIdKab(String idKab) {
        this.idKab = idKab;
    }

    public String getIdProv() {
        return this.idProv;
    }

    public void setIdProv(String idProv) {
        this.idProv = idProv;
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

    public String getNamaKec() {
        return this.namaKec;
    }

    public void setNamaKec(String namaKec) {
        this.namaKec = namaKec;
    }

    
}
