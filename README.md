# Openapi Indonesia
Openapi Indonesia adalah Servis opensouce yang saya buat untuk digunakan oleh semua kalangan, baik developer maupun perusahaan yang dimana data yang saya gunakan juga merupakan data yang dapat diakses oleh publik. 
Terdapat beberapa service seperti 
1. Nama-nama Daerah yang ada di Indonesia. Saya juga sudah menggunakan request kata kunci.
> Contoh Request  
> Endpoint : http://api.chandrawardhana.my.id/v1/provinsi/page/ByNama 
> Request Method: POST
```
    {
        "nama": "aceh",
        "pageSize": 0,
        "page": 1
    }
```
> Contoh Response 
```
{
  "status": "200",
  "data": {
    "totalItem": 1,
    "totalPage": 1,
    "pageSize": 0,
    "list": [
      {
        "id": "11",
        "nama": "Aceh"
      }
    ],
    "currentPage": 1
  },
  "message": "OK"
}
```

2. Nama-nama Perguruan Tinggi yang ada di Indonesia beserta Provinsi dan Kabupate/Kota. 
> Contoh Request  
> Endpoint : http://api.chandrawardhana.my.id/v1/perguruantinggi/page/nama
> Request Method: POST
```
    {
        "nama": "universitas negeri gorontalo",
        "pageSize": 0,
        "page": 1
    }
```
> Contoh Response :
```
{
  "status": "200",
  "data": {
    "totalItem": 1,
    "totalPage": 1,
    "pageSize": 0,
    "list": [
      {
        "id": 4631,
        "nama": "Universitas Negeri Gorontalo",
        "provinsi": "Gorontalo",
        "kabupatenkota": "Kota Gorontalo"
      }
    ],
    "currentPage": 1
  },
  "message": "OK"
}
```

# 
**Spesifikasi Server**
- OS Ubuntu
- RAM 2 GB
- SSD 20 GB
- Bandwidth Unlimited*
#
Database Daerah (Update)
Data Provinsi, Kota/Kabupaten, Kecamatan, dan Kelurahan/Desa di Indonesia
Sumber Database daerah mencakup untuk Provinsi, Kota/Kabupaten, Kecamatan, dan Kelurahan/Desa 
[Peraturan Menteri Dalam Negeri No.72 Tahun 2019](https://www.kemendagri.go.id/page/read/48/peraturan-menteri-dalam-negeri-no72-tahun-2019) ([pdf](https://www.kemendagri.go.id/files/2020/PMDN%2072%20TH%202019+lampiran.pdf))


Database Perguruan Tinggi
Sumber Database Perguruan Tinggi di Indonesia diambil dari sumber berikut : https://pddikti.kemdikbud.go.id/pt 

#
*Catatan*
- Database menggunakan postgresql dan backend menggunakan Java Springboot 
- Untuk file Request dan Endpoit ada di folder Json. 
- Aplikasi untuk Rest Client menggunakan Thunder Client 

#
*Masukan atau Pertanyaan*
Email : Chandraawardhana@gmail.com





