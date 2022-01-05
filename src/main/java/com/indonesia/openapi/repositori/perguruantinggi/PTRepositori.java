package com.indonesia.openapi.repositori.perguruantinggi;
import java.util.List;

import com.indonesia.openapi.model.perguruantinggi.perguruantinggi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PTRepositori extends JpaRepository<perguruantinggi, Integer> {
    List<perguruantinggi> findByNamaIgnoreCaseContaining(String nama);
    List<perguruantinggi> findByProvinsiIgnoreCaseContaining(String provinsi);
    List<perguruantinggi> findByKabupatenkotaIgnoreCaseContaining(String kabupatenkota);
    List<perguruantinggi> findByNamaIgnoreCaseContainingAndProvinsiIgnoreCaseContaining(String nama, String provinsi);
    List<perguruantinggi> findByNamaIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(String nama, String kabupatenkota);
    List<perguruantinggi> findByProvinsiIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(String provinsi, String kabupatenkota);
    List<perguruantinggi> findByNamaIgnoreCaseContainingAndProvinsiIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(String nama, String provinsi, String kabupatenkota);

    Page<perguruantinggi> findByNamaIgnoreCaseContaining(String nama, Pageable pageable);
    Page<perguruantinggi> findByProvinsiIgnoreCaseContaining(String provinsi, Pageable pageable);
    Page<perguruantinggi> findByKabupatenkotaIgnoreCaseContaining(String kabupatenkota, Pageable pageable);
    Page<perguruantinggi> findByNamaIgnoreCaseContainingAndProvinsiIgnoreCaseContaining(String nama, String provinsi, Pageable pageable);
    Page<perguruantinggi> findByNamaIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(String nama, String kabupatenkota, Pageable pageable);
    Page<perguruantinggi> findByProvinsiIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(String provinsi, String kabupatenkota, Pageable pageable);
    Page<perguruantinggi> findByNamaIgnoreCaseContainingAndProvinsiIgnoreCaseContainingAndKabupatenkotaIgnoreCaseContaining(String nama, String provinsi, String kabupatenkota, Pageable pageable);
}




