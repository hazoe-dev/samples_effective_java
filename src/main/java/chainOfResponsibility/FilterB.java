package chainOfResponsibility;

public class FilterB implements Filter{
    @Override
    public void doFilter(String request, String response, Chain chain) {
        System.out.println("Filter B");
        chain.doFilter(request,response);
    }
}
