package ru.pyroman.masik.data.note.cache.dto

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tags")
data class NoteTagCacheDto(
    @Id
    val id: String = UUID.randomUUID().toString(),

    @Column(nullable = false)
    val name: String = "",

    @Column(nullable = false)
    val color: String = "",

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    val notes: MutableList<NoteCacheDto> = mutableListOf()
)
