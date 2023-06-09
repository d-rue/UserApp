package de.drue.UserApp.Service;

import de.drue.UserApp.Model.UserPrincipal;
import de.drue.UserApp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username)
                .map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }
}
