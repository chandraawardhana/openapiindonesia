package com.indonesia.openapi.model.daerah;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kecamatan", schema = "daerah")
public class Kecamatan {

    @Id
    @Column(name = "id_kec")
    private String id;

    @Column(name = "id_kab")
    private String idkab;

    @Column(name = "nama")
    private String nama;

    @ManyToOne
    @JoinColumn(name = "id_kab", insertable = false, updatable = false)
    private Kabupatenkota kabupatenkota;


    public Kabupatenkota getKabupatenkota() {
        return this.kabupatenkota;
    }

    public void setKabupatenkota(Kabupatenkota kabupatenkota) {
        this.kabupatenkota = kabupatenkota;
    }



    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdkab() {
        return this.idkab;
    }

    public void setIdkab(String idkab) {
        this.idkab = idkab;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    

    
}
