package nl.agileprof.mod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.agileprof.domain.Hero;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
@Path("heroes")
public class HeroService {

	@PersistenceContext
    private EntityManager entityManager;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hero> findAllHeroes(){
		return createHeroList();
	}
	
	private List<Hero> createHeroList(){
		List<Hero> heroes = new ArrayList<Hero>();
		heroes.add(new Hero(1,"arjen"));
		heroes.add(new Hero(2,"christi"));
		heroes.add(new Hero(3,"sam"));
		heroes.add(new Hero(4,"sverre"));
		return heroes;
	}
}
