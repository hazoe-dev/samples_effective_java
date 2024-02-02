package decorator_pattern;

public class BasePizza implements IPizza{
    @Override
    public String prepare() {
        return "_Pizza base";
    }
}
