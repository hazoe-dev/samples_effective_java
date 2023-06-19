package chain_of_resposiblity;

public class Chain {
    private FilterHandler nextFilter;

    public FilterHandler getNextFilter() {
        return nextFilter;
    }

    public void setNextFilter(FilterHandler nextFilter) {
        this.nextFilter = nextFilter;
    }

    void doFilter(String username, String password, Chain chain){
        chain.getNextFilter();
    }
}
