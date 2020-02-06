package com.m.notepad.service;

import com.m.notepad.domain.Note;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

@CacheConfig(cacheNames = "note")
public interface NoteService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    List<Note> queryNoteList(Map<String, Object> params);

    /**
     * 查询总数
     * @param params
     * @return
     */
    Integer count(Map<String, Object> params);

    /**
     * 查询单个日记
     * @param params
     * @return
     */
    @Cacheable(key = "#params.get('id')")
    Note queryNote(Map<String, Object> params);

    /**
     * 修改日记
     * @param params
     * @return
     */
    @CachePut(key = "#params.get('id')")
    Note updateNote(Map<String, Object> params);

    /**
     * 删除日记
     * @param params
     * @return
     */
    @CacheEvict(key = "#params.get('id')",allEntries = true)
    Boolean deleteNote(Map<String, Object> params);

    /**
     * 新增日记
     * @param params
     * @return
     */
    Boolean insertNote(Map<String, Object> params);

}
