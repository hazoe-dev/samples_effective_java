package chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Filter> filters = new ArrayList<>();
        filters.add(new FilterA());
        filters.add(new FilterB());
        filters.add(new FilterC());


        Chain chain = Chain.link(filters);
        chain.doFilter("req", "res");
    }
}
