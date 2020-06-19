package com.teem.lovelymedia.model.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * @Description
 * @Copyright 2020 中金慈云健康科技有限公司
 * @Created by 汤迪 on 2020/06/19
 */
public class AppDatabaseHelper {

    private static final String DB_NAME = "android_room_dev.db";
    private AppDatabase mAppDatabase;

    public void initRoom(Context context) {
        mAppDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
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

    // 静态内部类的优点是：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。
    // 即当SingleTon第一次被加载时，并不需要去加载SingleTonHoler，只有当getInstance()方法第一次被调用时，
    // 才会去初始化INSTANCE,第一次调用getInstance()方法会导致虚拟机加载SingleTonHoler类，这种方法不仅能确
    // 保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
    public static class AppDatabaseHelperHolder {
        private static AppDatabaseHelper INSTANCE = new AppDatabaseHelper();
    }

    public static AppDatabaseHelper getInstance() {
        return AppDatabaseHelperHolder.INSTANCE;
    }
}
