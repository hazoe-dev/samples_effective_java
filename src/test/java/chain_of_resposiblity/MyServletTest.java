package chain_of_resposiblity;

import org.junit.jupiter.api.Test;

import java.util.List;

class MyServletTest {

    @Test
    void doGet() throws Exception {
        MyServlet servlet = new MyServlet();
        servlet.doGet("request", "response");
    }
}