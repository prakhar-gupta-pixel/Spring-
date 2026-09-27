package com.example.AdavncedFilters.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;


@Component
public class ResponseFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) response;

        ContentCachingResponseWrapper wrappedResponse =
                new ContentCachingResponseWrapper(httpServletResponse);

        chain.doFilter(request, wrappedResponse);

        byte[] originalBody = wrappedResponse.getContentAsByteArray();

        String body = new String(originalBody);

        String modifiedBody =
                """
                        {
                        "originalResponse": %s,
                        "appName": "Stduent Management System"
                       }""".formatted(body);


        wrappedResponse.resetBuffer();

        wrappedResponse.getWriter().write(modifiedBody);

        wrappedResponse.copyBodyToResponse();
        response.setContentType("text/html");
        response.setContentLength(originalBody.length);
        ((HttpServletResponse) response).setHeader("x-api-version", "1");
        response.set
    }
}
