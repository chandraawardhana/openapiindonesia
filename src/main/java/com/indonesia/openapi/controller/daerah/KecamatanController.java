package com.indonesia.openapi.controller.daerah;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indonesia.openapi.dto.daerah.payload.Response.KecamatanResponse;
import com.indonesia.openapi.help.AppResponeUtil;
import com.indonesia.openapi.help.ResponeUtil;
import com.indonesia.openapi.model.daerah.Kecamatan;
import com.indonesia.openapi.service.daerah.KecamatanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kecamatan")
public class KecamatanController {

    @Autowired
    KecamatanService kecamatanService;

    @GetMapping("/list/all")
    public ResponseEntity<?> getAllKabupatenKota() {

        List<KecamatanResponse> listKecamatan = new ArrayList<KecamatanResponse>();
        List<Kecamatan> list = kecamatanService.findAllKecamatan();
        for (Kecamatan kecamatan : list) {
            KecamatanResponse kecamatanResponse = new KecamatanResponse();
            kecamatanResponse.setIdKec(kecamatan.getId());
            kecamatanResponse.setNamaKec(kecamatan.getNama());
            kecamatanResponse.setIdKab(kecamatan.getKabupatenkota().getId());
            kecamatanResponse.setNamaKab(kecamatan.getKabupatenkota().getNama());
            kecamatanResponse.setIdProv(kecamatan.getKabupatenkota().getProvinsi().getId());
            kecamatanResponse.setNamaProv(kecamatan.getKabupatenkota().getProvinsi().getNama());
            listKecamatan.add(kecamatanResponse);
        }
        return new ResponseEntity<>(listKecamatan, HttpStatus.OK);
    }

    @PostMapping("/page/all")
    public ResponseEntity<?> getAllKecamatan(@RequestBody Map map) {
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");

        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kecamatan> page = kecamatanService.findAllKecamatanPage(paging);
        List<Kecamatan> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        } else {
            pageSizeAll = page.getSize();
        }

        List<KecamatanResponse> listKecamatan = new ArrayList<KecamatanResponse>();
        for (Kecamatan kecamatan : list) {
            KecamatanResponse kecamatanResponse = new KecamatanResponse();
            kecamatanResponse.setIdKec(kecamatan.getId());
            kecamatanResponse.setNamaKec(kecamatan.getNama());
            kecamatanResponse.setIdKab(kecamatan.getKabupatenkota().getId());
            kecamatanResponse.setNamaKab(kecamatan.getKabupatenkota().getNama());
            kecamatanResponse.setIdProv(kecamatan.getKabupatenkota().getProvinsi().getId());
            kecamatanResponse.setNamaProv(kecamatan.getKabupatenkota().getProvinsi().getNama());
            listKecamatan.add(kecamatanResponse);
        }

        mapResponse.put("list", listKecamatan);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/ByIdKabupaten")
    public ResponseEntity<?> getAllByIdKabupaten(@RequestBody Map map) {

        List<KecamatanResponse> listKecamatan = new ArrayList<KecamatanResponse>();
        List<Kecamatan> list = kecamatanService.getByKabupaten(map.get("idKab").toString());
        for (Kecamatan kecamatan : list) {
            KecamatanResponse kecamatanResponse = new KecamatanResponse();
            kecamatanResponse.setIdKec(kecamatan.getId());
            kecamatanResponse.setNamaKec(kecamatan.getNama());
            kecamatanResponse.setIdKab(kecamatan.getKabupatenkota().getId());
            kecamatanResponse.setNamaKab(kecamatan.getKabupatenkota().getNama());
            kecamatanResponse.setIdProv(kecamatan.getKabupatenkota().getProvinsi().getId());
            kecamatanResponse.setNamaProv(kecamatan.getKabupatenkota().getProvinsi().getNama());
            listKecamatan.add(kecamatanResponse);
        }

        return new ResponseEntity<>(listKecamatan, HttpStatus.OK);
    }

    @PostMapping("/page/ByIdKabupaten")
    public ResponseEntity<?> getAllByIdKabupatenPage(@RequestBody Map map) {
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");

        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kecamatan> page = kecamatanService.getByKabupatenPage(map.get("idKab").toString(), paging);
        List<Kecamatan> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        } else {
            pageSizeAll = page.getSize();
        }

        List<KecamatanResponse> listKecamatan = new ArrayList<KecamatanResponse>();
        for (Kecamatan kecamatan : list) {
            KecamatanResponse kecamatanResponse = new KecamatanResponse();
            kecamatanResponse.setIdKec(kecamatan.getId());
            kecamatanResponse.setNamaKec(kecamatan.getNama());
            kecamatanResponse.setIdKab(kecamatan.getKabupatenkota().getId());
            kecamatanResponse.setNamaKab(kecamatan.getKabupatenkota().getNama());
            kecamatanResponse.setIdProv(kecamatan.getKabupatenkota().getProvinsi().getId());
            kecamatanResponse.setNamaProv(kecamatan.getKabupatenkota().getProvinsi().getNama());
            listKecamatan.add(kecamatanResponse);
        }

