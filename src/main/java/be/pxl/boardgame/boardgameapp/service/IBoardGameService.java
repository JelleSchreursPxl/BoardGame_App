package be.pxl.boardgame.boardgameapp.service;

import be.pxl.boardgame.boardgameapp.model.dto.BoardgameRequest;
import be.pxl.boardgame.boardgameapp.model.dto.BoardgameResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBoardGameService {
    void addBoardGame(BoardgameRequest boardgameRequest);

    List<BoardgameResponse> getAllBoardGames();
}
