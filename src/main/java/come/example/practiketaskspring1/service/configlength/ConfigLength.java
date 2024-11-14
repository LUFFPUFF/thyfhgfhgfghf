package come.example.practiketaskspring1.service.configlength;

import org.springframework.beans.factory.annotation.Value;

public class ConfigLength {

    @Value("${title.length.max}")
    public static Integer lengthMaxTitle;
    @Value("${text.length.max}")
    public static Integer lengthMaxText;
}
