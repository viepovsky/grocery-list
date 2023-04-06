package com.viepovsky;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {
    private static final String WELCOME = "Hi";
    private static final String FALLBACK_ID_WELCOME = "Guten Tag";

    @Test
    public void test_prepareGreeting_nullName_returnsGreetingWithFallback() {
        //Given
        LangRepository mockRepository = alwaysReturnHiRepository();
        GreetingService SUT = new GreetingService(mockRepository);
        //When
        var result = SUT.prepareGreeting(null, "-1");
        //Then
        assertEquals(WELCOME + " " + "unknown user!", result);
    }

    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName() {
        //Given
        LangRepository mockRepository = alwaysReturnHiRepository();
        GreetingService SUT = new GreetingService(mockRepository);
        var name = "test";
        //When
        var result = SUT.prepareGreeting(name, "-1");
        //Then
        assertEquals(WELCOME + " " + name + "!", result);
    }

    @Test
    public void test_prepareGreeting_nullLang_returnsGreetingWithFallbackIdLang() {
        //Given
        LangRepository mockRepository = fallbackLangIdRepository();
        GreetingService SUT = new GreetingService(mockRepository);
        //When
        var result = SUT.prepareGreeting(null, null);
        //Then
        assertEquals(FALLBACK_ID_WELCOME + " " + GreetingService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_prepareGreeting_textLang_returnsGreetingWithFallbackIdLang() {
        //Given
        LangRepository mockRepository = fallbackLangIdRepository();
        GreetingService SUT = new GreetingService(mockRepository);
        //When
        var result = SUT.prepareGreeting(null, "abc");
        //Then
        assertEquals(FALLBACK_ID_WELCOME + " " + GreetingService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_prepareGreeting_nonExistingLang_returnsGreetingWithFallbackLang() {
        //Given
        LangRepository mockRepository = new LangRepository() {
            @Override
            Optional<Lang> findById(Long id) {
                return Optional.empty();
            }
        };
        GreetingService SUT = new GreetingService(mockRepository);
        //When
        var result = SUT.prepareGreeting(null, "-1");
        //Then
        assertEquals(WELCOME + " " + GreetingService.FALLBACK_NAME + "!", result);
    }

    private static LangRepository fallbackLangIdRepository() {
        return new LangRepository() {
            @Override
            Optional<Lang> findById(Long id) {
                if (id.equals(GreetingService.FALLBACK_LANG.getId())) {
                    return Optional.of(new Lang(null, FALLBACK_ID_WELCOME, null));
                }
                return Optional.empty();
            }
        };
    }

    private static LangRepository alwaysReturnHiRepository() {
        return new LangRepository() {
            @Override
            Optional<Lang> findById(Long id) {
                return Optional.of(new Lang(null, WELCOME, null));
            }
        };
    }
}