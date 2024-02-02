package chainOfResponsibility;

public interface Filter {
    void doFilter(String request, String response, Chain chain);
}
