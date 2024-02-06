package uni.sofia.master.musicportal.services;

import uni.sofia.master.musicportal.models.Album;
import uni.sofia.master.musicportal.models.User;
import uni.sofia.master.musicportal.repositories.AlbumRepository;
import uni.sofia.master.musicportal.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository, UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
    }

    public Album getAlbumById(Long albumId) {
        return albumRepository.findById(albumId).orElse(null);
    }

    @Transactional
    public void buyAlbum(Long userId, Long albumId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new RuntimeException("Album not found"));

        // Check if the user has enough credits to buy the album
        if (user.getCredit() >= album.getPrice()) {
            // Deduct the price from the user's credit
            user.setCredit(user.getCredit() - album.getPrice());
            userRepository.save(user);

            // Add the album to the user's purchased albums
            user.getPurchasedAlbums().add(album);
            userRepository.save(user);
        } else {
            throw new RuntimeException("Insufficient credits to buy the album");
        }
    }
}
