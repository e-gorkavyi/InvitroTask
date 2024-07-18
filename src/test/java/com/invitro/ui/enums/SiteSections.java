package com.invitro.ui.enums;

import java.util.Map;

public class SiteSections {

    private static final Map<String, String> sections = Map.of(
            "Пациентам", "/",
            "Врачам", "/doctors/",
            "Франчайзинг", "/franchize/",
            "Корпоративным клиентам", "/medical/",
            "Прессе", "/about/"
    );

    public static String getSectionUrl(String key) {
        return sections.get(key);
    }
}
