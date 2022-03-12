package com.example.historydiseases.core.util;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

@UtilityClass
@Slf4j
public class I18NUtils {
    private static MessageSource messageSource;

    public static List<String> listOfSupportedLanguages() {
        return Arrays.asList(Locale.getISOLanguages());
    }

    public static void setMessageSource(MessageSource messageSource) {
        I18NUtils.messageSource = messageSource;
    }

    public static String buildMessage(String key, Object[] params) {
        try {
            return messageSource.getMessage(key, params, currentLocale());
        } catch (Exception e) {
            logExceptionMessage(e);
        }
        return null;
    }

    public static String buildMessage(String key, Object[] params, String langKey) {
        try {
            return messageSource.getMessage(key, params, getLocaleFromLanguageKey(langKey));
        } catch (NoSuchMessageException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String buildMessage(String key, Object[] params, Locale locale) {
        try {
            return messageSource.getMessage(key, params, locale);
        } catch (NoSuchMessageException e) {
            logExceptionMessage(e);
        }
        return null;
    }

    public static Locale getLocaleFromLanguageKey(String langKey) {
        var locale = Locale.getDefault();
        if (langKey != null) {
            var lang = Locale.forLanguageTag(langKey);
            if (lang != null && !lang.getCountry().isEmpty()) {
                locale = Locale.forLanguageTag(langKey);
            }
        }
        return locale;
    }

    public static Locale currentLocale() {
        return LocaleContextHolder.getLocale();
    }

    public static String currentLocaleCountryNameInLowerCase() {
        var countryCode = currentLocale().getCountry().toLowerCase();
        if (countryCode.isEmpty()) {
            countryCode = Locale.getDefault().getCountry().toLowerCase();
        }
        return countryCode;
    }

    private static void logExceptionMessage(Exception e) {
        log.error("Could not find a message key in messages.", e);
    }

}
