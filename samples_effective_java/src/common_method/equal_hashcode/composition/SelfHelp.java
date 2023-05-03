package common_method.equal_hashcode.composition;

public class SelfHelp {
    private int quantityBook;

    public SelfHelp(int quantityBook) {
        this.quantityBook = quantityBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SelfHelp)) return false;
        if (!super.equals(o)) return false;
        SelfHelp book = (SelfHelp) o;
        return quantityBook == book.quantityBook;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = super.hashCode();
        result = 31 * result + quantityBook;
        return result;
    }
}
