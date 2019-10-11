package com.doosan.ms.gateway.filters;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.doosan.ms.gateway.filters.result.FilterResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class SystemErrorFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("Do the error exception...");
		//捕获异常信息
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletResponse response = context.getResponse();
		ZuulException exception = (ZuulException)context.get("throwable");
		FilterResult result = new FilterResult(false, exception.getMessage());
		ObjectMapper om = new ObjectMapper();
		try {
			String json = om.writeValueAsString(result);
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
