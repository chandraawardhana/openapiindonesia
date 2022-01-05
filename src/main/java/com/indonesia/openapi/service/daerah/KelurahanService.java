package com.indonesia.openapi.service.daerah;

import java.util.List;

import com.indonesia.openapi.model.daerah.Kelurahan;
import com.indonesia.openapi.repositori.daerah.KelurahanRepositori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class KelurahanService {
    
    @Autowired
    KelurahanRepositori kelurahanRepositori;

    public List <Kelurahan> findByAllKelurahan () {
        return kelurahanRepositori.findAll();
    }

    public Page <Kelurahan> findByAllKelurahanPage (Pageable pageable) {
        return kelurahanRepositori.findAll(pageable);
    }

    public List <Kelurahan> getByKecamatan (String id) {
        return kelurahanRepositori.findByIdkec(id);
    }

    public Page <Kelurahan> getByKecamatanPage (String idkec, Pageable pageable) {
        return kelurahanRepositori.findByIdkec(idkec, pageable);
    }

    public List <Kelurahan> getByNamaAndIdKecamatan (String nama, String idkec) {
        return kelurahanRepositori.findByNamaIgnoreCaseContainingAndIdkec(nama, idkec);
    }

    public Page <Kelurahan> getByNamaAndIdKecamatanPage (String nama, String idkec, Pageable pageable) {
        return kelurahanRepositori.findByNamaIgnoreCaseContainingAndIdkec(nama, idkec, pageable);
    }


    public List <Kelurahan> getByNama (String nama) {
        return kelurahanRepositori.findByNamaIgnoreCaseContaining(nama);
    }

    public Page <Kelurahan> getByNamaPage (String nama, Pageable pageable) {
        return kelurahanRepositori.findByNamaIgnoreCaseContaining(nama, pageable);
    }
}
