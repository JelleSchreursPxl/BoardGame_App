package be.pxl.boardgame.boardgameapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder                            // default builder class beschikbaar voor unit testen
@NoArgsConstructor
@AllArgsConstructor
public class BoardgameRequest {     // uitvoeren van request
    private String name;
}
