package uni.sofia.master.musicportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uni.sofia.master.musicportal.models.Album;
import uni.sofia.master.musicportal.services.AlbumService;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/{albumId}")
    public String getAlbumDetails(@PathVariable Long albumId, Model model) {
        Album album = albumService.getAlbumById(albumId);
        model.addAttribute("album", album);
        return "album-details";
    }

    @PostMapping("/buy/{albumId}")
    public String buyAlbum(@PathVariable Long albumId, @RequestParam("userId") Long userId) {
        albumService.buyAlbum(userId, albumId);
        return "redirect:/albums/" + albumId;
    }

    @GetMapping("/download/{albumId}")
    public String downloadAlbum(@PathVariable Long albumId, Model model) {
        // Check if the user is authenticated, has purchased the album, etc.
        // For simplicity, this example assumes the user is authorized.
        Album album = albumService.getAlbumById(albumId);
        model.addAttribute("album", album);
        return "download-page";
    }
}
