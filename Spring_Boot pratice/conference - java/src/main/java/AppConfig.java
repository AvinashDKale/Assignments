import com.pluralsight.repository.HibernateRepositoryImpl;
import com.pluralsight.repository.SpeakersRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean("spekerService")
    public SpeakerService getSpekerService(){
        SpeakerServiceImpl service =new SpeakerServiceImpl(getSpekerRepository());
       // service.setRepository(getSpekerRepository());
        return service;
    }

    @Bean(name = "spekerRepository")
    public SpeakersRepository getSpekerRepository(){
        return new HibernateRepositoryImpl();
    }
}
