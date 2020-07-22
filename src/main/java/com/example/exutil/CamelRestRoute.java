package com.example.exutil;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/").get("/init").produces("application/json").to("direct:process");
        from("direct:process").log("RequestReceived").setBody(constant("{\"initialized\":\"true\"}"));
    }

}
