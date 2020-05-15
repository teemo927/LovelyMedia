package com.teem.lovelymedia.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * 日记
 * 设置表名、索引(唯一索引，重复会报错)
 *
 * @author tangdi
 * @date 2020/05/15
 */
@Entity(tableName = "notes", indices = {@Index(value = "id", unique = true),
        @Index(value = {"date"})})
public class Note {
    /**
     * 主键（至少一个）、自增
     */
    @PrimaryKey(autoGenerate = true)
    public int id;

    /**
     * 日期 2020-05-15
     */
    @ColumnInfo(name = "date")
    public String date;

    public String dateLong;
    /**
     * 标题
     */
    public String title;
    /**
     * 内容
     */
    public String content;
    /**
     * 字数统计
     */
    public int count;
}
