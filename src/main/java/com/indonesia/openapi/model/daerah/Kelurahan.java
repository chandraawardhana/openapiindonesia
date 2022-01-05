package com.indonesia.openapi.model.daerah;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kelurahan", schema = "daerah")
public class Kelurahan {

    @Id 
    @Column (name = "id_kel")
    private String id;
     
    @Column (name = "id_kec")
    private String idkec;

    @Column (name = "nama")
    private String nama;

    @ManyToOne
    @JoinColumn(name = "id_kec", insertable = false, updatable = false )
    private Kecamatan kecamatan;


    public Kecamatan getKecamatan() {
        return this.kecamatan;
    }

    public void setKecamatan(Kecamatan kecamatan) {
        this.kecamatan = kecamatan;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdkec() {
        return this.idkec;
    }

    public void setIdkec(String idkec) {
        this.idkec = idkec;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
