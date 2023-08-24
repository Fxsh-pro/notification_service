package faang.school.notificationservice.message;

import faang.school.notificationservice.dto.event.EventDto;
import faang.school.notificationservice.dto.UserDto;
import faang.school.notificationservice.dto.event.EventType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
@Slf4j
public class AchievementMessageBuilder implements MessageBuilder {

    private final MessageSource messageSource;

    @Override
    public String buildMessage(UserDto userDto, EventDto eventDto) {
        String message = getPredefinedMessageForCurrentLocale(userDto.getUsername());
        log.info("Message for user:{} has built successfully", userDto.getUsername());
        return message;
    }

    private String getPredefinedMessageForCurrentLocale(String userName) {
        Locale locale = LocaleContextHolder.getLocale();
        return getPredefinedMessage(locale, userName);
    }

    private String getPredefinedMessage(Locale locale, String userName) {
        return messageSource.getMessage("achievement.new", new String[]{userName}, locale);
    }

    public EventType getEventType() {
        return EventType.ACHIEVEMENT_EVENT;
    }
}