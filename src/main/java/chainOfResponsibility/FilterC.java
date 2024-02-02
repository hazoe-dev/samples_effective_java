package chainOfResponsibility;

public class FilterC implements Filter{
    @Override
    public void doFilter(String request, String response, Chain chain) {
        System.out.println("Filter C");
        chain.doFilter(request,response);
    }
}
