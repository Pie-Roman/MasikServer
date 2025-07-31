package ru.pyroman.masik.data.note.network.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class NoteListNetworkDto(
    val tags: List<NoteTagNetworkDto?>?,
    val items: List<NoteNetworkDto?>?,
)