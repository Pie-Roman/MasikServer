package ru.pyroman.masik.data.note.cache.mapper

import org.springframework.stereotype.Component
import ru.pyroman.masik.data.note.cache.dto.NoteCacheDto
import ru.pyroman.masik.domain.note.model.Note
import ru.pyroman.masik.domain.note.model.NoteBody

@Component
class NoteCacheMapper {

    fun map(dto: NoteCacheDto): Note {
        val body = NoteBody(
            title = dto.title,
            isDone = dto.isDone,
        )
        return Note(
            id = dto.id,
            body = body,
            dateCreated = dto.dateCreated,
        )
    }

    fun map(model: Note): NoteCacheDto {
        return NoteCacheDto(
            id = model.id,
            title = model.body.title,
            isDone = model.body.isDone,
            dateCreated = model.dateCreated,
        )
    }
}