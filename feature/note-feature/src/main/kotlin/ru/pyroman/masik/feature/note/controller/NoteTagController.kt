package ru.pyroman.masik.feature.note.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
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
    private val noteTagRepository: NoteTagRepository,
) {

    @GetMapping
    fun getAll(): List<NoteTagNetworkDto> {
        return noteTagRepository.findAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNoteTag(
        @RequestBody tag: NoteTagNetworkDto,
    ): NoteTagNetworkDto {
        return noteTagRepository.create(tag)
    }

    @PatchMapping("/{name}")
    fun updateNoteTag(
        @PathVariable name: String,
        @RequestBody tag: NoteTagNetworkDto
    ): NoteTagNetworkDto {
        return noteTagRepository.update(
            name = name,
            tagNetworkDto = tag,
        )
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteNoteTag(
        @PathVariable name: String
    ) {
        if (!noteTagRepository.existsByName(name))
            throw NoSuchElementException("NoteTag not found")
        noteTagRepository.deleteByName(name)
    }
}