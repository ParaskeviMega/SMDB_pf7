package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Film;
import com.pf7.smdb.domain.TVShow;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.TVShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tvshows")
public class TVShowController extends AbstractController<TVShow>{
    private  final TVShowService tvShowService;

    @Override
    protected BaseService<TVShow, Long> getBaseService() {
        return tvShowService;
    }

    @GetMapping(path = "/movie", params = {"title"})
    public TVShow getByTvShowTitle(@RequestParam("title") String title) {
        return tvShowService.findTvShowByTitleLike(title);
    }
}
