package in.Prakhar.filterdemo.Filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)

public class  LoggingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {



        long StartTime = System.currentTimeMillis();


        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse  resp = (HttpServletResponse) response;


        String requestId = UUID.randomUUID().toString();

        System.out.println("LoggingFilter started with " + req.getMethod()
                + " " + req.getRequestURI());


        resp.setHeader("Request-Id", requestId);



        try {
            chain.doFilter(request, response);

        }

        finally {


            long EndTime = System.currentTimeMillis();

            long Duration = EndTime - StartTime;


            System.out.println(resp.getStatus());




            String username =
                    (String) request.getAttribute("username");

            String role =
                    (String) request.getAttribute("role");

            String authType =
                    (String) request.getAttribute("authType");

            System.out.println("Username: " + username);
            System.out.println("Role: " + role);
            System.out.println("Auth Type: " + authType);

            System.out.println("tat IS " +Duration + "ms")

            ;

        }
    }
}
