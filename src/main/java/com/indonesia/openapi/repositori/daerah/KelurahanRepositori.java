package com.indonesia.openapi.repositori.daerah;

import java.util.List;

import com.indonesia.openapi.model.daerah.Kelurahan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelurahanRepositori extends JpaRepository<Kelurahan, Long> {

    List<Kelurahan> findByNamaIgnoreCaseContaining (String nama);
    List<Kelurahan> findByIdkec (String idkec);
    List<Kelurahan> findByNamaIgnoreCaseContainingAndIdkec (String nama, String idkec);
   
    Page<Kelurahan> findByNamaIgnoreCaseContainingAndIdkec (String nama, String idkec, Pageable pageable);
    Page<Kelurahan> findByNamaIgnoreCaseContaining (String nama, Pageable pageable);
    Page<Kelurahan> findByIdkec (String id, Pageable pageable);
   }
