package com.viepovsky.greeting;

import com.viepovsky.lang.Lang;
import com.viepovsky.lang.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

class GreetingService {
    static final String FALLBACK_NAME = "unknown user";
    static final Lang FALLBACK_LANG = new Lang(1L, "Hi", "en");
    private final Logger logger = LoggerFactory.getLogger(GreetingService.class);

    private LangRepository langRepository;

    GreetingService() {
        this(new LangRepository());
    }

    GreetingService(LangRepository langRepository) {
        this.langRepository = langRepository;
    }

    String prepareGreeting(String name, Long langId) {
        logger.info("Preparing greeting for name: " + name);
        langId = Optional.ofNullable(langId).orElse(FALLBACK_LANG.getId());
        String welcomeMessage = langRepository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMessage();
        String nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMessage + " " + nameToWelcome + " !";
    }
}
