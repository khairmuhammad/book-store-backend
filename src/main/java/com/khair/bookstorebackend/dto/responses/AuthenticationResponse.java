package com.khair.bookstorebackend.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.khair.bookstorebackend.dto.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;

    //user properties
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
}
