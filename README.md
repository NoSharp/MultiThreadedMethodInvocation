# MultiThreadedMethodInvocation
MultiThreadedMethodInvocation for Java

It does what It says on the tin ;)

```java
public class Main {

    public static void main(String[] args){
        try {
            ThreadingManager manager = new ThreadingManager();
            manager.runMethodOnThread(Main.class, "test", Main.class.getMethod("bark"), new Object[]{});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public void bark(){
        System.out.println("WOOOOOOOOOF!");
    }
}

```
