package ru.geekbrains.AOP;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutDeclarationAspect {
    @Pointcut("execution(public * ru.geekbrains.controllers.ProductController.*(..))")
    public void productControllerGetTrackerPointCut(){
        System.out.println("Выхывается метод ProductController");
    }


}
