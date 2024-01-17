package bo.usfx.countries_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public final class WebServicesCountryApplication {
    private WebServicesCountryApplication() {

    }

    public static void main(final String[] args) {
        SpringApplication.run(WebServicesCountryApplication.class, args);
    }

}
