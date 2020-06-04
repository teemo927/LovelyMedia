package com.teem.lovelymedia.model.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.teem.lovelymedia.model.dao.NoteDao;
import com.teem.lovelymedia.model.entity.Note;

/**
 * @author tangdi
 * @date 2020/05/15
 */
@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();
}
