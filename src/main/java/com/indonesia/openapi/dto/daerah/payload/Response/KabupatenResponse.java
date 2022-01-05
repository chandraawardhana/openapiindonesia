package com.indonesia.openapi.dto.daerah.payload.Response;

public class KabupatenResponse {

    private String id;
    private String idProv;
    private String namaProv;
    private String namaKabkota;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getNamaKabkota() {
        return this.namaKabkota;
    }

    public void setNamaKabkota(String namaKabkota) {
        this.namaKabkota = namaKabkota;
    }

}
