package com.example.AspectImplementation.Aspect;


import com.example.AspectImplementation.Dto.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private final HttpServletRequest request;

    public LoggingAspect(HttpServletRequest request) {

        this.request = request;
    }

//    @Before("execution(* com.example.AspectImplementation.Service.StudentService.createStudent(..))")
//    public void logBeore(JoinPoint joinPoint) {
//
//        String auth = request.getHeader("Authorization");
//
//        if (!auth.equals("Admin") || auth == null) {
//
//            throw new RuntimeException("Unauthorized");
//
//        }
//        Object[] args = joinPoint.getArgs();
//        for (Object arg : args) {
//            System.out.println(arg.toString());
//        }
//        System.out.println("log before called as admin called this method");
//    }
//
//
//    @AfterReturning(value = "execution(* com.example.AspectImplementation.Service.StudentService.createStudent(..))",
//            returning = "result")
//    public void logAfterReturn(JoinPoint joinPoint, Student result) {
//
////        String s = "TArget method returned   "+ result;
//
//        Student student = (Student) joinPoint.getArgs()[0];
//
//
//        result.setName("divyansh");
//        result.setAge(24);
//
//
////        Object [] args = joinPoint.getArgs();
////        for ( Object arg : args ) {
////            System.out.println(arg.toString());
////        }
//        System.out.println("intercepted createstudent");
//
//    }
//
//
//
//
//    @AfterThrowing(value = "execution(* com.example.AspectImplementation.Service.StudentService.createStudent(..))",
//                  throwing = "exception")
//    public void logAfterThrowing(RuntimeException exception) {
//
//
//
//        System.out.println(exception.getClass().getName());
//        System.out.println(exception.getMessage());
//    }
//
//
//
//
//    @After(value = "execution(* com.example.AspectImplementation.Service.StudentService.createStudent(..))")
//
//    public void logAfter(JoinPoint joinPoint) {
//        long  startTime = System.currentTimeMillis();
//
//        long endTime = System.currentTimeMillis();
//        System.out.println("method intercepted :"+joinPoint.getSignature().getName());
//        System.out.println("execution time: " + (endTime - startTime)   );
//    }
//

//    @Around(value = "execution(* com.example.AspectImplementation.Service.StudentService.createStudent(..))")
//
//    public Student  aroundLogic( ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        System.out.println(proceedingJoinPoint.getSignature().getName());
//        try{
//            Student s  = (Student)proceedingJoinPoint.proceed();
//
//            return s ;
//        }
//
//        catch(Throwable e){
//
//            System.out.println( e.getClass().getName());
//            System.out.println(e.getMessage());
//            throw e;
//
//
//        }
//
//        finally {
//
//
//
//            System.out.println("after around logic");
//        }
//
//

        @Around(value = "execution(* com.example.AspectImplementation.Service.StudentService.dummy(..))")

        public String  secondAround( ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

            System.out.println(proceedingJoinPoint.getSignature().getName());



            Object [] args = proceedingJoinPoint.getArgs();


            String originalString = args[0].toString();

            String modifiedString = originalString.toUpperCase();


            System.out.println("Intercepted");

            Object[] modifiedArr = {
                    modifiedString
            };





            String ReturnType =
                    (String)proceedingJoinPoint.proceed(modifiedArr);

            return ReturnType;

        }
}
