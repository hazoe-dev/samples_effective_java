package chain_of_resposiblity;

public class FilterA implements MyFilter {
    @Override
    public void doFilter(String request, String response, MyChain chain) throws Exception {
        System.out.println("Filter A");
        chain.doFilter(request,response);
    }
}
