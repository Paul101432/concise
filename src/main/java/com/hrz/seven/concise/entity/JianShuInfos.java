package com.hrz.seven.concise.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 2017/6/10.
 */
public class JianShuInfos {
    private String title;
    private String author;
    private String url;
    private String time;

    public static List<JianShuInfos> infos = new ArrayList<JianShuInfos>();

    public JianShuInfos(String title, String author, String url,String time) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.time = time;
    }

    public JianShuInfos setInfos(List<JianShuInfos> infos) {
        this.infos = infos;
        return this;
    }


    public List<JianShuInfos> addInfos(JianShuInfos info) {
        infos.add(info);
        return infos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "JianShuInfos{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
