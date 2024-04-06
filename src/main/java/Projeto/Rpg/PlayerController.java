package Projeto.Rpg;

import Projeto.Rpg.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @GetMapping("/player")
    public ResponseEntity<Player> getPlayer() {
        GeneratorQuest generator = new GeneratorQuest();
        Player player = generator.generatePlayer();
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
}
