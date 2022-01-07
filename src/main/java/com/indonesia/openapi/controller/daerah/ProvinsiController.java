package com.indonesia.openapi.controller.daerah;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indonesia.openapi.help.AppResponeUtil;
import com.indonesia.openapi.help.ResponeUtil;
import com.indonesia.openapi.model.daerah.Provinsi;
import com.indonesia.openapi.service.daerah.ProvinsiService;

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
@RequestMapping("/api/v1/provinsi")
public class ProvinsiController {

    @Autowired
    ProvinsiService provinsiService;

    @GetMapping("/list/all")
    public ResponseEntity<?> getAllProvinsi() {
        List<Provinsi> provinsi = provinsiService.findAllProvinsi();
        return new ResponseEntity<>(provinsi, HttpStatus.OK);
    }
    @PostMapping("/list/ByNama")
    public ResponseEntity<?> findProvinsiByNama(@RequestBody Provinsi Provinsi) {
        List<Provinsi> provinsi = provinsiService.findByNamaProvinsi(Provinsi.getNama());
        return new ResponseEntity<>(ResponeUtil.Respone("200", provinsi, "OK"), HttpStatus.OK);
    }

    @PostMapping("/page/ByNama")
    public ResponseEntity<?>  findProvinsiByNamaPage (@RequestBody Map map){
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE : (int) map.get("pageSize");

        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) -1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page <Provinsi> page = provinsiService.findByNamaProvinsiPage(map.get("nama").toString(), paging);
        List <Provinsi> list = page.getContent();

        if(map.get("pageSize").toString().equals("0")){
            pageSizeAll = 0;
        }else {
            pageSizeAll= page.getSize();
        }

        mapResponse.put("list", list);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

    @PostMapping("/page/all")
    public ResponseEntity<?>  findProvinsiAll (@RequestBody Map map){
        Integer pageSize = map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE : (int) map.get("pageSize");

        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString()) -1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page <Provinsi> page = provinsiService.findByNamaProvinsiPageAll(paging);
        List <Provinsi> list = page.getContent();

        if(map.get("pageSize").toString().equals("0")){
            pageSizeAll = 0;
        }else {
            pageSizeAll= page.getSize();
        }

        mapResponse.put("list", list);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }



    
}
