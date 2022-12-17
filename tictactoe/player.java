package SystemDesign.tictactoe;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class player {
    private String playername;
    private int id;
    private char symbol;
    player(String playername,int id,char symbol)
    {
        this.playername=playername;
        this.id=id;
        this.symbol=symbol;
    }
}