        mapResponse.put("list", listKecamatan);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

    @PostMapping("/list/ByNamaAndIdKabupaten")
    public ResponseEntity<?> getAllByNamaAndIdKabupaten(@RequestBody Map map) {

        List<KecamatanResponse> listKecamatan = new ArrayList<KecamatanResponse>();
        List<Kecamatan> list = kecamatanService.getByNamaAndIdKabupaten(map.get("namaKec").toString(),
                map.get("idKab").toString());
        for (Kecamatan kecamatan : list) {
            KecamatanResponse kecamatanResponse = new KecamatanResponse();
            kecamatanResponse.setIdKec(kecamatan.getId());
            kecamatanResponse.setNamaKec(kecamatan.getNama());
            kecamatanResponse.setIdKab(kecamatan.getKabupatenkota().getId());
            kecamatanResponse.setNamaKab(kecamatan.getKabupatenkota().getNama());
            kecamatanResponse.setIdProv(kecamatan.getKabupatenkota().getProvinsi().getId());
            kecamatanResponse.setNamaProv(kecamatan.getKabupatenkota().getProvinsi().getNama());
            listKecamatan.add(kecamatanResponse);
        }
        return new ResponseEntity<>(listKecamatan, HttpStatus.OK);
    }

    @PostMapping("/page/ByNamaAndIdKabupaten")
    public ResponseEntity<?> getAllByNamaAndIdKabupatenPage(@RequestBody Map map) {
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kecamatan> page = kecamatanService.getByNamaAndIdKabupatenPage(map.get("nama").toString(),
                map.get("idKab").toString(), paging);
        List<Kecamatan> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        } else {
            pageSizeAll = page.getSize();
        }

        List<KecamatanResponse> listKecamatan = new ArrayList<KecamatanResponse>();
        for (Kecamatan kecamatan : list) {
            KecamatanResponse kecamatanResponse = new KecamatanResponse();
            kecamatanResponse.setIdKec(kecamatan.getId());
            kecamatanResponse.setNamaKec(kecamatan.getNama());
            kecamatanResponse.setIdKab(kecamatan.getKabupatenkota().getId());
            kecamatanResponse.setNamaKab(kecamatan.getKabupatenkota().getNama());
            kecamatanResponse.setIdProv(kecamatan.getKabupatenkota().getProvinsi().getId());
            kecamatanResponse.setNamaProv(kecamatan.getKabupatenkota().getProvinsi().getNama());
            listKecamatan.add(kecamatanResponse);
        }

        mapResponse.put("list", listKecamatan);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);

    }

    @PostMapping("/list/ByNama")
    public ResponseEntity<?> getAllByNama(@RequestBody Map map) {

        List<KecamatanResponse> listKecamatan = new ArrayList<KecamatanResponse>();
        List<Kecamatan> list = kecamatanService.getByNama(map.get("namaKec").toString());
        for (Kecamatan kecamatan : list) {
            KecamatanResponse kecamatanResponse = new KecamatanResponse();
            kecamatanResponse.setIdKec(kecamatan.getId());
            kecamatanResponse.setNamaKec(kecamatan.getNama());
            kecamatanResponse.setIdKab(kecamatan.getKabupatenkota().getId());
            kecamatanResponse.setNamaKab(kecamatan.getKabupatenkota().getNama());
            kecamatanResponse.setIdProv(kecamatan.getKabupatenkota().getProvinsi().getId());
            kecamatanResponse.setNamaProv(kecamatan.getKabupatenkota().getProvinsi().getNama());
            listKecamatan.add(kecamatanResponse);
        }

        return new ResponseEntity<>(listKecamatan, HttpStatus.OK);
    }

    @PostMapping("/page/ByNama")
    public ResponseEntity<?> getAllByNamaPage(@RequestBody Map map) {
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE
                : (int) map.get("pageSize");

        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) - 1, pageSize);

        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<Kecamatan> page = kecamatanService.getByNamaPage(map.get("nama").toString(), paging);
        List<Kecamatan> list = page.getContent();

        if (map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        } else {
            pageSizeAll = page.getSize();
        }

        List<KecamatanResponse> listKecamatan = new ArrayList<KecamatanResponse>();
        for (Kecamatan kecamatan : list) {
            KecamatanResponse kecamatanResponse = new KecamatanResponse();
            kecamatanResponse.setIdKec(kecamatan.getId());
            kecamatanResponse.setNamaKec(kecamatan.getNama());
            kecamatanResponse.setIdKab(kecamatan.getKabupatenkota().getId());
            kecamatanResponse.setNamaKab(kecamatan.getKabupatenkota().getNama());
            kecamatanResponse.setIdProv(kecamatan.getKabupatenkota().getProvinsi().getId());
            kecamatanResponse.setNamaProv(kecamatan.getKabupatenkota().getProvinsi().getNama());
            listKecamatan.add(kecamatanResponse);
        }

        mapResponse.put("list", listKecamatan);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

}
