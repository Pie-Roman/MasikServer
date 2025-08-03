package ru.pyroman.masik.data.note.network.mapper

import org.springframework.stereotype.Component
import ru.pyroman.masik.data.note.network.dto.NoteTagNetworkDto
import ru.pyroman.masik.domain.note.model.NoteTag

@Component
class NoteTagNetworkMapper {

    fun map(dto: NoteTagNetworkDto): NoteTag {
        val id = dto.id.orEmpty()
        val name = dto.name.orEmpty()
        val color = dto.color.orEmpty()

        return NoteTag(
            id = id,
            name = name,
            color = color,
        )
    }

    fun map(model: NoteTag): NoteTagNetworkDto {
        val id = model.id
        val name = model.name
        val color = model.color

        return NoteTagNetworkDto(
            id = id,
            name = name,
            color = color,
        )
    }
}