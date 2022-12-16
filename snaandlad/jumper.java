package SystemDesign.snaandlad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class jumper {
    private
    int stpoint;
    int edpoint;
    jumper(int stpoint,int edpoint){
        this.stpoint=stpoint;
        this.edpoint=edpoint;
    }
}
