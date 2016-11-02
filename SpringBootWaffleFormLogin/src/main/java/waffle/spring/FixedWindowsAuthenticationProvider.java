package waffle.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;

import com.sun.jna.platform.win32.Win32Exception;

public class FixedWindowsAuthenticationProvider extends WindowsAuthenticationProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(FixedWindowsAuthenticationProvider.class);

	@Override
	public Authentication authenticate(Authentication authentication) {
		try {
			return super.authenticate(authentication);
		} catch (Win32Exception e) {
			FixedWindowsAuthenticationProvider.LOGGER.warn("error logging in user: {}", e.getMessage());
			FixedWindowsAuthenticationProvider.LOGGER.trace("", e);
			String message = e.getMessage();
			if (message != null && message.contains("unknown user name or bad password")) {
				throw new BadCredentialsException(message, e);
			} else {
				throw new AuthenticationServiceException(
						"Connection to authentication server failed. Please review the logs for more information", e);
			}
		}
	}

}
