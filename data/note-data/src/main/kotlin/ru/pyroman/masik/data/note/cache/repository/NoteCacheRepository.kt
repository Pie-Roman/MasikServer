package ru.pyroman.masik.data.note.cache.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import ru.pyroman.masik.data.note.cache.dto.NoteCacheDto

interface NoteCacheRepository : JpaRepository<NoteCacheDto, String> {

    @Query("SELECT n FROM NoteCacheDto n JOIN n.tags t WHERE t.name = :tagName")
    fun findAllByTagName(@Param("tagName") tagName: String): List<NoteCacheDto>
}