package com.launchacademy.boardgame.repositories;

import com.launchacademy.boardgame.models.BoardGame;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardGameRepository extends CrudRepository<BoardGame, Long> {

  List<BoardGame> findAllByName(String name);
}
