package com.realdolmen.omdbbootconsumer.service;

import com.realdolmen.omdbbootconsumer.http.OmdbApiCaller;
import com.realdolmen.omdbbootconsumer.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {

    private OmdbApiCaller omdbApiCaller;

    public Movie getMovie() {
        return omdbApiCaller.requestMovie();
    }
}
