package come.example.practiketaskspring1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class News {

    private Long id;
    private String title;
    private String text;
    private Instant date;

}
