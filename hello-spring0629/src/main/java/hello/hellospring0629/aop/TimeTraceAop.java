package hello.hellospring0629.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    @Around("execution(* hello.hellospring0629..*(..))")//패키지 하위에 다 적용해
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: "+joinPoint.toString());
        try{
            Object result = joinPoint.proceed();
            return result;
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs=finish-start;
            System.out.println("END: "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }
}
