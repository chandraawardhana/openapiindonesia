package com.indonesia.openapi.service.daerah;

import java.util.List;

import com.indonesia.openapi.model.daerah.Kabupatenkota;
import com.indonesia.openapi.repositori.daerah.KabupatenkotaRepositori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class kabupatenkotaService {

    @Autowired 
    KabupatenkotaRepositori kabupatenkotaRepositori;

    public List <Kabupatenkota> findAllKabupatenkota() {
        return kabupatenkotaRepositori.findAll();
    }

    public Page <Kabupatenkota> findAllKabupatenkotaPage(Pageable pageable) {
        return kabupatenkotaRepositori.findAll(pageable);
    }

    public List <Kabupatenkota> getByProvinsi(String idProv) {
        return kabupatenkotaRepositori.findByIdprov(idProv);
    }

    public Page<Kabupatenkota> getByIdprovinsiPage(String idProv, Pageable pageable) {
        return kabupatenkotaRepositori.findByIdprov(idProv, pageable);
    }

    public List <Kabupatenkota> getByNamaAndIdProvinsi(String nama, String idProv) {
        return kabupatenkotaRepositori.findByNamaIgnoreCaseContainingAndIdprov(nama, idProv);
    }

    public List <Kabupatenkota> getByNama (String nama) {
        return kabupatenkotaRepositori.findByNamaIgnoreCaseContaining(nama);
    }

    public Page <Kabupatenkota> getByNamaPage (String nama, Pageable pageable) {
        return kabupatenkotaRepositori.findByNamaIgnoreCaseContaining(nama, pageable);
    }

    public Page <Kabupatenkota> getByNamaAndaIdProvinsiPage(String nama, String idProv, Pageable pageable) {
        return kabupatenkotaRepositori.findByNamaIgnoreCaseContainingAndIdprov(nama, idProv, pageable);
    }







    
}
