package exercise.vuebackend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;
    private String title;
    private String contents;
    private String password;
    private LocalDateTime writeDate;

    @Builder
    public Board(Long id, String writer, String title, String contents, String password, LocalDateTime writeDate) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.password = password;
        this.writeDate = writeDate;
    }

    public void updateBoard(String title, String contents, LocalDateTime writeDate) {
        this.title = title;
        this.contents = contents;
        this.writeDate = writeDate;
    }
}
