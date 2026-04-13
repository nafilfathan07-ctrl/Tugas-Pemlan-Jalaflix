
public class UmurNegatifException extends Exception {
    private final int umur;

    public UmurNegatifException(int umur) {
        super("Umur tidak valid: " + umur + ". Umur tidak boleh bernilai negatif.");
        this.umur = umur;
    }

    public int getUmur() {
        return umur;
    }
}
