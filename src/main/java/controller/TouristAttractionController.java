package controller;


import model.TouristAttraction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.TouristAttractionService;

import java.util.List;

@Controller
//Skal have en base URL før HTML virker
@RequestMapping("/attraction")
public class TouristAttractionController {
    private final TouristAttractionService touristAttractionService;

    public TouristAttractionController(TouristAttractionService touristAttractionService){
        this.touristAttractionService = touristAttractionService;
    }

    //Get attractions
    @GetMapping("/attractions")
    public ResponseEntity<List<TouristAttraction>> getAllTouristAttractions(){
        List<TouristAttraction> touristAttractions = touristAttractionService.getAllAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    //GET attractions/{name}
    @GetMapping("/search")
    public ResponseEntity<TouristAttraction> getTouristAttractionByName(@RequestParam String name){
        TouristAttraction touristAttraction = touristAttractionService.findAttractionByName(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    //GET attractions/{name}/tags
    // Ikke skrevet i nu...


    //GET attractions/add
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction (@RequestBody TouristAttraction touristAttraction){
        TouristAttraction newTouristAttraction = touristAttractionService.addTourist(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }

    //POST attractions/save
    // Ikke skrevet i nu...


    //POST attractions/{name}/edit
    // Ikke skrevet i nu...


    //POST attractions/update
    //Skal laves om til POST...
    @PutMapping("/update/{name}")
    public ResponseEntity<TouristAttraction> updateAttraction(@PathVariable String name, @RequestBody TouristAttraction updatedTouristAttraction) {
        TouristAttraction updatedAttraction = touristAttractionService.updateTouristAttraction(name, updatedTouristAttraction);
        return new ResponseEntity<>(updatedAttraction, HttpStatus.OK);
    }


    //POST attractions/delete/{name}
    //Skal laves om til POST...
    @DeleteMapping("{name}") @ResponseBody
    public String deleteAttraction(@PathVariable String name) {
        touristAttractionService.deleteTouristAttraction(name);
        return "Tourist attraction with name " + name + " has been deleted.";
    }
}