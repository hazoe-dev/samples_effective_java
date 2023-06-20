package chain_of_resposiblity;


public class FilterB implements MyFilter {

    @Override
    public void doFilter(String request, String response, MyChain chain) throws Exception {
        System.out.println("Filter B");
        chain.doFilter(request,response);

    }

}
