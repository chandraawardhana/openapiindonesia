package com.indonesia.openapi.service.daerah;

import java.util.List;

import com.indonesia.openapi.model.daerah.Provinsi;
import com.indonesia.openapi.repositori.daerah.ProvinsiRepositori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProvinsiService {

    @Autowired
    ProvinsiRepositori provinsiRepositori;


    public List <Provinsi> findAllProvinsi() {
        return provinsiRepositori.findAll();
    }

    public List <Provinsi> findById(String id){
        return provinsiRepositori.findById(id);
    }

    public List <Provinsi> findByNamaProvinsi(String nama) {
        return provinsiRepositori.findByNamaIgnoreCaseContainingOrderByIdAsc(nama);
    }
    
    public Page <Provinsi> findByNamaProvinsiPage (String nama, Pageable pageable) {
        return provinsiRepositori.findByNamaIgnoreCaseContainingOrderByIdAsc(nama, pageable);
    }

    public Page <Provinsi> findByNamaProvinsiPageAll (Pageable pageable) {
        return provinsiRepositori.findAll(pageable);
    }
    
}
