package ptithcm.Interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.filters.SecurityWrapperResponse;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		HttpSession	ss=request.getSession();
		System.out.println("Truoc");
		if(ss.getAttribute("user")==null) {
			response.sendRedirect(request.getContextPath()+"/login.htm");
			return false;
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Sau");
		
	} 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("View");
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
	    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
	    // if errors exist then create a sanitized cookie header and continue
	    SecurityWrapperResponse securityWrapperResponse = new SecurityWrapperResponse(httpServletResponse, "sanitize");
	    Cookie[] cookies = httpServletRequest.getCookies();
	    if (cookies != null) {
	        for (int i = 0; i < cookies.length; i++) {
	            Cookie cookie = cookies[i];
	            if (cookie != null) {
	                // ESAPI.securityConfiguration().getHttpSessionIdName() returns JSESSIONID by default configuration
	                if (ESAPI.securityConfiguration().getHttpSessionIdName().equals(cookie.getName())) {
	                    securityWrapperResponse.addCookie(cookie);
	                }
	            }
	        }
	    }
	    filterChain.doFilter(request, response);
	}
}
