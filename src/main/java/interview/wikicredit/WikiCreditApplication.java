package interview.wikicredit;

import interview.wikicredit.controller.CompanyController;
import interview.wikicredit.controller.WikiLoadingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class WikiCreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikiCreditApplication.class, args);
	}

}
