package aspects;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {
    private long time1, time2;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public LogAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }

    @Pointcut("execution(* metier.*.*(..))||initialization(metier.*.new(..)) ")
    public void pc1() {
    }

    @Before("pc1()")
    public void before(JoinPoint joinPoint) {
        logger.info("----------------------------");
        time1 = System.currentTimeMillis();
        logger.info("Before " + joinPoint.getSignature());
    }

    @After("pc1()")
    public void after(JoinPoint joinPoint) {
        time2 = System.currentTimeMillis();
        logger.info("After " + joinPoint.getSignature());
        logger.info("Duration:" + (time2 - time1));
        logger.info("********************************");
    }
}