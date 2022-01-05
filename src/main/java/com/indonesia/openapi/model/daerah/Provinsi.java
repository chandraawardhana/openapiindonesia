package com.indonesia.openapi.model.daerah;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provinsi", schema = "daerah")
public class Provinsi {
    @Id
    @Column(name = "id_prov")
    private String id;

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
