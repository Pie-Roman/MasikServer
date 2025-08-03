package ru.pyroman.masik.data.note.network.mapper

import org.springframework.stereotype.Component
import ru.pyroman.masik.data.note.network.dto.NoteNetworkDto
import ru.pyroman.masik.domain.note.model.Note

@Component
class NoteNetworkMapper(
    private val noteBodyNetworkMapper: NoteBodyNetworkMapper,
) {

    fun map(model: Note): NoteNetworkDto {
        val body = noteBodyNetworkMapper.map(model.body)
        return NoteNetworkDto(
            id = model.id,
            body = body,
            dateCreated = model.dateCreated,
        )
    }
}