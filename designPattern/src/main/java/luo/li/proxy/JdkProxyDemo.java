package luo.li.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * @author luoli
 * @date 2022/2/16 9:52
 */
// 业务接口 //
interface ISubject {
    void doAction();
}

// 业务实现类 //
class RealSubject implements ISubject {
    @Override
    public void doAction() { System.out.println("Real Action Here!"); }
}
class RealSubject2 implements ISubject {
    @Override
    public void doAction() { System.out.println("Real Action2 Here!"); }
}

// 动态代理类 //
class SubjectJdkProxyHandler implements InvocationHandler {
    private Object realSubject;

    public SubjectJdkProxyHandler(Object realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(">> doWhatever start"); // 扩展进行额外的功能操作(如鉴权、计时、日志等)
        Object result = method.invoke(realSubject, args); // 执行目标对象方法
        System.out.println("doWhatever end <<");   // 扩展进行额外的功能操作(如鉴权、计时、日志等)
        return result;
    }
}

// 验证代码 //
public class JdkProxyDemo {
    public static void main(String[] args) {
        ISubject subject = (ISubject) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[] {ISubject.class}, // 或RealSubject.class.getInterfaces()
                new SubjectJdkProxyHandler(new RealSubject())); // RealSubject必须实现Subject接口，否则无法强转后调用业务方法
        subject.doAction();

        // 使用同一个SubjectProxyHandler类，可代理不同的类型
        ISubject subject2 = (ISubject) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[] {ISubject.class}, new SubjectJdkProxyHandler(new RealSubject2())); // 可使用工厂模式创建代理对象
        subject2.doAction();
    }
}
