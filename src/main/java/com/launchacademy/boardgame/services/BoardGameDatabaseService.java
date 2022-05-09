package com.launchacademy.boardgame.services;

import com.launchacademy.boardgame.models.BoardGame;
import com.launchacademy.boardgame.repositories.BoardGameRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardGameDatabaseService implements BoardGameService {

  private BoardGameRepository repository;

  @Autowired
  public BoardGameDatabaseService(
      BoardGameRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<BoardGame> findAllByName(String name) {
    return repository.findAllByName(name);
  }

  @Override
  public void save(BoardGame boardGame) {
    repository.save(boardGame);
  }

  @Override
  public List<BoardGame> findAll() {
    return (List<BoardGame>)repository.findAll();
  }

  @Override
  public Optional<BoardGame> findById(Long id) {
    return repository.findById(id);
  }
}
