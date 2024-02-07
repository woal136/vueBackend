package exercise.vuebackend.services;

import exercise.vuebackend.entity.Board;
import exercise.vuebackend.entity.BoardRepository;
import exercise.vuebackend.web.dtos.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 목록
    public List<BoardDto> getBoardList() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtos = new ArrayList<>();

        for (Board board : boards) {
            BoardDto dto = BoardDto.builder()
                    .id(board.getId())
                    .writer(board.getWriter())
                    .title(board.getTitle())
                    .contents(board.getContents())
                    .password(board.getPassword())
                    .writeDate(board.getWriteDate())
                    .build();
            boardDtos.add(dto);
        }
        return boardDtos;
    }

    // 게시글 하나
    public BoardDto getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글이 없습니다."));
        return BoardDto.builder()
                .id(board.getId())
                .writer(board.getWriter())
                .title(board.getTitle())
                .contents(board.getContents())
                .password(board.getPassword())
                .writeDate(board.getWriteDate())
                .build();
    }

    // 게시글 등록
    public Board createBoard(BoardDto dto) {
        Board board = Board.builder()
                .writer(dto.getWriter())
                .title(dto.getTitle())
                .contents(dto.getContents())
                .password(dto.getPassword())
                .writeDate(LocalDateTime.now())
                .build();

        return boardRepository.save(board);
    }

    public Board updateBoard(BoardDto dto) {
        Board board = boardRepository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("게시글이 없습니다."));
        board.updateBoard(dto.getTitle(), dto.getContents(), LocalDateTime.now());

        // password 일치시 수정 필요
        return boardRepository.save(board);
    }

    // 게시글 삭제
    public void deleteBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글이 없습니다."));
        // password 일치시 삭제 필요
        boardRepository.delete(board);
    }

}
