package hu.unideb.inf.webfejlbeadando.ingamehero;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ingamehero")
public class InGameHeroController {

    private final InGameHeroService inGameHeroService;

    @Autowired
    public InGameHeroController(InGameHeroService inGameHeroService) {
        this.inGameHeroService = inGameHeroService;
    }

    @GetMapping
    public List<InGameHero> getInGameHero(){
        return inGameHeroService.getInGameHero();
    }

    @PostMapping
    public InGameHero registerNewInGameHero(@RequestBody InGameHero inGameHero){
        inGameHeroService.addNewInGameHero(inGameHero);
        return inGameHero;
    }

    @DeleteMapping(path ="{ingameheroId}")
    public void deleteInGameHero(@PathVariable("ingameheroId") Long ingameheroId){
        inGameHeroService.deleteInGameHero(ingameheroId);
    }

    @PutMapping(path = "{ingameheroId}")
    public InGameHero updateInGameHero(
            @PathVariable("ingameheroId") Long ingameheroId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String sex,
            @RequestParam(required = false) String vision,
            @RequestParam(required = false) String constellation,
            @RequestParam(required = false) Integer rarity) {
        return inGameHeroService.updateInGameHero(ingameheroId, name, sex, vision, constellation, rarity);
    }
}
