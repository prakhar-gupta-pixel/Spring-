package in.Prakhar.filterdemo.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
public class AuthoriseFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse resp =
                (HttpServletResponse) response;

        String token =
                req.getHeader("Authorization");

        // No Bearer token → let the next authentication mechanism try
        if (token == null) {
            chain.doFilter(request, response);
            return;
        }

        if ("Bearer token-user".equals(token)) {

            request.setAttribute("username", "prakhar");
            request.setAttribute("role", "USER");
            request.setAttribute("authType", "BEARER");

        } else if ("Bearer token-admin".equals(token)) {

            request.setAttribute("username", "admin");
            request.setAttribute("role", "ADMIN");
            request.setAttribute("authType", "BEARER");

        } else {

            resp.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );

            resp.getWriter().write(

                    "{\n" +
                            "    \"message\" : \"invalid or missing api key\"\n" +
                            "}"
            );

            return;
        }

        chain.doFilter(request, response);
    }
}