package be.pxl.boardgame.boardgameapp.controller;

import be.pxl.boardgame.boardgameapp.model.dto.BoardgameRequest;
import be.pxl.boardgame.boardgameapp.model.dto.BoardgameResponse;
import be.pxl.boardgame.boardgameapp.service.contract.IBoardGameService;
import be.pxl.boardgame.boardgameapp.service.contract.LogExecutionTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boardgame")
@RequiredArgsConstructor
@Slf4j
public class BoardGameController {

    private final IBoardGameService boardGameService;

    @GetMapping
    public ResponseEntity<List<BoardgameResponse>> getAllBoardGames(){
        return new ResponseEntity<>(boardGameService.getAllBoardGames(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void getBoardGame(@PathVariable Long id){
        log.info("Get boardgame with id {}", id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBoardGame(@RequestBody BoardgameRequest boardgameRequest){
        boardGameService.addBoardGame(boardgameRequest);
    }

    /*
    @PostMapping("/exit")
    @ResponseStatus(HttpStatus.OK)
    public void logout(HttpServletRequest request){
        SecurityContextHolder.clearContext();
        request.getSession().invalidate();
    }
    */

}
