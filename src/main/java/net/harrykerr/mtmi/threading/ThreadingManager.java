package net.harrykerr.mtmi.threading;

import java.lang.reflect.Method;
import java.util.*;

public class ThreadingManager {

    public Set<Thread> threads = new HashSet<>();

    public void runMethodOnThread(Class clazz, String threadName, Method method, Object[] args){

        Class origin = method.getClass();

        HashMap<Method, Map.Entry<Object[], Class>> methods = new HashMap<>();

        methods.put(method, new AbstractMap.SimpleEntry<>(args, clazz));

        MTMIThread thread = new MTMIThread("", methods);

        threads.add(thread);

        thread.start();

    }

}
