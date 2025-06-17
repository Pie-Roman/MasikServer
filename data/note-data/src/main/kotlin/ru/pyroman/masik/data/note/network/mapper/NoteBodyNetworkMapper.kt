package ru.pyroman.masik.data.note.network.mapper

import org.springframework.stereotype.Component
import ru.pyroman.masik.data.note.network.dto.NoteBodyNetworkDto
import ru.pyroman.masik.domain.note.model.NoteBody

@Component
class NoteBodyNetworkMapper {

    fun map(dto: NoteBodyNetworkDto?): NoteBody {
        val title = dto?.title.orEmpty()
        val isDone = dto?.isDone ?: false

        return NoteBody(
            title = title,
            isDone = isDone,
        )
    }

    fun map(model: NoteBody): NoteBodyNetworkDto {
        return NoteBodyNetworkDto(
            title = model.title,
            isDone = model.isDone,
        )
    }
}