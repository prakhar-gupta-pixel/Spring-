    package in.Prakhar.filterdemo.Filter;


    import jakarta.servlet.*;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import org.springframework.core.annotation.Order;
    import org.springframework.stereotype.Component;

    import java.io.IOException;

    @Component
    @Order(1)
    public class AuthenticationFilter implements Filter {




        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {


            System.out.println("auth filter started");


//            long StartTime = System.currentTimeMillis();

            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;


            String token = req.getHeader("token");


            String apikey = req.getHeader("x-api-key");
            if (token == null || !token.equals("12345")) {

                    resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;

            }


            if (apikey == null || !apikey.equals("secret6306")) {

                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                resp.setContentType("application/json");

                resp.getWriter().write(

                        "{\n" +
                                "    \"message\" : \"invalid or missing api key\"\n" +
                                "}"
                );
                return;

            }





            try {
            chain.doFilter(request, response);

        }

            finally {
                System.out.println("leaving auth filter");
            }

        }
    }
