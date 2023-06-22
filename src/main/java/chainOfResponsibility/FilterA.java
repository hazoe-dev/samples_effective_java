package chainOfResponsibility;

public class FilterA implements Filter{
    @Override
    public void doFilter(String request, String response, Chain chain) {
        System.out.println("Filter A");
        chain.doFilter(request,response);
    }
}
