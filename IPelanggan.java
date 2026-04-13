package jalaflix;

import java.util.List;


public interface IPelanggan {
     //Menampilkan dan mengembalikan daftar film yang dapat diakses pelanggan.
    List<Film> lihatDaftarFilm(List<Film> semuaFilm);

     //return true jika berhasil diputar, false jika tidak tersedia atau keanggotaan tidak aktif.
    boolean putarFilm(Film film, List<Film> semuaFilm);

    //Menampilkan riwayat film yang pernah ditonton oleh pelanggan.
    void lihatHistory();

    //Mengembalikan nama kategori pelanggan (Regular / Gold / Platinum).
    String getKategori();

    //Mengubah status keanggotaan pelanggan (aktif / tidak aktif)
    void ubahStatusKeanggotaan(boolean status);
}
