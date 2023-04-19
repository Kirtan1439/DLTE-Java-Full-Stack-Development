package bank.project.app;

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
public class TransactionConfig extends WsConfigurerAdapter {
    @Bean(name = "transaction")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema transactionSchema){
        DefaultWsdl11Definition schemaObject=new DefaultWsdl11Definition();
        schemaObject.setPortTypeName("transactionPort");
        schemaObject.setTargetNamespace("http://soap.transaction.project");
        schemaObject.setLocationUri("/transactionpoint");
        schemaObject.setSchema(transactionSchema);
        return schemaObject;
    }
    @Bean
    public XsdSchema transactionSchema(){
        return new SimpleXsdSchema(new ClassPathResource("transaction.xsd"));
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean(servlet,"/transactionpoint/*");
    }
}
