package ru.pyroman.masik.feature.note.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ru.pyroman.masik.data.note.network.dto.NoteBodyNetworkDto
import ru.pyroman.masik.data.note.network.dto.NoteListNetworkDto
import ru.pyroman.masik.data.note.network.dto.NoteNetworkDto
import ru.pyroman.masik.data.note.repository.NoteRepository

@RestController
@RequestMapping("/notes")
class NoteController(
    private val noteRepository: NoteRepository,
) {

    @GetMapping
    fun getAll(): NoteListNetworkDto {
        return noteRepository.findAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNote(
        @RequestBody body: NoteBodyNetworkDto,
    ): NoteNetworkDto {
        return noteRepository.create(body)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteNote(
        @PathVariable id: String
    ) {
        if (!noteRepository.existsById(id))
            throw NoSuchElementException("Note not found")
        noteRepository.deleteById(id)
    }

    @PatchMapping("/{id}")
    fun updateIsDone(
        @PathVariable id: String,
        @RequestParam isDone: Boolean
    ): NoteNetworkDto {
        val dto = NoteBodyNetworkDto(
            isDone = isDone,
        )
        return noteRepository.update(
            id = id,
            bodyNetworkDto = dto,
        )
    }
}