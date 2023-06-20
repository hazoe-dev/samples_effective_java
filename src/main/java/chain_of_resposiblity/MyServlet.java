package chain_of_resposiblity;

public class MyServlet{
    MyChain chain;

    protected void doGet(String req, String resp) throws Exception {
        chain = new MyChain(null);
        chain.doFilter(req,resp);
        System.out.println("Servlet");

    }

}
