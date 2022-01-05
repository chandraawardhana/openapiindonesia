package com.indonesia.openapi.model.daerah;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "kabupaten", schema = "daerah")
public class Kabupatenkota {

    @Id
    @Column(name = "id_kab")
    private String id;

    @Column(name = "id_prov")
    private String idprov;

    @ManyToOne
    @JoinColumn(name = "id_prov", insertable = false, updatable = false)
    private Provinsi provinsi;


    public Provinsi getProvinsi() {
        return this.provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }

    public String getIdprov() {
        return this.idprov;
    }

    public void setIdprov(String idprov) {
        this.idprov = idprov;
    }

    @Column(name = "nama")
    private String nama;
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }




    
}
