package aspects;

import java.util.Scanner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SecurityAspect {
    private String username = "root";
    private String password = "123";

    @Around("call(* *.*.*.start(..))")
    public void secureApp(JoinPoint joinPoint, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Authentication");
        System.out.print("Username :");
        String username = scanner.next();
        System.out.print("Password :");
        String pass = scanner.next();

        if (username.equals(this.username) && pass.equals(this.password)) {
            System.out.println("Before starting");
            proceedingJoinPoint.proceed();
            System.out.println("End of Application");
        } else {
            System.out.println("Access denied ...");
        }
    }
}
