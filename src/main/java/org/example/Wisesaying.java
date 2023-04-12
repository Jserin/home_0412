package org.example;

// 명언번호와 명언 작가 변수를 받고 반환해주는 엔티티 클래스 생성
public class Wisesaying {
    private final long id;
    private final String content;
    private final String author;

    Wisesaying (long id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String  getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}
