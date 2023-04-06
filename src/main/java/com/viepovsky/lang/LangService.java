package com.viepovsky.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class LangService {
    private final Logger logger = LoggerFactory.getLogger(LangService.class);

    private LangRepository repository;
    LangService() {
        this(new LangRepository());
    }

    LangService(LangRepository repository) {
        this.repository = repository;
    }

    List<LangDTO> findAll() {
        List<Lang> langList = repository.findAll();
        logger.info("Retrieved lang list size of: " + langList.size());
        return langList.stream().map(LangDTO::new).toList();
    }
}
