package com.indonesia.openapi.controller.perguruantinggi;

import java.util.HashMap;
import java.util.Map;

import com.indonesia.openapi.help.ResponeUtil;
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
@RequestMapping("/api/v1/perguruantinggi")
public class PTController {

    @Autowired
    PTService ptService;

    @GetMapping("/list/all")
    public ResponseEntity<?> getAllPerguruanTinggi(){
        Map map = new HashMap();
        map.put("list", ptService.findAll());
        return new ResponseEntity<>(ResponeUtil.Respone("200", map, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/nama")
    public ResponseEntity<?> findByNama(@RequestBody perguruantinggi Perguruantinggi){
        Map map = new HashMap();
        map.put("list", ptService.getPTNama(Perguruantinggi.getNama()));
        return new ResponseEntity<>(ResponeUtil.Respone("200", map, "OK"), HttpStatus.OK);
    }

    
    @PostMapping("/list/provinsi")
    public ResponseEntity<?> findByprovinsi(@RequestBody perguruantinggi Perguruantinggi){
        Map map = new HashMap();
        map.put("list", ptService.getPTProvinsi(Perguruantinggi.getProvinsi()));
        return new ResponseEntity<>(ResponeUtil.Respone("200", map, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/kabupatenkota")
    public ResponseEntity<?> findByKabupatenkota(@RequestBody perguruantinggi Perguruantinggi){
        Map map = new HashMap();
        map.put("list", ptService.getPTKabupatenkota(Perguruantinggi.getKabupatenkota()));
        return new ResponseEntity<>(ResponeUtil.Respone("200", map, "OK"), HttpStatus.OK);
    }
    
    @PostMapping("/list/namadanprovinsi")
    public ResponseEntity<?> findByNamaProvinsi(@RequestBody perguruantinggi Perguruantinggi){
        Map map = new HashMap();
        map.put("list", ptService.getPTNamaProvinsi( Perguruantinggi.getNama(), Perguruantinggi.getProvinsi()));
        return new ResponseEntity<>(ResponeUtil.Respone("200", map, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/namadankabupatenkota")
    public ResponseEntity<?> findByNamaKabupatenkota(@RequestBody perguruantinggi Perguruantinggi){
        Map map = new HashMap();
        map.put("list", ptService.getPTNamaKabupatenkota(Perguruantinggi.getNama(), Perguruantinggi.getKabupatenkota()));
        return new ResponseEntity<>(ResponeUtil.Respone("200", map, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/provinsikabupatenkota")
    public ResponseEntity<?> findByProvinsiKabupatenkota(@RequestBody perguruantinggi Perguruantinggi){
        Map map = new HashMap();
        map.put("list", ptService.getPTProvinsiKabupatenkota(Perguruantinggi.getProvinsi(), Perguruantinggi.getKabupatenkota()));
        return new ResponseEntity<>(ResponeUtil.Respone("200", map, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/namaprovinsikabupatenkota")
    public ResponseEntity<?> findByNamaProvinsiKabupatenkota(@RequestBody perguruantinggi Perguruantinggi){
        Map map = new HashMap();
        map.put("list", ptService.getPTNamaProvinsiKabupatenkota(Perguruantinggi.getNama(), Perguruantinggi.getProvinsi(), Perguruantinggi.getKabupatenkota()));
        return new ResponseEntity<>(ResponeUtil.Respone("200", map, "OK"), HttpStatus.OK);
    }

}
