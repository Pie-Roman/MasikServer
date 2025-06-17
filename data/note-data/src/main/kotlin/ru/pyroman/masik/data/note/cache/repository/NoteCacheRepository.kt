package ru.pyroman.masik.data.note.cache.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.pyroman.masik.data.note.cache.dto.NoteCacheDto

interface NoteCacheRepository : JpaRepository<NoteCacheDto, String>