package ru.pyroman.masik.data.note.cache.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.pyroman.masik.data.note.cache.dto.NoteTagCacheDto

interface NoteTagCacheRepository : JpaRepository<NoteTagCacheDto, String>