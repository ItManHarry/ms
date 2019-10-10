package com.doosan.ms.gateway.filters;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class AuthFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
//		RequestContext context = RequestContext.getCurrentContext();
//		HttpServletRequest request = context.getRequest();
//		HttpServletResponse response = context.getResponse();
//		String token = request.getParameter("token");
//		if(!"user".equals(token)) {
//			//不转发微服务，给用户相应
//			context.setSendZuulResponse(false);
//			//设置401
//			response.setStatus(401);
//			System.out.println("401, response failed...");
//			return null;
//		}
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
