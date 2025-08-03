package ru.pyroman.masik.data.note.repository

import org.springframework.stereotype.Repository
import ru.pyroman.masik.data.note.cache.mapper.NoteTagCacheMapper
import ru.pyroman.masik.data.note.cache.repository.NoteTagCacheRepository
import ru.pyroman.masik.data.note.network.dto.NoteTagNetworkDto
import ru.pyroman.masik.data.note.network.mapper.NoteTagNetworkMapper
import kotlin.jvm.optionals.getOrNull

@Repository
class NoteTagRepository(
    private val noteTagCacheRepository: NoteTagCacheRepository,
    private val noteTagCacheMapper: NoteTagCacheMapper,
    private val noteTagNetworkMapper: NoteTagNetworkMapper,
) {

    fun findAll(): List<NoteTagNetworkDto> {
        val items = noteTagCacheRepository.findAll().map { dto ->
            noteTagCacheMapper.map(dto)
        }
        return items.map { model ->
            noteTagNetworkMapper.map(model)
        }
    }

    fun create(networkDto: NoteTagNetworkDto): NoteTagNetworkDto {
        val model = noteTagNetworkMapper.map(networkDto)
        val cacheDto = noteTagCacheMapper.map(model)
        noteTagCacheRepository.save(cacheDto)
        return noteTagNetworkMapper.map(model)
    }

    fun existsByName(name: String): Boolean {
        return noteTagCacheRepository.existsById(name)
    }

    fun deleteByName(name: String) {
        return noteTagCacheRepository.deleteById(name)
    }

    fun update(
        name: String,
        tagNetworkDto: NoteTagNetworkDto
    ): NoteTagNetworkDto {
        val oldCacheDto = requireNotNull(noteTagCacheRepository.findById(name).getOrNull())
        val oldModel = noteTagCacheMapper.map(oldCacheDto)
        val mergedModel = oldModel.copy(
            color = tagNetworkDto.color ?: oldModel.color
        )
        val mergedCacheDto = noteTagCacheMapper.map(mergedModel)
        noteTagCacheRepository.save(mergedCacheDto)
        val mergedNetworkDto = noteTagNetworkMapper.map(mergedModel)
        return mergedNetworkDto
    }
}