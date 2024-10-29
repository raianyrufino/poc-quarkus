package br.com.alura.repository;

import br.com.alura.model.Athlete;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AthleteRepository implements PanacheRepository<Athlete> {
}