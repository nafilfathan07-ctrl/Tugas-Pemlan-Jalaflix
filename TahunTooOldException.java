
public class TahunTooOldException extends Exception {
    private final int tahun;

    public TahunTooOldException(int tahun) {
        super("Tahun tidak valid: " + tahun + ". Tahun produksi film tidak boleh sebelum tahun 1800.");
        this.tahun = tahun;
    }

    public int getTahun() {
        return tahun;
    }
}
