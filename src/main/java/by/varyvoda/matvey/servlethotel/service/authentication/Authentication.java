package by.varyvoda.matvey.servlethotel.service.authentication;

import lombok.Builder;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Builder
public class Authentication {

    private static final String TOKEN_SECTION_SEPARATOR = "?";

    private final UUID token;
    private final Date expirationDate;

    public Authentication(String template) {
        String decoded = new String(Base64.getDecoder().decode(template), StandardCharsets.UTF_8);
        token = UUID.fromString(decoded.substring(0, decoded.indexOf(TOKEN_SECTION_SEPARATOR)));
        expirationDate = new Date(Long.parseLong(decoded.substring(decoded.indexOf(TOKEN_SECTION_SEPARATOR) + 1)));
    }

    public boolean isExpired() {
        return expirationDate.before(new Date());
    }

    public String toString() {
        return Base64.getEncoder()
                .encodeToString((token + TOKEN_SECTION_SEPARATOR + expirationDate.getTime()).getBytes(StandardCharsets.UTF_8));
    }
}
