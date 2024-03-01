package vch.example.spring_jpa;

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
import java.util.Random;

import static vch.example.spring_jpa.Helper.l;

//https://www.youtube.com/watch?v=mcl_nibV39s&list=PPSV 3:12

@SpringBootApplication
@RestController
public class SpringJpaApplication {
	private int i = (new Random().nextInt()) * (new Random().nextInt());

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
		l("t1");
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository,
			VideoRepository videoRepository,
			MyResourcesRepository myResourcesRepository
	) {
		return args -> {
//			Author author = Author.builder()
//					.firstName("f" + i)
//					.lastName("l1" + i)
//					.email("e" + i + "@m.com")
//					.createdAt(LocalDateTime.now())
//					.build();
//			authorRepository.save(author);
			Video video = Video.builder()
					.name("test_video")
					.url("test_url")
					.length(23)
					.build();
			videoRepository.save(video);

			MyResource r = MyResource.builder()
					.name("test_parent_r")
					.build();
			myResourcesRepository.save(r);
		};
	}

	@GetMapping("xxx")
	public String getSting() {
		return "getSting";
	}
}
