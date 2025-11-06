import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.copilot.demo.model.Customer;
import com.github.copilot.demo.repository.CustomerRepository;

@SpringBootApplication
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(@Autowired CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer("Alice", "alice@example.com"));
            customerRepository.save(new Customer("Bob", "bob@example.com"));
            customerRepository.save(new Customer("Charlie", "charlie@example.com"));
        };
    }
}

