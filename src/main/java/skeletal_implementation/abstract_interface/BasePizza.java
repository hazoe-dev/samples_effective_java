package skeletal_implementation.abstract_interface;

public class BasePizza implements IPizza {
    @Override
    public String prepare() {
        return "_Pizza base";
    }

    @Override
    public boolean bake() {
        System.out.println("bake");
        return true;
    }

    @Override
    public boolean cut() {
        System.out.println("cut");
        return true;
    }

    @Override
    public boolean box() {
        System.out.println("box");
        return true;
    }

    @Override
    public String create() {
        String result =" -> bake: "+ bake() + "-> cut: "+ cut() + " -> box: "+ box();
        return result;
    }
}
