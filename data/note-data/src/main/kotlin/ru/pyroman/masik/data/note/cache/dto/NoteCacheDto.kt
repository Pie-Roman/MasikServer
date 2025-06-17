package ru.pyroman.masik.data.note.cache.dto

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "notes")
data class NoteCacheDto(
    @Id
    val id: String = UUID.randomUUID().toString(),
    @Column(nullable = false)
    val title: String = "",
    @Column(nullable = false)
    val isDone: Boolean = false,
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val dateCreated: LocalDateTime = LocalDateTime.now()
)