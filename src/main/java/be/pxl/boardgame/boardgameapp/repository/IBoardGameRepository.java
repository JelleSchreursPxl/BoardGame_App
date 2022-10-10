package be.pxl.boardgame.boardgameapp.repository;

import be.pxl.boardgame.boardgameapp.model.BoardGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoardGameRepository extends JpaRepository<BoardGame, Long> {

}
