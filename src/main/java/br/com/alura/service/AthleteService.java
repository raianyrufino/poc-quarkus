package br.com.alura.service;


import br.com.alura.model.Athlete;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/athlete")
@RegisterRestClient(baseUri = "https://www.strava.com/api/v3")
public interface AthleteService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Athlete get(@HeaderParam("Authorization") String authorization);
}