package com.m.notepad.service.serviceImpl;

import com.m.notepad.dao.NoteDao;
import com.m.notepad.dao.UserDao;
import com.m.notepad.domain.Note;
import com.m.notepad.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/31
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteDao noteDao;
    @Autowired
    UserDao userDao;

    @Override
    public List<Note> queryNoteList(Map<String, Object> params) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        params.put("userName",userName);
        return noteDao.queryNoteList(params);
    }

    @Override
    public Integer count(Map<String, Object> params) {
        return noteDao.count(params);
    }

    @Override
    public Note queryNote(Map<String, Object> params) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        params.put("userName",userName);
        return noteDao.queryNote(params);
    }

    @Override
    public Boolean insertNote(Map<String, Object> params) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer userId = userDao.findUserIdByUserName(userName);
        params.put("userId",userId);
        Date date = new Date();
        params.put("creatTime",date);
        params.put("lastModifiedTime",date);
        Integer result = noteDao.insertNote(params);
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public Note updateNote(Map<String, Object> params) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer userId = userDao.findUserIdByUserName(userName);
        params.put("userId",userId);
        Date date = new Date();
        params.put("lastModifiedTime",date);
        Integer result = noteDao.updateNote(params);
        params.put("userName",userName);
        Note note = noteDao.queryNote(params);
        return note;
    }

    @Override
    public Boolean deleteNote(Map<String, Object> params) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer userId = userDao.findUserIdByUserName(userName);
        params.put("user_id",userId);
        Integer result = noteDao.deleteNote(params);
        if(result>0){
            return true;
        }
        return false;
    }

}
