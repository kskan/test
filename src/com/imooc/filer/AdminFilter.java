package com.imooc.filer;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/pages/admin/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        HttpSession session=request.getSession();
        String admin=(String)session.getAttribute("loginname");
        if("".equals(admin)||admin==null){
            response.sendRedirect(request.getContextPath() + "/index.jsp?flag=3");
            return;
        }
        if (admin.equals("imooc")) {
            session.setAttribute("flag", 1);
        } else {
            session.setAttribute("flag", 2);
        }
        chain.doFilter(req, resp);
        return;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
