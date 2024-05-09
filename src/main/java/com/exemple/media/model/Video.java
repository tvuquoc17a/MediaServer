package com.exemple.media.model;

import jakarta.persistence.*;

@Entity
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "filePath")
    private String filePath;
    private String shareLink;

    @Lob
    private byte[] data;

    public Video() {}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Video(long id, String name, String filePath, String shareLink) {
        this.id = id;
        this.name = name;
        this.filePath = filePath;
        this.shareLink = shareLink;
    }
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", filePath='" + filePath + '\'' +
                ", shareLink='" + shareLink + '\'' +
                '}';
    }
}
