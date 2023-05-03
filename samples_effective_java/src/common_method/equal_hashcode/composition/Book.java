package common_method.equal_hashcode.composition;

import common_method.equal_hashcode.composition.SelfHelp;

public class Book {
    String name;
    int numberPublish;
    String author;

    SelfHelp selfHelp;

    public Book(String name, int numberPublish, String author, SelfHelp selfHelp) {
        this.name = name;
        this.numberPublish = numberPublish;
        this.author = author;
        this.selfHelp = selfHelp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book))
            return false;
        Book book = (Book) o;
        boolean nameEqual = (this.name == null && book.name==null)||(this.name!=null && this.name.equals(book.name));
        boolean authorEqual = (this.author == null && book.author==null)||(this.author!=null && this.author.equals(book.author));
        boolean selfHelpEqual = this.selfHelp.equals(((Book) o).selfHelp);
        return numberPublish == book.numberPublish && nameEqual && authorEqual && selfHelpEqual;
    }

    @Override
    public int hashCode() {
        int result= 17;
        result= 31 * result + numberPublish;
        result= 31 * result + name.length();
        result= 31 * result + author.length();
        return result;
    }
}
