package com.k8s.userapp.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CodeStateUserApp {

    private static ConfigurableApplicationContext ctx = null;
    private static final Logger LOG = LoggerFactory.getLogger(CodeStateUserApp.class);
    final static String serverUrl = "http://dataservice.default.svc.cluster.local";
    private static Environment env;

    public static void main(String[] args) {
        ctx = SpringApplication.run(CodeStateUserApp.class, args);
    }

    public static String requestProcessedData(String serverUrl) {
        RestTemplate request = new RestTemplate();
        String result = request.getForObject(serverUrl, String.class);
        LOG.info(serverUrl);
        return result;
    }

    @GetMapping("/")
    public static String Hello() {
        LOG.info("Reached base request.");
        return "Reached User Service.";
    }

    @GetMapping("/CodeToState")
    public static String codeToState(@RequestParam(name = "code") String code) {

        LOG.info("Getting state for zip code: " + code);
        try {
            String response = requestProcessedData(serverUrl + "/readDataForCode");
            String[] responseCodes = response.split("\n");
            LOG.info(response);

            for (String rcode: responseCodes) {
                String[] data = rcode.split(":");
                if (data[0].equals(code)) {
                    LOG.info("Found State: " + data[1] + " for Code: " + code);
                    return data[1];
                }
            }
        } catch (Exception e) {
            LOG.info("[ERROR]: " + e.toString());
        }

        return "State Not Found for Code: " + code;
    }

    @GetMapping("/StateToCode")
    public static String stateToCode(@RequestParam(name = "state") String state) {

        LOG.info("Getting zip code for state: " + state);
        try {
            String response = requestProcessedData(serverUrl + "/requestDataForState");
            String[] responseCodes = response.split("\n");

            for (String rcode: responseCodes) {
                String[] data = rcode.split(":");
                if (data[0].equals(state)) {
                    LOG.info("Found Code: " + data[1] + " for State: " + state);
                    return data[1];
                }
            }
        } catch (Exception e) {
            LOG.info("[ERROR]: " + e.toString());
        }

        return "State Not Found for Code: " + state;
    }

    @GetMapping("/GetConfig")
    public static String getConfig() {
        LOG.info("Getting ConfigMap info from ENV");
        // return "Accessing ConfigMap to get APP_NAME.\nAPP_NAME: " + env.getProperty("APP_NAME");
        return "Accessing ConfigMap to get APP_NAME.\nAPP_NAME: " + System.getenv("APP_NAME");
    }

    @GetMapping("/GetSecret")
    public static String getSecret() {
        LOG.info("Getting Secret info from ENV");
        // return "Accessing Secrets to get SECRET_KEY.\nSECRET_KEY: " + env.getProperty("SECRET_KEY");
        return "Accessing Secrets to get SECRET_KEY.\nSECRET_KEY: " + System.getenv("SECRET_KEY");
    }

    @GetMapping("/exit")
    public static void exitApp() {
        LOG.info("Exiting Springboot App.");
        ctx.close();
    }
}
