package com.launchacademy.boardgame.services;

import com.launchacademy.boardgame.models.BoardGame;
import java.util.List;
import java.util.Optional;

public interface BoardGameService {

  List<BoardGame> findAllByName(String name);

  void save(BoardGame boardGame);

  List<BoardGame> findAll();

  Optional<BoardGame> findById(Long id);
}
