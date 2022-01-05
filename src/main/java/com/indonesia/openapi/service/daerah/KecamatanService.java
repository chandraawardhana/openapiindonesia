package com.indonesia.openapi.service.daerah;

import java.util.List;

import com.indonesia.openapi.model.daerah.Kecamatan;
import com.indonesia.openapi.repositori.daerah.KecamatanRepositori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KecamatanService {

    @Autowired
    private KecamatanRepositori kecamatanRepositori;

    public List <Kecamatan> findAllKecamatan() {
        return kecamatanRepositori.findAll();
    }

    public Page <Kecamatan> findAllKecamatanPage (Pageable pageable) {
        return kecamatanRepositori.findAll(pageable);
    }

    public List <Kecamatan> getByKabupaten (String idkab) {
        return kecamatanRepositori.findByIdkab(idkab);
    }

    public Page <Kecamatan> getByKabupatenPage (String idkab, Pageable pageable) {
        return kecamatanRepositori.findByIdkab(idkab, pageable);
    }

    public List <Kecamatan> getByNamaAndIdKabupaten (String nama, String idkab) {
        return kecamatanRepositori.findByNamaIgnoreCaseContainingAndIdkab(nama, idkab);
    }
    public Page <Kecamatan> getByNamaAndIdKabupatenPage (String nama, String idkab, Pageable pageable) {
        return kecamatanRepositori.findByNamaIgnoreCaseContainingAndIdkab(nama, idkab, pageable);
    }

    public List <Kecamatan> getByNama (String nama) {
        return kecamatanRepositori.findByNamaIgnoreCaseContaining(nama);
    }

    public Page <Kecamatan> getByNamaPage (String nama, Pageable pageable) {
        return kecamatanRepositori.findByNamaIgnoreCaseContaining(nama, pageable);
    }


    

    
}
