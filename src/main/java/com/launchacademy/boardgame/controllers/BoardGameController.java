package com.launchacademy.boardgame.controllers;

import com.launchacademy.boardgame.models.BoardGame;
import com.launchacademy.boardgame.services.BoardGameDatabaseService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board-games")
public class BoardGameController {

  private BoardGameDatabaseService service;

  @Autowired
  public BoardGameController(BoardGameDatabaseService service) {
    this.service = service;
  }

  @GetMapping
  public String getIndex(Model model) {
    model.addAttribute("boardGames", service.findAll());
    return "boardGames/index";
  }

  @GetMapping("/{id}")
  public String getShowPage(@PathVariable Long id, Model model) {
    Optional<BoardGame> foundGame = service.findById(id);

    if(foundGame.isPresent()) {
      model.addAttribute("boardGame", foundGame.get());
    }

    return "boardGames/show";
  }

  @GetMapping("/new")
  public String getForm(@ModelAttribute BoardGame boardGame) {
    return "boardGames/new";
  }

  @PostMapping
  public String createBoardGame(@ModelAttribute BoardGame boardGame) {
    service.save(boardGame);
    return "redirect:/board-games";
  }
}
