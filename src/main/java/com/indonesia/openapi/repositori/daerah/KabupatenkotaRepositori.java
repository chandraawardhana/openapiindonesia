package com.indonesia.openapi.repositori.daerah;

import java.util.List;

import com.indonesia.openapi.model.daerah.Kabupatenkota;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KabupatenkotaRepositori extends JpaRepository<Kabupatenkota, Integer> {
    List<Kabupatenkota> findByNamaIgnoreCaseContaining (String nama);
    List<Kabupatenkota> findByIdprov (String idProv);
    List<Kabupatenkota> findByNamaIgnoreCaseContainingAndIdprov (String nama, String idProv);

    Page<Kabupatenkota> findByNamaIgnoreCaseContaining (String nama, Pageable pageable);
    Page<Kabupatenkota> findByIdprov (String idProv, Pageable pageable);
    Page<Kabupatenkota> findByNamaIgnoreCaseContainingAndIdprov (String nama, String idProv, Pageable pageable);
}

    

