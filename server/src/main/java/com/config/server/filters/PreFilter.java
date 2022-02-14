package com.config.server.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
        System.out.println("Req Method: "+request.getMethod()+" Req URL: "+ request.getRequestURI().toString());
        return null;
    }
}
