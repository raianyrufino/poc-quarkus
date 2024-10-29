package br.com.alura.resource;

import br.com.alura.config.EnvConfig;
import br.com.alura.model.Athlete;
import br.com.alura.repository.AthleteRepository;
import br.com.alura.service.AthleteService;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AthleteResourceTest {

    @InjectMocks
    private AthleteResource athleteResource;

    @Mock
    private AthleteService athleteService;

    @Mock
    private AthleteRepository athleteRepository;

    @Mock
    private EnvConfig envConfig;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAthleteFound() {
        // Arrange
        String token = "Bearer some-token";
        Athlete mockAthlete = new Athlete(); // Crie uma instância de Athlete conforme necessário
        when(envConfig.getAuthToken()).thenReturn("some-token");
        when(athleteService.get(token)).thenReturn(mockAthlete);

        // Act
        Response response = athleteResource.get();

        // Assert
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertEquals(mockAthlete, response.getEntity());
    }

    @Test
    public void testGetAthleteNotFound() {
        // Arrange
        String token = "Bearer some-token";
        when(envConfig.getAuthToken()).thenReturn("some-token");
        when(athleteService.get(token)).thenReturn(null);

        // Act
        Response response = athleteResource.get();

        // Assert
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
        assertEquals("Athlete not found", response.getEntity());
    }
}