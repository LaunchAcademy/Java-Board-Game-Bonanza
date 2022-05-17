//package com.launchacademy.javaspringdata.seeders;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class BoardGameSeeder implements CommandLineRunner {
//
//  private BoardGameService boardGameService;
//
//  @Autowired
//  public BoardGameSeeder(
//      BoardGameService boardGameService) {
//    this.boardGameService = boardGameService;
//  }
//
//  @Override
//  public void run(String... args) throws Exception {
//
//    Map<String, String> seedMap = new HashMap<String, String>();
//    seedMap.put("Monopoly", "The classic game of capitalism");
//    seedMap.put("Wineopoly", "Monopoly, but with wine");
//    seedMap.put("Chess", "A strategy game between two players with no hidden information");
//    seedMap.put("Settlers of Catan", "a multiplayer board game designed by Klaus Teuber");
//    seedMap.put("Dogopoly", "Monopoly, but with Dogs.");
//    seedMap.put("Risk", "a multiplayer board game focused on world domination");
//    seedMap.put("Ticket to Ride", "Choo Choo!");
//
//    for(String name : seedMap.keySet()) {
//      List boardGames = boardGameService.findAllByName(name);
//      if(boardGames.size() == 0) {
//        BoardGame boardGame = new BoardGame();
//        boardGame.setName(name);
//        boardGame.setDescription(seedMap.get(name));
//        boardGameService.save(boardGame);
//      }
//    }
//  }
//}
