package net.filter;


import javax.servlet.*;
import java.io.IOException;

public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String filterName = filterConfig.getFilterName();
        String param = filterConfig.getInitParameter("param");
        ServletContext servletContext = filterConfig.getServletContext();
        System.out.println(filterName + "-----" + param);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 拦截了所有的请求
        System.out.println("filter运行了");
        // 放行请求
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
