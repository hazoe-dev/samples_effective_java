package factory.milk_company.initial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ingredient {
    private int numberOfMilkCartons;
    private  int numberOfMilkStickers;

    public void useACarton(){
        numberOfMilkCartons--;
    }

    public void useASticker(){
        numberOfMilkStickers--;
    }
}
