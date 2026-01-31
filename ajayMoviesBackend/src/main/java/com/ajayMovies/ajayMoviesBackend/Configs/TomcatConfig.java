// package com.ajayMovies.ajayMoviesBackend.Configs;

// import org.apache.coyote.ProtocolHandler;
// import org.apache.coyote.http11.AbstractHttp11Protocol;
// import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
// import org.springframework.boot.web.server.WebServerFactoryCustomizer;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class TomcatConfig {


//     @Bean
//     public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer() {
//         return factory -> factory.addConnectorCustomizers(connector -> {
//             ProtocolHandler handler = connector.getProtocolHandler();
//             if (handler instanceof AbstractHttp11Protocol) {
//                 AbstractHttp11Protocol<?> protocol = (AbstractHttp11Protocol<?>) handler;
//                 // Allow up to 10,000 parts (files + fields) in a single request
//                 protocol.setMaxPartCount(10000); 
//                 // Also helpful to increase swallowing size for large failures
//                 protocol.setMaxSwallowSize(-1);
//             }
//         });
//     }
// }