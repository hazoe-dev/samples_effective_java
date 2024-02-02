package chainOfResponsibility;

import java.util.List;

public class Chain {
    public Chain() {
    }

    Filter filter;
    Chain next;

    public Chain(Filter filter, Chain next) {
        this.filter = filter;
        this.next = next;
    }

    static Chain link(List<Filter> filters){

        Chain headChain = new Chain(filters.remove(0), new Chain());
        Chain firstChain  = headChain;

        for (Filter nextFilter: filters
             ) {
            Chain nextChain= new Chain (nextFilter,new Chain());
            headChain.next= nextChain;

            headChain = nextChain;

        }
        return firstChain;
    }


    public void doFilter(String request, String response) {
        if(filter!=null){
            filter.doFilter(request,response, next);
        }
    }
}
