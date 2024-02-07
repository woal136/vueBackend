package exercise.vuebackend.web.dtos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto implements Serializable {

    private Long id;
    private String writer;
    private String title;
    private String contents;
    private String password;
    private LocalDateTime writeDate;

    @Builder
    public BoardDto(Long id, String writer, String title, String contents, String password, LocalDateTime writeDate) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.password = password;
        this.writeDate = writeDate;
    }
}
