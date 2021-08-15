package ru.geekbrains.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductAspect {
    @Before("execution(public * ru.geekbrains.controllers.ProductController.*(..))")
    public void beforeAnyMethodInProductController(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        System.out.println("Был вызван метод: " + signature);
        Object[] args = point.getArgs();
        if (args.length > 0) {
            System.out.println("запрошенные аргументы: ");
            for (Object o: args) {
                System.out.println(o);
            }
        }
    }
}
