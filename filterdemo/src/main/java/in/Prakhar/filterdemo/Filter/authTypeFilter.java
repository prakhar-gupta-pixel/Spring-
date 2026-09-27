package in.Prakhar.filterdemo.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(4)
public class authTypeFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        Object authType =
                request.getAttribute("authType");

        if (authType == null) {

            HttpServletResponse resp =
                    (HttpServletResponse) response;

            resp.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );

            resp.getWriter().write(
                    "Authentication required"
            );

            return;
        }

        chain.doFilter(request, response);
    }
}