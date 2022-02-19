package com.indonesia.openapi.controller.daerah;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indonesia.openapi.dto.daerah.payload.Request.KabupatenReques;
import com.indonesia.openapi.dto.daerah.payload.Response.KabupatenResponse;
import com.indonesia.openapi.help.AppResponeUtil;
import com.indonesia.openapi.help.ResponeUtil;
import com.indonesia.openapi.model.daerah.Kabupatenkota;
import com.indonesia.openapi.repositori.daerah.KabupatenkotaRepositori;
import com.indonesia.openapi.repositori.daerah.ProvinsiRepositori;
import com.indonesia.openapi.service.daerah.ProvinsiService;
import com.indonesia.openapi.service.daerah.kabupatenkotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/kabupatenkota")
public class KabupatenKotaController {

    @Autowired
    kabupatenkotaService kabupatenkotaService;

    @Autowired
    ProvinsiService provinsiService;

    @Autowired
    KabupatenkotaRepositori kabupatenkotaRepositori;

    @Autowired
    ProvinsiRepositori provinsiRepositori;

    @GetMapping("/list/all")
    public ResponseEntity<?> getAllKabupatenKota() {

        List<KabupatenResponse> listKabupatenKota = new ArrayList<KabupatenResponse>();
        List<Kabupatenkota> listKabupatenKotaDB = kabupatenkotaService.findAllKabupatenkota();
        for (Kabupatenkota kabupatenkota : listKabupatenKotaDB) {
            KabupatenResponse kabupatenResponse = new KabupatenResponse();
            kabupatenResponse.setId(kabupatenkota.getId());
            kabupatenResponse.setNamaKabkota(kabupatenkota.getNama());
            kabupatenResponse.setIdProv(kabupatenkota.getProvinsi().getId());
            kabupatenResponse.setNamaProv(kabupatenkota.getProvinsi().getNama());
            listKabupatenKota.add(kabupatenResponse);
        }
        return new ResponseEntity<>(listKabupatenKota, HttpStatus.OK);
    }

    @PostMapping("/page/all")
    public ResponseEntity<?> pageByNama(@RequestBody Map map) {
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kabupatenkota> page = kabupatenkotaService.findAllKabupatenkotaPage(paging);
        List<Kabupatenkota> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        } else {
            pageSizeAll = page.getSize();
        }

        List<KabupatenResponse> listKabupatenKota = new ArrayList<KabupatenResponse>();
        for (Kabupatenkota kabupatenkota : list) {
            KabupatenResponse kabupatenResponse = new KabupatenResponse();
            kabupatenResponse.setId(kabupatenkota.getId());
            kabupatenResponse.setNamaKabkota(kabupatenkota.getNama());
            kabupatenResponse.setIdProv(kabupatenkota.getProvinsi().getId());
            kabupatenResponse.setNamaProv(kabupatenkota.getProvinsi().getNama());
            listKabupatenKota.add(kabupatenResponse);
        }

        mapResponse.put("list", listKabupatenKota);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/ByNama")
    public ResponseEntity<?> getAllKabupatenKotaByNama(@RequestBody Map map) {

        List<KabupatenResponse> listKabupatenKota = new ArrayList<KabupatenResponse>();
        List<Kabupatenkota> listKabupatenKotaDB = kabupatenkotaService.getByNama(map.get("nama").toString());
        for (Kabupatenkota kabupatenkota : listKabupatenKotaDB) {
            KabupatenResponse kabupatenResponse = new KabupatenResponse();
            kabupatenResponse.setId(kabupatenkota.getId());
            kabupatenResponse.setNamaKabkota(kabupatenkota.getNama());
            kabupatenResponse.setIdProv(kabupatenkota.getProvinsi().getId());
            kabupatenResponse.setNamaProv(kabupatenkota.getProvinsi().getNama());
            listKabupatenKota.add(kabupatenResponse);
        }
        return new ResponseEntity<>(listKabupatenKota, HttpStatus.OK);
    }

