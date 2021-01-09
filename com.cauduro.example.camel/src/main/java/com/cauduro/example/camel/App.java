package com.cauduro.example.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.cauduro.example.camel.configuration.model.ModelBean;

@SpringBootApplication
@ComponentScan(basePackages="com.cauduro.example.camel")
public class App 
{
	
	@Value("${cauduro.api.path}")
	private String contextPath;
	@Value("${management.port}")
	private String serverPort;
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
    

	@Bean
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(),
				contextPath + "/*");
		servlet.setName("CamelServlet");
		return servlet;
	}
	
    @Component
    class RestApi extends RouteBuilder {

    	
    	
    	@Override
    	public void configure() throws Exception {
    		//example documentation at http://localhost:8080/camel/api-doc
    		CamelContext context = new DefaultCamelContext();
            
    		restConfiguration()
	    		.contextPath(contextPath) //
	            .port(serverPort)
	            .enableCORS(true)
	            .apiContextPath("/api-doc")
	            .apiProperty("api.title", "Test REST API")
	            .apiProperty("api.version", "v1")
	            .apiProperty("cors", "true") // cross-site
	            .apiContextRouteId("doc-api")
	            .component("servlet")
	            .bindingMode(RestBindingMode.json)
	            .dataFormatProperty("prettyPrint", "true");
    		
    		rest("/api/")
    		  .id("api-route")
    		  .consumes("application/json")
    		  .post("/bean")
    		  .bindingMode(RestBindingMode.json_xml)
    		  .type(ModelBean.class)
    		  .to("direct:remoteService");
    		
    		from("direct:remoteService")
    		  .routeId("direct-route")
    		  .tracing()
    		  .log(">>> ${body.id}")
    		  .log(">>> ${body.name}")
    		  .process(new Processor() {
    		      @Override
    		      public void process(Exchange exchange) throws Exception {
    		          ModelBean bodyIn = (ModelBean) exchange.getIn().getBody();
    		          ExampleServices.example(bodyIn);
    		          exchange.getIn().setBody(bodyIn);
    		      }
    		  })
    		  .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
    		
    	}

    }
    
    static class ExampleServices {
        public static void example(ModelBean bodyIn) {
            bodyIn.setName( "Hello, " + bodyIn.getName() );
            bodyIn.setId(bodyIn.getId() * 10);
        }
    }
}
