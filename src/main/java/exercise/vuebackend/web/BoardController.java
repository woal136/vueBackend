package exercise.vuebackend.web;

import exercise.vuebackend.entity.Board;
import exercise.vuebackend.services.BoardService;
import exercise.vuebackend.web.dtos.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
// cors 문제 해결
@CrossOrigin
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public List<BoardDto> boardList() {
        return boardService.getBoardList();
    }

    @GetMapping("/board/{id}")
    public BoardDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @PostMapping("/board")
    public Board createBoard(@RequestBody BoardDto dto) {
        return boardService.createBoard(dto);
    }

    @PatchMapping("/board")
    public Board updateBoard(@RequestBody BoardDto dto) {
        return boardService.updateBoard(dto);
    }

    @DeleteMapping("/board/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }

}
