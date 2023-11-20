package com.parakramaba.springbootsecurity.exception;

/**
 * This class holds set of reusable constants for error messages.
 */
public final class ErrorMessages {

    // RESOURCE NOT FOUND MESSAGES
    public static final String ROLE_NOT_FOUND_MSG = "Role not found : ";
    public static final String USER_NOT_FOUND_MSG = "User not found : ";

    // AUTHENTICATION/AUTHORIZATION MESSAGES
    public static final String CREDENTIALS_NOT_MATCH_MSG = "The username and password you entered did not match our records " +
            "Please double-check and try again";
    public static final String INVALID_JWT_FORMAT_MSG = "JWT is not in the valid format. Please try again after re-sign-in " +
            "If this issue still exists, please contact the system admin";
    public static final String JWT_NOT_MATCH_MSG = "JWT does not match";
    public static final String JWT_EXPIRED_MSG = "JWT has expired. Please sign-in again";
    public static final String ACCESS_DENIED_MSG = "You have no permission to access this resource";

    private ErrorMessages(){}
}
