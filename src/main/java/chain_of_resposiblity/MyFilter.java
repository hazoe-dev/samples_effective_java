package chain_of_resposiblity;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface MyFilter {
    void doFilter(String request, String response, MyChain chain) throws Exception;
}
