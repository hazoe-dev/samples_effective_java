package chain_of_resposiblity;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class MyChain {
    private List<String> filters = Arrays.asList(new String[]{FilterA.class.getName(),FilterB.class.getName()});
    private MyFilter instance;

    public MyChain(MyFilter instance) {
        this.instance = instance;
    }

    public void doFilter(String request, String response) throws Exception{
        if(instance==null){
            MyFilter filter = createFilter(filters.get(0));
            MyFilter nextFilter = createFilter(filters.get(1));

            filter.doFilter(request,response,new MyChain(nextFilter));
        }else{

            int index = filters.indexOf(instance.getClass().getName());
            if(filters.size()==index-1){

            }else{
                MyFilter nextFilter = createFilter(filters.get(index++));
                instance.doFilter(request,response, new MyChain(nextFilter));
            }

        }
    }
    private MyFilter createFilter(String classname) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> c = Class.forName(classname);
        Constructor<?> cons = c.getConstructor();
        return  (MyFilter) cons.newInstance();
    }
}
