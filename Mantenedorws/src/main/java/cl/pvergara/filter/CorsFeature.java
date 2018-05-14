package cl.pvergara.filter;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import org.jboss.resteasy.plugins.interceptors.CorsFilter;

public class CorsFeature implements Feature {

	@Override
	public boolean configure(FeatureContext context) {
		CorsFilter corsFilter = new CorsFilter();
		corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
        corsFilter.getAllowedOrigins().add("*");
        context.register(corsFilter);
        return true;
	}

}
