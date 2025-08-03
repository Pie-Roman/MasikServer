package ru.pyroman.masik.data.note.cache.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import ru.pyroman.masik.data.note.cache.dto.NoteCacheDto

interface NoteCacheRepository : JpaRepository<NoteCacheDto, String> {

    @Query("SELECT n FROM NoteCacheDto n JOIN n.tags t WHERE t.id = :tagId")
    fun findAllByTagId(@Param("tagId") tagId: String): List<NoteCacheDto>
}