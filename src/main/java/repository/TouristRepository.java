package repository;

import model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository(){
        touristAttractionsPopulate();
    }

    public void touristAttractionsPopulate(){
        touristAttractions.add(new TouristAttraction("Tivoli", "Historisk forlystelsespark med rutsjebaner, smukke haver og underholdning."));
        touristAttractions.add(new TouristAttraction("Den Lille Havfrue", "Ikonisk bronzestatue inspireret af H.C. Andersens eventyr."));
        touristAttractions.add(new TouristAttraction("Nyhavn", "Farverig havnepromenade med restauranter, barer og historiske skibe."));
        touristAttractions.add(new TouristAttraction("Rosenborg Slot", "Renæssanceslot, der huser de danske kronjuveler og kongelige skatte."));
        touristAttractions.add(new TouristAttraction("Christiansborg Slot", "Regeringspalads med kongelige repræsentationslokaler og tårn med udsigt."));
        touristAttractions.add(new TouristAttraction("Rundetårn", "Historisk tårn fra 1600-tallet med en spiralrampe og flot udsigt over byen."));
    }



    public void addAttraction(TouristAttraction attraction){
        touristAttractions.add(attraction);
    }

    public List<TouristAttraction> getAllAttractions(){
        return touristAttractions;
    }


    public TouristAttraction findAttractionByName(String name){
        TouristAttraction temp = null;

        for(TouristAttraction toursAtr : touristAttractions){
            if(toursAtr.getName().equalsIgnoreCase(name)){
                temp = toursAtr;
            }

        }

        return temp;
    }


    public TouristAttraction updateTouristAttraction(String name, TouristAttraction updatedTouristAttraction){
        for(int i = 0; i < touristAttractions.size(); i++){
            if(touristAttractions.get(i).getName().equalsIgnoreCase(name)){
                touristAttractions.set(i, updatedTouristAttraction);
                return updatedTouristAttraction;
            }
        }
        return null;
    }



    public void deleteAttraction(String name){
        for(int i = 0; i < touristAttractions.size(); i++){
            if(touristAttractions.get(i).getName().equalsIgnoreCase(name)){
                touristAttractions.remove(i);
                break;
            }
        }
    }



}
