package ru.pyroman.masik.feature.note.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ru.pyroman.masik.data.note.network.dto.NoteTagNetworkDto
import ru.pyroman.masik.data.note.repository.NoteTagRepository

@RestController
@RequestMapping("/notes/tags")
class NoteTagController(
    private val noteRepository: NoteTagRepository,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNoteTag(
        @RequestBody tag: NoteTagNetworkDto,
    ): NoteTagNetworkDto {
        return noteRepository.create(tag)
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteNoteTag(
        @PathVariable name: String
    ) {
        if (!noteRepository.existsByName(name))
            throw NoSuchElementException("NoteTag not found")
        noteRepository.deleteByName(name)
    }
}