    @PostMapping("/page/ByNama")
    public ResponseEntity<?> getAllKabupatenKotaByNamaPage(@RequestBody Map map) {
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kabupatenkota> page = kabupatenkotaService.getByNamaPage(map.get("nama").toString(), paging);
        List<Kabupatenkota> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            mapResponse.put("pageSize", 0);
        } else {
            mapResponse.put("pageSize", page.getSize());
        }
        List<KabupatenResponse> listKabupatenKota = new ArrayList<KabupatenResponse>();
        for (Kabupatenkota kabupatenkota : list) {
            KabupatenResponse kabupatenResponse = new KabupatenResponse();
            kabupatenResponse.setId(kabupatenkota.getId());
            kabupatenResponse.setNamaKabkota(kabupatenkota.getNama());
            kabupatenResponse.setIdProv(kabupatenkota.getProvinsi().getId());
            kabupatenResponse.setNamaProv(kabupatenkota.getProvinsi().getNama());
            listKabupatenKota.add(kabupatenResponse);
        }
        mapResponse.put("list", listKabupatenKota);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/ByProvinsi")
    public ResponseEntity<?> findByProvinsi(@RequestBody KabupatenReques kabupatenReques) {

        List<KabupatenResponse> listKabupatenKota = new ArrayList<KabupatenResponse>();
        List<Kabupatenkota> listKabupatenKotaDB = kabupatenkotaService.getByProvinsi(kabupatenReques.getIdprov());
        for (Kabupatenkota kabupatenkota : listKabupatenKotaDB) {
            KabupatenResponse kabupatenResponse = new KabupatenResponse();
            kabupatenResponse.setId(kabupatenkota.getId());
            kabupatenResponse.setNamaKabkota(kabupatenkota.getNama());
            kabupatenResponse.setIdProv(kabupatenkota.getProvinsi().getId());
            kabupatenResponse.setNamaProv(kabupatenkota.getProvinsi().getNama());
            listKabupatenKota.add(kabupatenResponse);
        }
        return new ResponseEntity<>(listKabupatenKota, HttpStatus.OK);
    }

    @PostMapping("/page/ByProvinsi")
    public ResponseEntity<?> pageByIdProvinsi(@RequestBody Map map) {

        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);
        Integer pageSizeAll = null;

        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kabupatenkota> page = kabupatenkotaService.getByIdprovinsiPage(map.get("idprov").toString(), paging);
        List<Kabupatenkota> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        } else {
            pageSizeAll = page.getSize();
        }

        List<KabupatenResponse> listKabupatenKota = new ArrayList<KabupatenResponse>();
        for (Kabupatenkota kabupatenkota : list) {
            KabupatenResponse kabupatenResponse = new KabupatenResponse();
            kabupatenResponse.setId(kabupatenkota.getId());
            kabupatenResponse.setNamaKabkota(kabupatenkota.getNama());
            kabupatenResponse.setIdProv(kabupatenkota.getProvinsi().getId());
            kabupatenResponse.setNamaProv(kabupatenkota.getProvinsi().getNama());
            listKabupatenKota.add(kabupatenResponse);
        }
        mapResponse.put("list", listKabupatenKota);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/ByNamaAndProvinsi")
    public ResponseEntity<?> findByNamaAndProvinsi(@RequestBody KabupatenReques kabupatenkotaReques) {

        List<KabupatenResponse> listKabupatenKota = new ArrayList<KabupatenResponse>();
        List<Kabupatenkota> listKabupatenKotaDB = kabupatenkotaService
                .getByNamaAndIdProvinsi(kabupatenkotaReques.getNamaKab(), kabupatenkotaReques.getIdprov());
        for (Kabupatenkota kabupatenkota : listKabupatenKotaDB) {
            KabupatenResponse kabupatenResponse = new KabupatenResponse();
            kabupatenResponse.setId(kabupatenkota.getId());
            kabupatenResponse.setNamaKabkota(kabupatenkota.getNama());
            kabupatenResponse.setIdProv(kabupatenkota.getProvinsi().getId());
            kabupatenResponse.setNamaProv(kabupatenkota.getProvinsi().getNama());
            listKabupatenKota.add(kabupatenResponse);
        }

        return new ResponseEntity<>(listKabupatenKota, HttpStatus.OK);
    }

    @PostMapping("/page/ByNamaAndProvinsi")
    public ResponseEntity<?> pageByNamaAndProvinsi(@RequestBody Map map) {

        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kabupatenkota> page = kabupatenkotaService.getByNamaAndaIdProvinsiPage(map.get("nama").toString(),
                map.get("idprov").toString(), paging);
        List<Kabupatenkota> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        } else {
            pageSizeAll = page.getSize();
        }

        List<KabupatenResponse> listKabupatenKota = new ArrayList<KabupatenResponse>();
        for (Kabupatenkota kabupatenkota : list) {
            KabupatenResponse kabupatenResponse = new KabupatenResponse();
            kabupatenResponse.setId(kabupatenkota.getId());
            kabupatenResponse.setNamaKabkota(kabupatenkota.getNama());
            kabupatenResponse.setIdProv(kabupatenkota.getProvinsi().getId());
            kabupatenResponse.setNamaProv(kabupatenkota.getProvinsi().getNama());
            listKabupatenKota.add(kabupatenResponse);
        }

        mapResponse.put("list", listKabupatenKota);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

}
