package be.pxl.boardgame.boardgameapp.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BoardgameAspectAround {

    @Around("execution(* be.pxl.boardgame.boardgameapp.service.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around...");

        // Response - flow
        // Before
        /*
            Hoe lang geleden was de vorige call
            > 5 min geleden
            then joinPoint.proceed();
            -> trigger om te mogen uitvoeren
         */

        // return result
        Object result = joinPoint.proceed();
        // After

        System.out.println(result);

        // return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
        return result;
        // After returning
        // After throwing
    }
}
