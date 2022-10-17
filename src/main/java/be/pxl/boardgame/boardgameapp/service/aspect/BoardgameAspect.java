package be.pxl.boardgame.boardgameapp.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BoardgameAspect {
    // vier aparte -> specifiek

    @Before("execution(* be.pxl.boardgame.boardgameapp.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("Aspect before Called");
    }

    @After("execution(* be.pxl.boardgame.boardgameapp.service.*.*(..))")
    public void ater(JoinPoint joinPoint){
        System.out.println("Aspect after Called");
    }

    @AfterReturning("execution(* be.pxl.boardgame.boardgameapp.service.*.*(..))")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("Aspect returning Called");
    }

    @AfterThrowing("execution(* be.pxl.boardgame.boardgameapp.service.*.*(..))")
    public void afterThrowing(JoinPoint joinPoint){
        System.out.println("Aspect returning Called");
    }
}
