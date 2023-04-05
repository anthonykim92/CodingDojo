package com.codingdojo.burgerTracker1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.burgerTracker1.models.Burger;
import com.codingdojo.burgerTracker1.repositories.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	public List<Burger> allBurgers() {
        return burgerRepository.findAll();
}
	public Burger addBurger(Burger burger) {
		return burgerRepository.save(burger);

}
	}
