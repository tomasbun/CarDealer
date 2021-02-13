/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tomas
 */
public class NoCacheFilter implements Filter {
    
    public NoCacheFilter() {
    }
    
    @Override
    public void destroy() {
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (!req.getRequestURI()
                .startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER))
        { // Skip
                                                                                                           // JSF
                                                                                                           // resources
                                                                                                           // (CSS/JS/Images/etc)
            res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP
                                                                                   // 1.1.
            res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            res.setDateHeader("Expires", 0); // Proxies.
        }

        chain.doFilter(request, response);
    }
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }
}

