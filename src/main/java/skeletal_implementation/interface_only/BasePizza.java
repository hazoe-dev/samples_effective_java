package skeletal_implementation.interface_only;


public class BasePizza implements IPizza {
    @Override
    public String prepare() {
        return "_Pizza base";
    }
}
