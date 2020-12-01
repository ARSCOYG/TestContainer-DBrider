package com.example.demo.repository;

import com.example.demo.entity.hero.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRespository extends JpaRepository<Hero,String> {

    Hero findHeroById(String s);
}
