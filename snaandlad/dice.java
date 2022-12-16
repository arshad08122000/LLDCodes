package SystemDesign.snaandlad;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dice {
    private int noofdice;
    dice(int noofdice)
    {
        this.noofdice=noofdice;
    }


    int rolldice()
    {
        return ((int) (Math.random()*(6*noofdice - 1*noofdice))) + 1;
    }



}
