package hu.unideb.inf.webfejlbeadando.ingamehero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class InGameHeroService {

    private final InGameHeroRepository inGameHeroRepository;

    @Autowired
    public InGameHeroService(InGameHeroRepository inGameHeroRepository) {
        this.inGameHeroRepository = inGameHeroRepository;
    }

    public List<InGameHero> getInGameHero(){
        return inGameHeroRepository.findAll();
    }

    public void addNewInGameHero(InGameHero inGameHero) {
        inGameHeroRepository.save(inGameHero);
    }

    public void deleteInGameHero(Long ingameheroId){
        boolean exists = inGameHeroRepository.existsById(ingameheroId);
        if(!exists) {
            throw new IllegalStateException("ingamehero with id "+ ingameheroId + " does not exist");
        }
        inGameHeroRepository.deleteById(ingameheroId);
    }

    @Transactional
    public InGameHero updateInGameHero(Long ingameheroId, String name, String sex, String vision, String constellation, Integer rarity){
        InGameHero inGameHero = inGameHeroRepository.findById(ingameheroId)
                .orElseThrow(() -> new IllegalStateException("ingamehero with id "+ ingameheroId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(inGameHero.getName(), name)){
            inGameHero.setName(name);
        }
        if (sex != null && sex.length() > 0 && !Objects.equals(inGameHero.getSex(), sex)){
            inGameHero.setSex(sex);
        }
        if (vision != null && vision.length() > 0 && !Objects.equals(inGameHero.getVision(), vision)){
            inGameHero.setVision(vision);
        }
        if (constellation != null && constellation.length() > 0 && !Objects.equals(inGameHero.getConstellation(), constellation)){
            inGameHero.setConstellation(constellation);
        }
        if (rarity != null && rarity > 0 && !Objects.equals(inGameHero.getRarity(), rarity)){
            inGameHero.setRarity(rarity);
        }
        return inGameHero;
    }
}
