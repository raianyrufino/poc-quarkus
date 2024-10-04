package br.com.alura.config;

import io.github.cdimascio.dotenv.Dotenv;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnvConfig {

    private String authToken;

    @PostConstruct
    public void init() {
        Dotenv dotenv = Dotenv.load();
        authToken = dotenv.get("AUTH_TOKEN");
    }

    public String getAuthToken() {
        return authToken;
    }
}