package ru.pyroman.masik.data.note.repository

import org.springframework.stereotype.Repository
import ru.pyroman.masik.data.note.cache.mapper.NoteCacheMapper
import ru.pyroman.masik.data.note.cache.repository.NoteCacheRepository
import ru.pyroman.masik.data.note.network.dto.NoteBodyNetworkDto
import ru.pyroman.masik.data.note.network.dto.NoteListNetworkDto
import ru.pyroman.masik.data.note.network.dto.NoteNetworkDto
import ru.pyroman.masik.data.note.network.mapper.NoteBodyNetworkMapper
import ru.pyroman.masik.data.note.network.mapper.NoteNetworkMapper
import ru.pyroman.masik.domain.note.model.Note
import java.time.LocalDateTime
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

@Repository
class NoteRepository(
    private val noteCacheRepository: NoteCacheRepository,
    private val noteCacheMapper: NoteCacheMapper,
    private val noteNetworkMapper: NoteNetworkMapper,
    private val noteBodyNetworkMapper: NoteBodyNetworkMapper,
) {

    fun findAll(): NoteListNetworkDto {
        val items = noteCacheRepository.findAll().map { dto ->
            noteCacheMapper.map(dto)
        }
        val itemsNetworkDto = items.map { model ->
            noteNetworkMapper.map(model)
        }
        return NoteListNetworkDto(
            items = itemsNetworkDto,
        )
    }

    fun create(bodyNetworkDto: NoteBodyNetworkDto): NoteNetworkDto {
        val bodyModel = noteBodyNetworkMapper.map(bodyNetworkDto)
        val model = Note(
            id = UUID.randomUUID().toString(),
            body = bodyModel,
            dateCreated = LocalDateTime.now(),
        )

        val cacheDto = noteCacheMapper.map(model)
        noteCacheRepository.save(cacheDto)
        return noteNetworkMapper.map(model)
    }

    fun existsById(id: String): Boolean {
        return noteCacheRepository.existsById(id)
    }

    fun deleteById(id: String) {
        return noteCacheRepository.deleteById(id)
    }

    fun update(
        id: String,
        bodyNetworkDto: NoteBodyNetworkDto
    ): NoteNetworkDto {
        val oldCacheDto = requireNotNull(noteCacheRepository.findById(id).getOrNull())
        val oldModel = noteCacheMapper.map(oldCacheDto)
        val mergedModel = oldModel.copy(
            body = oldModel.body.copy(
                title = bodyNetworkDto.title ?: oldModel.body.title,
                isDone = bodyNetworkDto.isDone ?: oldModel.body.isDone,
            )
        )
        val mergedCacheDto = noteCacheMapper.map(mergedModel)
        noteCacheRepository.save(mergedCacheDto)
        val mergedNetworkDto = noteNetworkMapper.map(mergedModel)
        return mergedNetworkDto
    }
}