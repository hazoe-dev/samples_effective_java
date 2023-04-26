package common_method.clone;

public class Pig {
    int weight;
    Origin origin;

    public Pig(int weight, Origin origin) {
        this.weight = weight;
        this.origin = origin;
    }

    @Override
    protected Pig clone() throws CloneNotSupportedException {
        Pig pig = new Pig(this.weight, this.origin);
        return pig;
    }
}
