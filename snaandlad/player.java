package SystemDesign.snaandlad;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class player {

    String Name;
    int Id;
    player(String Name,int Id)
    {
        this.Name=Name;
        this.Id=Id;
    }
}
