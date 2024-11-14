package come.example.practiketaskspring1.controller;

import come.example.practiketaskspring1.entity.News;
import come.example.practiketaskspring1.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/news")
public class NewsController {

    @Autowired
    private NewsService service;

    @GetMapping(path = "/{id}")
    public News getNews(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping()
    public Collection<News> getNews() {
        return service.getAll();
    }

    @PostMapping
    public boolean create(@RequestBody News news) {
        return service.create(news);
    }

    @PutMapping(path = "/{id}")
    public boolean update(@PathVariable Long id, @RequestBody News news) {
        return service.update(id, news);
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
