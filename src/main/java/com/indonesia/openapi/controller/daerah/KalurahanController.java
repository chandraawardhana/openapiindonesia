package com.indonesia.openapi.controller.daerah;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indonesia.openapi.dto.daerah.payload.Response.KelurahanResponse;
import com.indonesia.openapi.help.AppResponeUtil;
import com.indonesia.openapi.help.ResponeUtil;
import com.indonesia.openapi.model.daerah.Kelurahan;
import com.indonesia.openapi.service.daerah.KelurahanService;

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
@RequestMapping("/v1/kelurahan")
public class KalurahanController {

    @Autowired
    KelurahanService kelurahanService;

    @GetMapping("/list/all")
    public ResponseEntity<?> getAllKelurahan() {

        List<KelurahanResponse> listKel = new ArrayList<KelurahanResponse>();
        List<Kelurahan> listKelurahanDB = kelurahanService.findByAllKelurahan();
        for (Kelurahan kelurahan : listKelurahanDB) {
            KelurahanResponse kelurahanResponse = new KelurahanResponse();
            kelurahanResponse.setIdKel(kelurahan.getId());
            kelurahanResponse.setNamaKel(kelurahan.getNama());
            kelurahanResponse.setIdKec(kelurahan.getKecamatan().getId());
            kelurahanResponse.setNamaKec(kelurahan.getKecamatan().getNama());
            kelurahanResponse.setIdKab(kelurahan.getKecamatan().getKabupatenkota().getId());
            kelurahanResponse.setNamaKab(kelurahan.getKecamatan().getKabupatenkota().getNama());
            kelurahanResponse.setIdProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getId());
            kelurahanResponse.setNamaProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getNama());
            listKel.add(kelurahanResponse);
        }
        return new ResponseEntity<>(listKel, HttpStatus.OK);
    }

    @PostMapping("/page/all")
    public ResponseEntity<?> getAllKelurahanPage(@RequestBody Map map) {
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");

        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kelurahan> page = kelurahanService.findByAllKelurahanPage(paging);
        List<Kelurahan> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        } else {
            pageSizeAll = page.getSize();
        }

        List<KelurahanResponse> listKel = new ArrayList<KelurahanResponse>();
        for (Kelurahan kelurahan : list) {
            KelurahanResponse kelurahanResponse = new KelurahanResponse();
            kelurahanResponse.setIdKel(kelurahan.getId());
            kelurahanResponse.setNamaKel(kelurahan.getNama());
            kelurahanResponse.setIdKec(kelurahan.getKecamatan().getId());
            kelurahanResponse.setNamaKec(kelurahan.getKecamatan().getNama());
            kelurahanResponse.setIdKab(kelurahan.getKecamatan().getKabupatenkota().getId());
            kelurahanResponse.setNamaKab(kelurahan.getKecamatan().getKabupatenkota().getNama());
            kelurahanResponse.setIdProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getId());
            kelurahanResponse.setNamaProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getNama());
            listKel.add(kelurahanResponse);
        }

        mapResponse.put("list", listKel);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);

    }

    @PostMapping("/list/ByIdKecamatan")
    public ResponseEntity<?> getAllKelurahanByIdKelurahan(@RequestBody Map map) {

        List<KelurahanResponse> listKel = new ArrayList<KelurahanResponse>();
        List<Kelurahan> listKelurahanDB = kelurahanService.getByKecamatan(map.get("idKec").toString());
        for (Kelurahan kelurahan : listKelurahanDB) {
            KelurahanResponse kelurahanResponse = new KelurahanResponse();
            kelurahanResponse.setIdKel(kelurahan.getId());
            kelurahanResponse.setNamaKel(kelurahan.getNama());
            kelurahanResponse.setIdKec(kelurahan.getKecamatan().getId());
            kelurahanResponse.setNamaKec(kelurahan.getKecamatan().getNama());
            kelurahanResponse.setIdKab(kelurahan.getKecamatan().getKabupatenkota().getId());
            kelurahanResponse.setNamaKab(kelurahan.getKecamatan().getKabupatenkota().getNama());
            kelurahanResponse.setIdProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getId());
            kelurahanResponse.setNamaProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getNama());
            listKel.add(kelurahanResponse);
        }

        return new ResponseEntity<>(listKel, HttpStatus.OK);
    }

    @PostMapping("/page/ByIdKecamatan")
    public ResponseEntity<?> getAllKelurahanPageByIdKecamatan(@RequestBody Map map) {
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");

        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kelurahan> page = kelurahanService.getByKecamatanPage(map.get("idKec").toString(), paging);
        List<Kelurahan> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        } else {
            pageSizeAll = page.getSize();
        }

        List<KelurahanResponse> listKel = new ArrayList<KelurahanResponse>();
        for (Kelurahan kelurahan : list) {
            KelurahanResponse kelurahanResponse = new KelurahanResponse();
            kelurahanResponse.setIdKel(kelurahan.getId());
            kelurahanResponse.setNamaKel(kelurahan.getNama());
            kelurahanResponse.setIdKec(kelurahan.getKecamatan().getId());
            kelurahanResponse.setNamaKec(kelurahan.getKecamatan().getNama());
            kelurahanResponse.setIdKab(kelurahan.getKecamatan().getKabupatenkota().getId());
            kelurahanResponse.setNamaKab(kelurahan.getKecamatan().getKabupatenkota().getNama());
            kelurahanResponse.setIdProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getId());
            kelurahanResponse.setNamaProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getNama());
            listKel.add(kelurahanResponse);
        }

        mapResponse.put("list", listKel);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/ByNama")
    public ResponseEntity<?> getAllKelurahanByNama(@RequestBody Map map) {

        List<KelurahanResponse> listKel = new ArrayList<KelurahanResponse>();
        List<Kelurahan> listKelurahanDB = kelurahanService.getByNama(map.get("namaKel").toString());
        for (Kelurahan kelurahan : listKelurahanDB) {
            KelurahanResponse kelurahanResponse = new KelurahanResponse();
            kelurahanResponse.setIdKel(kelurahan.getId());
            kelurahanResponse.setNamaKel(kelurahan.getNama());
            kelurahanResponse.setIdKec(kelurahan.getKecamatan().getId());
            kelurahanResponse.setNamaKec(kelurahan.getKecamatan().getNama());
            kelurahanResponse.setIdKab(kelurahan.getKecamatan().getKabupatenkota().getId());
            kelurahanResponse.setNamaKab(kelurahan.getKecamatan().getKabupatenkota().getNama());
            kelurahanResponse.setIdProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getId());
            kelurahanResponse.setNamaProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getNama());
            listKel.add(kelurahanResponse);
        }
        return new ResponseEntity<>(listKel, HttpStatus.OK);
    }

    @PostMapping("/page/ByNama")
    public ResponseEntity<?> getAllKelurahanPageByNama(@RequestBody Map map) {
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");

        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kelurahan> page = kelurahanService.getByNamaPage(map.get("namaKel").toString(), paging);
        List<Kelurahan> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        } else {
            pageSizeAll = page.getSize();
        }

        List<KelurahanResponse> listKel = new ArrayList<KelurahanResponse>();
        for (Kelurahan kelurahan : list) {
            KelurahanResponse kelurahanResponse = new KelurahanResponse();
            kelurahanResponse.setIdKel(kelurahan.getId());
            kelurahanResponse.setNamaKel(kelurahan.getNama());
            kelurahanResponse.setIdKec(kelurahan.getKecamatan().getId());
            kelurahanResponse.setNamaKec(kelurahan.getKecamatan().getNama());
            kelurahanResponse.setIdKab(kelurahan.getKecamatan().getKabupatenkota().getId());
            kelurahanResponse.setNamaKab(kelurahan.getKecamatan().getKabupatenkota().getNama());
            kelurahanResponse.setIdProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getId());
            kelurahanResponse.setNamaProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getNama());
            listKel.add(kelurahanResponse);
        }

        mapResponse.put("list", listKel);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/ByNamaAndIdKecamatan")
    public ResponseEntity<?> getAllKelurahanByNamaAndIdKecamatan(@RequestBody Map map) {

        List<KelurahanResponse> listKel = new ArrayList<KelurahanResponse>();
        List<Kelurahan> listKelurahanDB = kelurahanService.getByNamaAndIdKecamatan(map.get("namaKel").toString(),
                map.get("idKec").toString());
        for (Kelurahan kelurahan : listKelurahanDB) {
            KelurahanResponse kelurahanResponse = new KelurahanResponse();
            kelurahanResponse.setIdKel(kelurahan.getId());
            kelurahanResponse.setNamaKel(kelurahan.getNama());
            kelurahanResponse.setIdKec(kelurahan.getKecamatan().getId());
            kelurahanResponse.setNamaKec(kelurahan.getKecamatan().getNama());
            kelurahanResponse.setIdKab(kelurahan.getKecamatan().getKabupatenkota().getId());
            kelurahanResponse.setNamaKab(kelurahan.getKecamatan().getKabupatenkota().getNama());
            kelurahanResponse.setIdProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getId());
            kelurahanResponse.setNamaProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getNama());
            listKel.add(kelurahanResponse);
        }
        return new ResponseEntity<>(listKel, HttpStatus.OK);
    }

    @PostMapping("/page/ByNamaAndIdKecamatan")
    public ResponseEntity<?> getAllKelurahanByNamaAndIdKecamatanPage(@RequestBody Map map) {
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");

        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kelurahan> page = kelurahanService.getByNamaAndIdKecamatanPage(map.get("namaKel").toString(),
                map.get("idKec").toString(), paging);
        List<Kelurahan> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        } else {
            pageSizeAll = page.getSize();
        }
        List<KelurahanResponse> listKel = new ArrayList<KelurahanResponse>();
        for (Kelurahan kelurahan : list) {
            KelurahanResponse kelurahanResponse = new KelurahanResponse();
            kelurahanResponse.setIdKel(kelurahan.getId());
            kelurahanResponse.setNamaKel(kelurahan.getNama());
            kelurahanResponse.setIdKec(kelurahan.getKecamatan().getId());
            kelurahanResponse.setNamaKec(kelurahan.getKecamatan().getNama());
            kelurahanResponse.setIdKab(kelurahan.getKecamatan().getKabupatenkota().getId());
            kelurahanResponse.setNamaKab(kelurahan.getKecamatan().getKabupatenkota().getNama());
            kelurahanResponse.setIdProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getId());
            kelurahanResponse.setNamaProv(kelurahan.getKecamatan().getKabupatenkota().getProvinsi().getNama());
            listKel.add(kelurahanResponse);
        }

        mapResponse.put("list", listKel);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

}
