package ru.pyroman.masik.data.note.cache.dto

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "tags")
data class NoteTagCacheDto(
    @Id
    val name: String = "",

    @Column(nullable = false)
    val color: String = "",

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    val notes: Set<NoteCacheDto> = emptySet()
)
