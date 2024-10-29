package br.com.alura.resource;

import br.com.alura.config.EnvConfig;
import br.com.alura.model.Athlete;
import br.com.alura.service.AthleteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import br.com.alura.repository.AthleteRepository;
import jakarta.transaction.Transactional;

@Path("/athlete")
public class AthleteResource {

    @Inject
    @RestClient
    AthleteService athleteService;

    @Inject
    AthleteRepository athleteRepository;

    @Inject
    EnvConfig envConfig;

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        String token = "Bearer " + envConfig.getAuthToken();
        Athlete athlete = athleteService.get(token);

        if (athlete == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Athlete not found")
                    .build();
        }

        if (athlete.getId() != null && athleteRepository.findById(athlete.getId()) != null) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("Athlete already exists")
                    .build();
        }


        Athlete newAthlete = createAthleteFromFetched(athlete);
        athleteRepository.persist(newAthlete);

        return Response.status(Response.Status.CREATED).entity(athlete).build();
    }

    private Athlete createAthleteFromFetched(Athlete fetchedAthlete) {
        Athlete newAthlete = new Athlete();
        newAthlete.setUsername(fetchedAthlete.getUsername());
        newAthlete.setFirstname(fetchedAthlete.getFirstname());
        newAthlete.setLastname(fetchedAthlete.getLastname());
        newAthlete.setCity(fetchedAthlete.getCity());
        newAthlete.setState(fetchedAthlete.getState());
        newAthlete.setCountry(fetchedAthlete.getCountry());
        newAthlete.setSex(fetchedAthlete.getSex());
        newAthlete.setWeight(fetchedAthlete.getWeight());
        return newAthlete;
    }
}