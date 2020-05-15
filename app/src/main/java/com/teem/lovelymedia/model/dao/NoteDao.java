package com.teem.lovelymedia.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.teem.lovelymedia.model.entity.Note;

import java.util.List;

import io.reactivex.Flowable;

/**
 * 日记数据访问对象(必需是抽象类或者接口)
 * Database Access 数据库访问
 *
 * @author tangdi
 * @date 2020/05/15
 */
@Dao
public interface NoteDao {
    /**
     * 插入日记
     * 插入有冲突的时候的处理策略：取代旧数据同时继续事务
     *
     * @param notes 日记
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Note... notes);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int update(Note... notes);

    @Delete
    int delete(Note... notes);

    @Query("SELECT * FROM notes")
    LiveData<List<Note>> queryAllNotes();

    /**
     * @param date 日期
     * @return 返回某天的日志
     */
    @Query("SELECT * FROM notes WHERE date == :date")
    Flowable<List<Note>> queryNotes(String date);
}
