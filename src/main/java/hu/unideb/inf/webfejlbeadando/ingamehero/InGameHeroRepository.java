package hu.unideb.inf.webfejlbeadando.ingamehero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InGameHeroRepository extends JpaRepository<InGameHero,Long> {

}
