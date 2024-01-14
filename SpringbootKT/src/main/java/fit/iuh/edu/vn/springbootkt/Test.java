package fit.iuh.edu.vn.springbootkt;
import fit.iuh.edu.vn.springbootkt.entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import fit.iuh.edu.vn.springbootkt.repositories.userRepositories;
@SpringBootApplication
public class Test {
    @Autowired
    private userRepositories userRepository;

    public  Test() {
    }
    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            public void run(String... args) throws Exception {
                for(int i = 1; i <= 5; ++i) {
                    user User =  Test.this.userRepository.save(new user(i,"user"));
                    System.out.println("user with ID: " + User.getId() + " and Name: " + User.getName());

                }

            }
        };
    }
}
