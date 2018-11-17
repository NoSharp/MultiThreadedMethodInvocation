package net.harrykerr.mtmi.threading;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MTMIThread extends Thread {

    public HashMap<Method, Map.Entry<Object[], Class>> methods = new HashMap<>();

    public MTMIThread(String name, HashMap<Method, Map.Entry<Object[], Class>> methods){
        super(name);
        this.methods = methods;
    }

    @Override
    public void run() {

        for(Method method : methods.keySet()){
            try {

                Class origin = methods.get(method).getValue();
                Object[] arguments = methods.get(method).getKey();
                method.invoke(origin.newInstance(), arguments);

            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }

        }

    }
}
