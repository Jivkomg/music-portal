package uni.sofia.master.musicportal.services;

import uni.sofia.master.musicportal.models.User;
import uni.sofia.master.musicportal.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Transactional
    public void registerUser(User user) {
        // Check if the username is available
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }

        // Set initial credits for the user (you can customize this logic)
        user.setCredit(100.0);

        // Hash the user's password before saving
        user.setPassword(hashPassword(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void rechargeAccount(Long userId, Double amount) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Add the recharge amount to the user's credit
        user.setCredit(user.getCredit() + amount);
        userRepository.save(user);
    }

    // Hash the password using BCrypt
    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
}
