package in.freshnews.getnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication
@EnableHystrix
@EnableAutoConfiguration
public class GetnewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetnewsApplication.class, args);
	}

}
