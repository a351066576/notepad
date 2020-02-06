package com.m.notepad.controller;

import com.m.notepad.annotation.Log;
import com.m.notepad.domain.Note;
import com.m.notepad.service.serviceImpl.NoteServiceImpl;
import com.m.notepad.utils.PageUtils;
import com.m.notepad.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author 酸辣粉
 * @description
 * @date 2020/1/31
 */
@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    NoteServiceImpl noteService;

    @Log("日记分页查询")
    @GetMapping("/queryNoteList")
    @ResponseBody
    public PageUtils queryNoteList(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Note> noteList = noteService.queryNoteList(query);
        int total = noteService.count(query);
        PageUtils pageUtil = new PageUtils(noteList, total);
        return pageUtil;
    }

    /**
     * 跳转日记详情界面
     * @param params
     * @param model
     * @return
     */
    @Log("访问日记详情界面")
    @GetMapping("/queryNote")
    public String queryNote(@RequestParam Map<String, Object> params, Model model) {
        Note note =  noteService.queryNote(params);
        model.addAttribute("note",note);
        return "note";
    }

    /**
     * 跳转添加日记界面
     * @return
     */
    @Log("访问添加日记界面")
    @RequestMapping("/addNote")
    public String addNote(){
        return "addnote";
    }

    /**
     * 跳转修改日记界面
     * @param params
     * @param model
     * @return
     */
    @Log("访问修改日记界面")
    @GetMapping("/updateNote")
    public String updateNote(@RequestParam Map<String, Object> params, Model model) {
        Note note =  noteService.queryNote(params);
        model.addAttribute("note",note);
        return "updatenote";
    }


    @Log("新增日记")
    @RequestMapping("insert")
    @ResponseBody
    public String insertNote(@RequestParam Map<String, Object> params){
        Boolean flag = noteService.insertNote(params);
        if(flag){
            return "OK";
        }
        return null;
    }

    @Log("更新日记")
    @RequestMapping("update")
    @ResponseBody
    public String update(@RequestParam Map<String, Object> params){
        Note note = noteService.updateNote(params);
        if(note!=null){
            return "OK";
        }
        return null;
    }

    @Log("删除日记")
    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Map<String, Object> params){
        Boolean flag = noteService.deleteNote(params);
        if(flag){
            return "OK";
        }
        return null;
    }

}
