package com.care.CareWeb;

import com.twilio.jwt.accesstoken.AccessToken;
import com.twilio.jwt.accesstoken.VideoGrant;

public class Token {

    private final long id;
    private static final String ACCOUNT_SID = "ACb67d589e0ce9d697339d8ca0092b0b05";
    private static final String API_KEY_SID = "SK86d31ae222282433f99ca24725e0f4c5";
    private static final String API_KEY_SECRET = "OAZ3wsX2iPHVtTlP6m7CQEGywvrxxR3N";

    public Token(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        final VideoGrant grant = new VideoGrant();
        grant.setRoom("cool room");

        // Create an Access Token
        final AccessToken token = new AccessToken.Builder(ACCOUNT_SID, API_KEY_SID, API_KEY_SECRET)
                .identity(String.valueOf(id)) // Set the Identity of this token
                .grant(grant) // Grant access to Video
                .build();
        return token.toJwt();
    }
}
