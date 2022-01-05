package com.indonesia.openapi.service.perguruantinggi;

import java.util.List;

import com.indonesia.openapi.model.perguruantinggi.perguruantinggi;
import com.indonesia.openapi.repositori.perguruantinggi.PTRepositori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PTService {

    @Autowired
    PTRepositori ptRepositori;

    public List<perguruantinggi> findAll() {
        return ptRepositori.findAll();
    }

    public Page<perguruantinggi> findAll(Pageable pageable) {
        return ptRepositori.findAll(pageable);
    }

    public List <perguruantinggi> getPTNama (String nama){
        return ptRepositori.findByNamaIgnoreCaseContaining(nama);
    }

    public Page<perguruantinggi> getPTNamaPage (String nama, Pageable pageable){
        return ptRepositori.findByNamaIgnoreCaseContaining(nama, pageable);
    }

    public List <perguruantinggi> getPTProvinsi (String provinsi){
        return ptRepositori.findByProvinsiIgnoreCaseContaining(provinsi);
    }
    public Page<perguruantinggi> getPTProvinsiPage (String provinsi, Pageable pageable){
        return ptRepositori.findByProvinsiIgnoreCaseContaining(provinsi, pageable);
    }

    public List <perguruantinggi> getPTKabupatenkota (String kabupatenkota){
        return ptRepositori.findByKabupatenkotaIgnoreCaseContaining(kabupatenkota);
    }

    public Page<perguruantinggi> getPTKabupatenkotaPage (String kabupatenkota, Pageable pageable){
        return ptRepositori.findByKabupatenkotaIgnoreCaseContaining(kabupatenkota, pageable);
    }

    public List <perguruantinggi> getPTNamaProvinsi (String nama, String provinsi){
        return ptRepositori.findByNamaIgnoreCaseContainingAndProvinsiIgnoreCaseContaining(nama, provinsi);
    }

    public Page <perguruantinggi> getPTNamaProvinsiPage (String nama, String provinsi, Pageable pageable){
        return ptRepositori.findByNamaIgnoreCaseContainingAndProvinsiIgnoreCaseContaining(nama, provinsi, pageable);
    }

    public List <perguruantinggi> getPTNamaKabupatenkota (String nama, String kabupatenkota){
        return ptRepositori.findByNamaIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(nama, kabupatenkota);
    }

    public Page <perguruantinggi> getPTNamaKabupatenkotaPage (String nama, String kabupatenkota, Pageable pageable){
        return ptRepositori.findByNamaIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(nama, kabupatenkota, pageable);
    }

    public List <perguruantinggi> getPTProvinsiKabupatenkota (String provinsi, String kabupatenkota){
        return ptRepositori.findByProvinsiIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(provinsi, kabupatenkota);
    }

    public Page <perguruantinggi> getPTProvinsiKabupatenkotaPage (String provinsi, String kabupatenkota, Pageable pageable){
        return ptRepositori.findByProvinsiIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(provinsi, kabupatenkota, pageable);
    }

    public List <perguruantinggi> getPTNamaProvinsiKabupatenkota (String nama, String provinsi, String kabupatenkota){
        return ptRepositori.findByNamaIgnoreCaseContainingAndProvinsiIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(nama, provinsi, kabupatenkota);
    }

    public Page <perguruantinggi> getPTNamaProvinsiKabupatenkotaPage (String nama, String provinsi, String kabupatenkota, Pageable pageable){
        return ptRepositori.findByNamaIgnoreCaseContainingAndProvinsiIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(nama, provinsi, kabupatenkota, pageable);
    }

   

    
}
