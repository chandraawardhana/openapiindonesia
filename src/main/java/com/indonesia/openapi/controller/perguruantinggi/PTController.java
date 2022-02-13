package com.indonesia.openapi.controller.perguruantinggi;

import java.util.List;
import com.indonesia.openapi.model.perguruantinggi.perguruantinggi;
import com.indonesia.openapi.service.perguruantinggi.PTService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/perguruantinggi")
public class PTController {

    @Autowired
    PTService ptService;

    @GetMapping("/list/all")
    public ResponseEntity<?> getAllPerguruanTinggi(){
        List<perguruantinggi> list = ptService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/list/nama")
    public ResponseEntity<?> findByNama(@RequestBody perguruantinggi Perguruantinggi){
        List<perguruantinggi> list =  ptService.getPTNama(Perguruantinggi.getNama());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    
    @PostMapping("/list/provinsi")
    public ResponseEntity<?> findByprovinsi(@RequestBody perguruantinggi Perguruantinggi){
        List<perguruantinggi> list = ptService.getPTProvinsi(Perguruantinggi.getProvinsi());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/list/kabupatenkota")
    public ResponseEntity<?> findByKabupatenkota(@RequestBody perguruantinggi Perguruantinggi){
        List<perguruantinggi> list = ptService.getPTKabupatenkota(Perguruantinggi.getKabupatenkota());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping("/list/namadanprovinsi")
    public ResponseEntity<?> findByNamaProvinsi(@RequestBody perguruantinggi Perguruantinggi){
        List<perguruantinggi> list = ptService.getPTNamaProvinsi( Perguruantinggi.getNama(), Perguruantinggi.getProvinsi());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/list/namadankabupatenkota")
    public ResponseEntity<?> findByNamaKabupatenkota(@RequestBody perguruantinggi Perguruantinggi){
        List<perguruantinggi> list = ptService.getPTNamaKabupatenkota(Perguruantinggi.getNama(), Perguruantinggi.getKabupatenkota());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/list/provinsikabupatenkota")
    public ResponseEntity<?> findByProvinsiKabupatenkota(@RequestBody perguruantinggi Perguruantinggi){
        List<perguruantinggi> list = ptService.getPTProvinsiKabupatenkota(Perguruantinggi.getProvinsi(), Perguruantinggi.getKabupatenkota());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/list/namaprovinsikabupatenkota")
    public ResponseEntity<?> findByNamaProvinsiKabupatenkota(@RequestBody perguruantinggi Perguruantinggi){
        List<perguruantinggi> list = ptService.getPTNamaProvinsiKabupatenkota(Perguruantinggi.getNama(), Perguruantinggi.getProvinsi(), Perguruantinggi.getKabupatenkota());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
