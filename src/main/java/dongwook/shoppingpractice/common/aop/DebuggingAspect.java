package dongwook.shoppingpractice.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DebuggingAspect {

    //대상메소드 선택
    @Pointcut("execution(* dongwook.shoppingpractice.service.MemberService.getMemberList(..))")
    private void cut() {

    }

    //실행시점 설정
    @Before("cut()")
    public void loggingArgs(JoinPoint joinPoint) {
        //입력값
        Object[] args = joinPoint.getArgs();

        //클래스명
        String className = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        //메소드명
        String methodName = joinPoint.getSignature()
                .getName();

        //입력값 로깅
        for (Object arg : args) {
            log.info("{}#{}의 입력값 => {}", className, methodName, arg);
        }
    }

}
