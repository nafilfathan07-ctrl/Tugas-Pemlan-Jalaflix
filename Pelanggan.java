package jalaflix;

import java.util.List;


public abstract class Pelanggan implements IPelanggan {

    private final String kodePelanggan;
    private String nama;
    private String nomorTelepon;
    private final int umur;
    private boolean statusKeanggotaan;
    protected final HistoriTontonan historiTontonan;

    public Pelanggan(String kodePelanggan, String nama, String nomorTelepon, int umur)
            throws UmurNegatifException {
        if (umur < 0) {
            throw new UmurNegatifException(umur);
        }
        this.kodePelanggan   = kodePelanggan;
        this.nama            = nama;
        this.nomorTelepon    = nomorTelepon;
        this.umur            = umur;
        this.statusKeanggotaan = true;
        this.historiTontonan = new HistoriTontonan();
    }

    // ── Method abstrak 
    @Override
    public abstract String getKategori();

    @Override
    public abstract List<Film> lihatDaftarFilm(List<Film> semuaFilm);

    // ── Implementasi konkret (dapat di-override subkelas) 

    @Override
    public boolean putarFilm(Film film, List<Film> semuaFilm) {
        if (!statusKeanggotaan) {
            System.out.println("  Keanggotaan tidak aktif. Silakan aktifkan keanggotaan Anda.");
            return false;
        }
        List<Film> tersedia = lihatDaftarFilm(semuaFilm);
        if (tersedia.contains(film)) {
            System.out.println("  ▶ Memutar: \"" + film.getJudul() + "\"");
            historiTontonan.tambahFilm(film);
            return true;
        } else {
            System.out.println("  ✗ Film \"" + film.getJudul() + "\" tidak tersedia untuk pelanggan " + getKategori() + ".");
            return false;
        }
    }

    @Override
    public void lihatHistory() {
        System.out.println("─── History Tontonan: " + nama + " ───");
        historiTontonan.tampilkanHistory();
    }

    @Override
    public void ubahStatusKeanggotaan(boolean status) {
        this.statusKeanggotaan = status;
        System.out.println("  Status keanggotaan " + nama + " → " + (status ? "AKTIF" : "TIDAK AKTIF"));
    }

    // ── Getters 
    public String getKodePelanggan()    { return kodePelanggan; }
    public String getNama()             { return nama; }
    public String getNomorTelepon()     { return nomorTelepon; }
    public int getUmur()                { return umur; }
    public boolean isStatusKeanggotaan(){ return statusKeanggotaan; }
    public HistoriTontonan getHistoriTontonan() { return historiTontonan; }

    // ── Setters 
    public void setNama(String nama)            { this.nama = nama; }
    public void setNomorTelepon(String noTelp)  { this.nomorTelepon = noTelp; }

    public void tampilkanInfo() {
        System.out.println("=".repeat(52));
        System.out.printf("%-14s: %s%n", "Kode",      kodePelanggan);
        System.out.printf("%-14s: %s%n", "Nama",      nama);
        System.out.printf("%-14s: %s%n", "No. Telp",  nomorTelepon);
        System.out.printf("%-14s: %d tahun%n", "Umur", umur);
        System.out.printf("%-14s: %s%n", "Kategori",  getKategori());
        System.out.printf("%-14s: %s%n", "Status",    statusKeanggotaan ? "Aktif" : "Tidak Aktif");
        System.out.println("=".repeat(52));
    }

    @Override
    public String toString() {
        return String.format("[%s] %-20s | %-8s | %s",
                kodePelanggan, nama, getKategori(),
                statusKeanggotaan ? "Aktif" : "Tidak Aktif");
    }
}
