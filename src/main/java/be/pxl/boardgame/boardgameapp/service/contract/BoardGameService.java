package be.pxl.boardgame.boardgameapp.service.contract;

import be.pxl.boardgame.boardgameapp.model.BoardGame;
import be.pxl.boardgame.boardgameapp.model.dto.BoardgameRequest;
import be.pxl.boardgame.boardgameapp.model.dto.BoardgameResponse;
import be.pxl.boardgame.boardgameapp.repository.IBoardGameRepository;
import be.pxl.boardgame.boardgameapp.service.IBoardGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
// import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardGameService implements IBoardGameService {

    private final IBoardGameRepository boardGameRepository;

    @Override
    public void addBoardGame(BoardgameRequest boardgameRequest) {
        BoardGame boardGame = BoardGame.builder()
                                        .name(boardgameRequest.getName()).build();
        boardGameRepository.save(boardGame);
    }

    @Override
    @Secured(value = "ROLE_ADMIN")
    public List<BoardgameResponse> getAllBoardGames() {
        List<BoardGame> boardGameList = boardGameRepository.findAll();
        return boardGameList.stream().map(this::mapToBoardGameResponse).toList();
    }

    private BoardgameResponse mapToBoardGameResponse(BoardGame boardGame) {
        return BoardgameResponse.builder()
                                .name(boardGame.getName()).build();
    }
}
