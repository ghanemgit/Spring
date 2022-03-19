package com.spring.songr.web;

import com.spring.songr.domain.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController {

//    @Autowired
//    UserRepository userRepository;

    @GetMapping("/hello")
    String hello(@RequestParam(name="name",required = false,defaultValue = "World") String name, Model model){

        System.out.println("Welcome message => " + name );

        model.addAttribute("name", name );

        return "hello";
    }


    @GetMapping("/capitalize/{toCapitalize}")
    String capitalize(@PathVariable(name = "toCapitalize" , required = false) String name , Model model){


        name = name.toUpperCase();

        model.addAttribute("toCapitalize" , name);
        return "capitalize" ;
    }


    @ResponseBody
    @GetMapping("/albums")
    List<Album> getAlbums(){

        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Mashari bin rashed alafasi",114,82800,"https://i1.sndcdn.com/artworks-000064438699-df5i71-t240x240.jpg"));
        albums.add(new Album("Abd Elbaset Abd Alsamad",114,102002,"https://play-lh.googleusercontent.com/HkH8heEczp9bFoy-aSgAEmaWbe33dtRQwCsju99LS_P84iElihuUFRVUW6GJnMGlk9Y"));
        albums.add(new Album("Fares Abbad",114,81563,"https://i.ytimg.com/vi/H9vOrb1vHNs/maxresdefault.jpg"));

        System.out.println(albums.toString());
        return albums;

    }

}
