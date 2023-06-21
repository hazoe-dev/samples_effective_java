package chain_of_resposiblity;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class MyChain {
    private List<String> filters = Arrays.asList(new String[]{FilterA.class.getName(),FilterB.class.getName()});
    private MyFilter instance;
    private MyFilter next;

    public MyChain(MyFilter instance, MyFilter next) {
        this.instance = instance;
        this.next = next;
    }

    public void doFilter(String request, String response) throws Exception{
        if(instance==null && next == null){
            MyFilter filter = createFilter(filters.get(0));
            MyFilter nextFilter = createFilter(filters.get(1));

            filter.doFilter(request,response,new MyChain(filter, nextFilter));
        }else if (instance!=null && next != null){
            next.doFilter(request,response,new MyChain(next, getNextFilter(next)));
        }else{
            return;
        }
    }

    private MyFilter getNextFilter(MyFilter current) {
        //get next index!
        String  filterName =  filters.stream().filter(item -> item.equals(current.getClass().getName()))
                .findAny()
                .orElse("");
        if(filterName.isEmpty()){
            return null;
        }else{
            try {
                return createFilter(filterName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private MyFilter createFilter(String classname) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> c = Class.forName(classname);
        Constructor<?> cons = c.getConstructor();
        return  (MyFilter) cons.newInstance();
    }
}
