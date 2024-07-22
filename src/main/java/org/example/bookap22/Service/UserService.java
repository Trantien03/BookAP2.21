package org.example.bookap22.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.bookap22.Entity.AppUser;
import org.example.bookap22.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    public Optional<AppUser> findById(Long id) {
        return userRepository.findById(id);
    }

    public AppUser save(AppUser user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public AppUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public AppUser fetchUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
}

