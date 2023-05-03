package common_method.equal_hashcode.goodHashCode;

public class SelfHelp extends Book {
    private int quantityBook;

    public SelfHelp(String name, int numberPublish, String author, int quantityBook) {
        super(name, numberPublish, author);
        this.quantityBook = quantityBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SelfHelp book = (SelfHelp) o;
        boolean nameEqual = (this.name == null && book.name==null)||(this.name!=null && this.name.equals(book.name));
        boolean authorEqual = (this.author == null && book.author==null)||(this.author!=null && this.author.equals(book.author));
        return quantityBook == book.quantityBook && numberPublish == book.numberPublish && nameEqual && authorEqual;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = super.hashCode();
        result = 31 * result + quantityBook;
        return result;
    }
}
