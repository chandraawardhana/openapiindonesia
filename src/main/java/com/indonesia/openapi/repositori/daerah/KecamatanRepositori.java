package com.indonesia.openapi.repositori.daerah;

import java.util.List;

import com.indonesia.openapi.model.daerah.Kecamatan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KecamatanRepositori extends JpaRepository <Kecamatan, Long> {
    List<Kecamatan> findByIdkab (String idkab);
    List<Kecamatan> findByNamaIgnoreCaseContaining(String nama);
    List<Kecamatan> findByNamaIgnoreCaseContainingAndIdkab(String nama, String idkab);
    
    Page<Kecamatan> findByNamaIgnoreCaseContainingAndIdkab(String nama,String idkab, Pageable pageable);
    Page<Kecamatan> findByNamaIgnoreCaseContaining(String nama, Pageable pageable);
    Page<Kecamatan> findByIdkab (String idkab, Pageable pageable);
}

    

