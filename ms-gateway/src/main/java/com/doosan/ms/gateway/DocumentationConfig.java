package com.doosan.ms.gateway;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider{
	
	private final RouteLocator routeLocator;
	
	public DocumentationConfig(RouteLocator routeLocator) {
		this.routeLocator = routeLocator;
	}

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resouces = new ArrayList<SwaggerResource>();
		List<Route> routes = routeLocator.getRoutes();
		routes.forEach(route -> {
			resouces.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"), "2.0"));
		});
		return null;
	}
	
	private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
