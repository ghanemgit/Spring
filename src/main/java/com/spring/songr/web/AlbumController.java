package com.spring.songr.web;

import com.spring.songr.domain.Album;
import com.spring.songr.infastructure.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

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
    public Iterable<Album> Albums(){

       return albumRepository.findAll();

    }

    @ResponseBody
    @GetMapping("/getalbums")
    Iterable<Album> getAlbums(Model model){

        model.addAttribute("AlbumList" , albumRepository.findAll());
//        return "album"; //this way didnt work with me the content not rendered to form page

        return albumRepository.findAll();
    }


    @PostMapping("/addAlbum")
    public RedirectView createNewAlbum(@ModelAttribute Album userAlbum){

        albumRepository.save(userAlbum);
        System.out.println(userAlbum.toString());
        return new RedirectView("getalbums");

    }

}
