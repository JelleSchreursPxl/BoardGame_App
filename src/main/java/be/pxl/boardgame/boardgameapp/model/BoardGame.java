package be.pxl.boardgame.boardgameapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "boardgame")
@Data
@Builder
@NoArgsConstructor          // constructor zonder argumenten = reduce boilerplate code
@AllArgsConstructor         // constructor met alle argumenten = reduce boilerplate code
public class BoardGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


}
