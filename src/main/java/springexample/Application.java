package springexample;

import java.io.File;
import com.braintreegateway.BraintreeGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static String DEFAULT_CONFIG_FILENAME = "example.config.properties";
    public static BraintreeGateway gateway;

    public static void main(String[] args) {
        File configFile = new File(DEFAULT_CONFIG_FILENAME);
        try {
			/*
			 * if(configFile.exists() && !configFile.isDirectory()) { gateway =
			 * BraintreeGatewayFactory.fromConfigFile(configFile); } else { gateway =
			 * BraintreeGatewayFactory.fromConfigMapping(System.getenv()); }
			 */
            gateway = new BraintreeGateway("sandbox", "pq3g22gmzs2rsvyd", "xxjkqyvf3pjbzdyb", "95dde088b69f81f82b966143e282eab6");
        } catch (NullPointerException e) {
            System.err.println("Could not load Braintree configuration from config file or system environment.");
            System.exit(1);
        }

        SpringApplication.run(Application.class, args);
    }
}
