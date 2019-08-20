package com.k8s.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class CodeStateBEApp {

    private static ConfigurableApplicationContext ctx = null;
    private static final Logger LOG = LoggerFactory.getLogger(CodeStateBEApp.class);

    final static String stateToCode = "Alabama:35801\n"
                                            + "Alaska:99501\n"
                                            + "Arizona:85001\n"
                                            + "Arkansas:72201\n"
                                            + "California:94203\n"
                                            + "Colorado:80201\n"
                                            + "Conneticut:06101\n";

    final static String codeToState = "35801:Alabama\n"
                                            + "99501:Alaska\n"
                                            + "85001:Arizona\n"
                                            + "72201:Arkansas\n"
                                            + "94203:California\n"
                                            + "80201:Colorado\n"
                                            + "06101:Conneticut\n";

	public static void main(String[] args) {
        ctx = SpringApplication.run(CodeStateBEApp.class, args);
	}

	public static String requestProcessedData(int urlId){

	    String serverUrl = null;

	    if (urlId == 1){
	        serverUrl = codeToState;
        } else if (urlId == 2) {
            serverUrl = stateToCode;
        } else {
            serverUrl = "ERROR";
        }

        LOG.info(serverUrl);
	    return serverUrl;
    }

	@GetMapping("/")
    public static String Hello() {
        LOG.info("Hello I'm Data Reader");
	    return "Hello I'm Data Reader";
    }

    @GetMapping("/readDataForCode")
    public static String requestCodeData() {
        LOG.info("Serving readDataForCode");
	    return requestProcessedData(1);
    }

    @GetMapping("/requestDataForState")
    public static String requestStateData(){
        LOG.info("Serving requestDataForState");
	    return requestProcessedData(2);
    }

    @GetMapping("/exit")
    public static void exitApp() {
        ctx.close();
    }

}
