package ru.pyroman.masik.data.note.cache.mapper

import org.springframework.stereotype.Component
import ru.pyroman.masik.data.note.cache.dto.NoteTagCacheDto
import ru.pyroman.masik.domain.note.model.NoteTag

@Component
class NoteTagCacheMapper {

    fun map(dto: NoteTagCacheDto): NoteTag {
        val id = dto.id
        val name = dto.name
        val color = dto.color

        return NoteTag(
            id = id,
            name = name,
            color = color,
        )
    }

    fun map(model: NoteTag): NoteTagCacheDto {
        val name = model.name
        val color = model.color
        val id = model.id

        return if (id.isEmpty()) {
            NoteTagCacheDto(
                name = name,
                color = color,
            )
        } else {
            NoteTagCacheDto(
                id = id,
                name = name,
                color = color,
            )
        }
    }
}