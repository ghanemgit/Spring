package com.spring.songr.web;

import com.spring.songr.domain.Album;
import com.spring.songr.domain.Song;
import com.spring.songr.infastructure.AlbumRepository;
import com.spring.songr.infastructure.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    public AlbumController(AlbumRepository albumRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name",required = false,defaultValue = "World") String name, Model model){

        System.out.println("Welcome message => " + name );

        model.addAttribute("name", name );

        return "hello";
    }

    @GetMapping("/capitalize/{toCapitalize}")
    public String capitalize(@PathVariable(name = "toCapitalize" , required = false) String name , Model model){


        name = name.toUpperCase();

        model.addAttribute("toCapitalize" , name);
        return "capitalize" ;
    }


    @ResponseBody
    @GetMapping("/albums")
    Iterable<Album> getAlbums(Model model){

        model.addAttribute("AlbumList" , albumRepository.findAll());

        return albumRepository.findAll();
    }


    @PostMapping("/addAlbum")
    public RedirectView createNewAlbum(@ModelAttribute Album userAlbum){

        albumRepository.save(userAlbum);
        System.out.println(userAlbum.toString());
        return new RedirectView("albums");

    }

    @ResponseBody
    @GetMapping("/album/{id}")
    List<Album> getSpecificAlbum(@PathVariable(name = "id") Long id){
        return albumRepository.findAllById(id);
    }


    @ResponseBody
    @GetMapping("/song/{title}")
    Song getSongDetails(@PathVariable String title){

        return songRepository.findSongByTitle(title);
    }

    @ResponseBody
    @GetMapping("/songs")
    Iterable<Song> getAllSongs(Model model){

        model.addAttribute("SongList" , songRepository.findAll());

        return songRepository.findAll();
    }

    @ResponseBody
    @PostMapping("/addSong")
    RedirectView addNewSongToAlbum(Song song,@ModelAttribute(value = "AlbumId") Long AlbumId){

        System.out.println("Welcome from add new song to album method");
        Album album = albumRepository.findById(AlbumId).orElseThrow();
        song.setAlbum(album);
        songRepository.save(song);

        return new RedirectView("albums");

    }

}
