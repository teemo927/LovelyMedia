package com.teem.lovelymedia;

import android.app.Application;

import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.teem.lovelymedia.model.db.AppDatabase;

/**
 * @author tangdi
 * @date 2020/05/16
 */
public class AppApplication extends Application {

    private static final String DB_NAME = "android_room_dev.db";
    private AppDatabase mAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        initRoom();
    }

    private void initRoom() {
        mAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

    /**
     * 数据库版本 1->2 user表格新增了age列
     */
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE User ADD COLUMN age integer");
        }
    };

    /**
     * 数据库版本 2->3 新增book表格
     */
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `book` (`uid` INTEGER PRIMARY KEY autoincrement, `name` TEXT , `userId` INTEGER, 'time' INTEGER)");
        }
    };
}
