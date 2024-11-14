package come.example.practiketaskspring1.service;

import come.example.practiketaskspring1.entity.News;
import come.example.practiketaskspring1.service.configlength.ConfigLength;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NewsService implements DAOService<News> {

    private final ConcurrentHashMap<Long, News> storage = new ConcurrentHashMap<>();

    @Override
    public News getById(Long id) {
        if (storage.isEmpty()) {
            throw new RuntimeException("Storage is empty");
        }

        return storage.get(id);
    }

    @Override
    public Collection<News> getAll() {
        if (storage.isEmpty()) {
            throw new RuntimeException("Storage is empty");
        }
        return storage.values();
    }

    @Override
    public boolean create(News entity) {
        Long nextId = storage.isEmpty() ? 1 : Collections.max(storage.keySet()) + 1;
        entity.setId(nextId);

//        if (entity.getText().length() > ConfigLength.lengthMaxText) {
//            entity.setText(entity.getText().substring(0, ConfigLength.lengthMaxText));
//        }
//        if (entity.getTitle().length() > ConfigLength.lengthMaxTitle) {
//            entity.setTitle(entity.getTitle().substring(0, ConfigLength.lengthMaxTitle));
//        }

        storage.put(nextId, entity);
        return true;
    }

    @Override
    public boolean update(Long id, News entity) {
        if (!storage.containsKey(id)) return false;
        entity.setId(id);
        storage.put(id, entity);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        storage.remove(id);
        return true;
    }
}
