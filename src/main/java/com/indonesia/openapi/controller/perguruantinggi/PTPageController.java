package com.indonesia.openapi.controller.perguruantinggi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indonesia.openapi.help.AppResponeUtil;
import com.indonesia.openapi.help.ResponeUtil;
import com.indonesia.openapi.model.perguruantinggi.perguruantinggi;
import com.indonesia.openapi.service.perguruantinggi.PTService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/perguruantinggi")
public class PTPageController {

    @Autowired
    PTService ptService;


    @PostMapping("/page/nama")
    public ResponseEntity<?> pageByNama(@RequestBody Map map){
       
        Integer pageSize =  map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString())  - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<perguruantinggi> page = ptService.getPTNamaPage(map.get("nama").toString(), paging);
        List<perguruantinggi> list = page.getContent();

        if(map.get("pageSize").toString().equals("0")) {
			pageSizeAll = 0;
		}else {
			pageSizeAll = page.getSize();
		}
        mapResponse.put("list", list);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

    @PostMapping("/page/provinsi")
    public ResponseEntity<?> pageByProvinsi(@RequestBody Map map){
       
        Integer pageSize =  map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString())  - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<perguruantinggi> page = ptService.getPTProvinsiPage(map.get("provinsi").toString(), paging);
        List<perguruantinggi> list = page.getContent();

        if(map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        }else {
            pageSizeAll = page.getSize();
        }
        mapResponse.put("list", list);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);

    }

    @PostMapping("/page/kabupatenkota")
    public ResponseEntity<?> pageByKabupatenkota(@RequestBody Map map){
       
        Integer pageSize =  map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString())  - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<perguruantinggi> page = ptService.getPTKabupatenkotaPage(map.get("kabupatenkota").toString(), paging);
        List<perguruantinggi> list = page.getContent();

        if(map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        }else {
            pageSizeAll = page.getSize();
        }
        mapResponse.put("list", list);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);

    }

    @PostMapping("/page/namadanprovinsi")
    public ResponseEntity<?> pageByNamadanProvinsi(@RequestBody Map map){
       
        Integer pageSize =  map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString())  - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<perguruantinggi> page = ptService.getPTNamaProvinsiPage(map.get("nama").toString(), map.get("provinsi").toString(), paging);
        List<perguruantinggi> list = page.getContent();

        if(map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        }else {
            pageSizeAll = page.getSize();
        }
        mapResponse.put("list", list);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);

    }

    @PostMapping("/page/namadankabupatenkota")
    public ResponseEntity<?> pageByNamadankabupatenkota(@RequestBody Map map){
       
        Integer pageSize =  map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString())  - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<perguruantinggi> page = ptService.getPTNamaKabupatenkotaPage(map.get("nama").toString(), map.get("kabupatenkota").toString(), paging);
        List<perguruantinggi> list = page.getContent();

        if(map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        }else {
            pageSizeAll = page.getSize();
        }
        mapResponse.put("list", list);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);

    }

    @PostMapping("/page/provinsikabupatenkota")
    public ResponseEntity<?> pageByProvinsikabupatenkota(@RequestBody Map map){
        Integer pageSize =  map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString())  - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<perguruantinggi> page = ptService.getPTProvinsiKabupatenkotaPage(map.get("provinsi").toString(), map.get("kabupatenkota").toString(), paging);
        List<perguruantinggi> list = page.getContent();
        
        if(map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        }else {
            pageSizeAll = page.getSize();
        }
        mapResponse.put("list", list);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

    @PostMapping("/page/namaprovinsikabupatenkota")
    public ResponseEntity<?> pageByNamaprovinsikabupatenkota(@RequestBody Map map){
        Integer pageSize =  map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString())  - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<perguruantinggi> page = ptService.getPTNamaProvinsiKabupatenkotaPage(map.get("nama").toString(), map.get("provinsi").toString(), map.get("kabupatenkota").toString(), paging);
        List<perguruantinggi> list = page.getContent();

        if(map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        }else {
            pageSizeAll = page.getSize();
        }
        mapResponse.put("list", list);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }

    @PostMapping ("/page/all")
    public ResponseEntity<?> pageAll(@RequestBody Map map){
        Integer pageSize =  map.get("pageSize").equals(AppResponeUtil.allContentPageValue) ? Integer.MAX_VALUE : (int) map.get("pageSize");
        Pageable paging = PageRequest.of(Integer.parseInt(map.get("page").toString())  - 1, pageSize);
        Integer pageSizeAll = null;
        Map<String, Object> mapResponse = new HashMap<String, Object>();

        Page<perguruantinggi> page = ptService.findAll(paging);
        List<perguruantinggi> list = page.getContent();

        if(map.get("pageSize").toString().equals("0")) {
            pageSizeAll = 0;
        }else {
            pageSizeAll = page.getSize();
        }
        mapResponse.put("list", list);
        mapResponse.put("currentPage", page.getNumber() + 1);
        mapResponse.put("totalItem", page.getTotalElements());
        mapResponse.put("totalPage", page.getTotalPages());
        mapResponse.put("pageSize", pageSizeAll);
        return new ResponseEntity<>(ResponeUtil.Respone("200", mapResponse, "OK"), HttpStatus.OK);
    }
}
