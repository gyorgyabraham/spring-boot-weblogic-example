package hu.gyabraham.wlspringboot;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "*");
    }

    @Bean(name = "mockWsdlDefinition")
    public DefaultWsdl11Definition mockWsdlDefinition(XsdSchema schemaFile) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SomeServicePort");
        wsdl11Definition.setLocationUri("/somepath");
        wsdl11Definition.setTargetNamespace("http://gyorgyabraham.hu");
        wsdl11Definition.setSchema(schemaFile);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema schemaFile() {
        return new SimpleXsdSchema(new ClassPathResource("allSchemas.xsd"));
    }
}
