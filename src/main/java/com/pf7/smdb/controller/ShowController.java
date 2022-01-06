package com.pf7.smdb.controller;

import com.pf7.smdb.domain.Show;
import com.pf7.smdb.service.BaseService;
import com.pf7.smdb.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shows")
public class ShowController extends AbstractController<Show>{
    private  final ShowService showService;

    @Override
    protected BaseService<Show, Long> getBaseService() {
        return showService;
    }

//    @GetMapping(path = "/movie", params = {"title"})
//    public Show getByTvShowTitle(@RequestParam("title") String title) {
//        return showService.findTvShowByTitleLike(title);
//    }
}
