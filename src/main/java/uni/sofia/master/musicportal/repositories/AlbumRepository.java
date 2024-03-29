package uni.sofia.master.musicportal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.sofia.master.musicportal.models.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
