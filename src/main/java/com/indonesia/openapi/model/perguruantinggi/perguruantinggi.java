package com.indonesia.openapi.model.perguruantinggi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_perguruan_tinggi", schema = "perguruan_tinggi")
public class perguruantinggi {
    @Id
    private int id;
    @Column (name = "nama_pt")
    private String nama;
    @Column (name = "provinsi_pt")
    private String provinsi;
    @Column (name = "kabupatenkota")
    private String kabupatenkota;


    public String getKabupatenkota() {
        return this.kabupatenkota;
    }

    public void setKabupatenkota(String kabupatenkota) {
        this.kabupatenkota = kabupatenkota;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProvinsi() {
        return this.provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }


}
