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

@Path("/athlete")
public class AthleteResource {

    @Inject
    @RestClient
    AthleteService athleteService;

    @Inject
    EnvConfig envConfig;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        String token = "Bearer " + envConfig.getAuthToken();
        Athlete athlete = athleteService.get(token);

        if (athlete == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Athlete not found")
                    .build();
        }

        return Response.ok(athlete).build();
    }
}