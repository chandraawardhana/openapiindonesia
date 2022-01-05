package com.indonesia.openapi.repositori.daerah;

import java.util.List;

import com.indonesia.openapi.model.daerah.Provinsi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProvinsiRepositori extends JpaRepository<Provinsi, Long> {
    List<Provinsi> findById(String id);
    List <Provinsi> findByNamaIgnoreCaseContainingOrderByIdAsc(String nama);
    Page<Provinsi> findByNamaIgnoreCaseContainingOrderByIdAsc(String nama, Pageable pageable);
    
}


    