package ru.ioann.mst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ioann.mst.dto.Rating;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@EnableEurekaClient
@SpringBootApplication
@RequestMapping("/ratings")
public class RatingServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(RatingServiceApp.class, args);
    }

    private List<Rating> ratingList = Arrays.asList(
            new Rating(1L, 1L, 2),
            new Rating(2L, 1L, 3),
            new Rating(3L, 2L, 4),
            new Rating(4L, 2L, 5)
    );

    @GetMapping("")
    public List<Rating> findRatingsByBookId(@RequestParam Long bookId) {
        return bookId == null || bookId.equals(0L) ? Collections.EMPTY_LIST :
                ratingList.stream()
                        .filter(r -> r.bookId.equals(bookId))
                        .collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<Rating> findAllRatings() {
        return ratingList;
    }
}
