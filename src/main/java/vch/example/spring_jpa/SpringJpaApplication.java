package vch.example.spring_jpa;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vch.example.spring_jpa.author.Author;
import vch.example.spring_jpa.author.AuthorRepository;
import vch.example.spring_jpa.my_resource.MyResource;
import vch.example.spring_jpa.my_resource.MyResourcesRepository;
import vch.example.spring_jpa.my_resource.video.Video;
import vch.example.spring_jpa.my_resource.video.VideoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static vch.example.spring_jpa.Helper.l;

//https://www.youtube.com/watch?v=mcl_nibV39s&list=PPSV 4.20

@SpringBootApplication
@RestController
public class SpringJpaApplication {
	private int j = (new Random().nextInt()) * (new Random().nextInt());

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
		l("done");
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository,
			VideoRepository videoRepository,
			MyResourcesRepository myResourcesRepository
	) {
		return args -> {
//			authorRepository.updateAuthorAge((short) 12, (long) 1);
			authorRepository.updateAuthorsAge((short) 13);
//			Faker faker = new Faker();
//			Author author = Author.builder()
//					.id(102L)
//					.firstName(faker.name().firstName())
//					.lastName(faker.name().lastName())
//					.email("updated2@m.com")
//					.createdAt(LocalDateTime.now())
//					.createdBy(100L)
//					.build();
//
//			authorRepository.save(author);
//			List<Author> ls = authorRepository.findAllByFirstNameContainingIgnoreCase("n");
//			l(ls.get(0).getEmail());
//			l(ls.size());

//			for (int i = 0; i <= 5; i++) {
//				Faker faker = new Faker();
//				Author author = Author.builder()
//						.firstName(faker.name().firstName())
//						.lastName(faker.name().lastName())
//						.age((short)20)
//						.email("def_" + i + "@m.com")
//						.createdAt(LocalDateTime.now())
//						.createdBy(100L)
//						.build();
//
//				authorRepository.save(author);
//			}
//			l("t2");
//			Author author = Author.builder()
//					.firstName("f" + i)
//					.lastName("l1" + i)
//					.email("e" + i + "@m.com")
//					.createdAt(LocalDateTime.now())
//					.build();
//			authorRepository.save(author);
//			Video video = Video.builder()
//					.name("video_tbl")
//					.url("video_url")
//					.length(23)
//					.build();
//			videoRepository.save(video);

//			MyResource r = MyResource.builder().name("test_parent_r").build();
//			myResourcesRepository.save(r);
		};
	}

	@GetMapping("xxx")
	public String getSting() {
		return "getSting";
	}
}
