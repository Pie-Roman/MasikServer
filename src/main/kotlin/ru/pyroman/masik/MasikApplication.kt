package ru.pyroman.masik

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class NewsApplication

fun main(args: Array<String>) {
    runApplication<NewsApplication>(*args)
}