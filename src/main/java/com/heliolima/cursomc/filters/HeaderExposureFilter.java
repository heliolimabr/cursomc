package com.heliolima.cursomc.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @author Helio
 */
@Component
public class HeaderExposureFilter implements Filter{

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) sr1;
        res.addHeader("access-control-expose-headers", "location");
        chain.doFilter(sr, sr1);
    }

    @Override
    public void destroy() {
    }
    
}
