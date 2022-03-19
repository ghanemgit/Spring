package com.spring.songr;

import com.spring.songr.domain.Album;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

//@SpringBootTest
class SongrApplicationTests {

	Album album;

	@BeforeEach
	void setUp(){
		album = new Album();
	}


	@Test
	@DisplayName("Albums class tester")
	void AlbumTest(){

		List<String> expexted = new ArrayList<>();
		List<String> actual = new ArrayList<>();

		expexted.add(new Album("Mashari bin rashed alafasi",114,82800,"https://i1.sndcdn.com/artworks-000064438699-df5i71-t240x240.jpg").toString());
		expexted.add(new Album("Abd Elbaset Abd Alsamad",114,102002,"https://play-lh.googleusercontent.com/HkH8heEczp9bFoy-aSgAEmaWbe33dtRQwCsju99LS_P84iElihuUFRVUW6GJnMGlk9Y").toString());
		expexted.add(new Album("Fares Abbad",114,81563,"https://i.ytimg.com/vi/H9vOrb1vHNs/maxresdefault.jpg").toString());

		actual.add("Album{artist='Mashari bin rashed alafasi', songCount=114, length=82800, imageUrl='https://i1.sndcdn.com/artworks-000064438699-df5i71-t240x240.jpg'}");
		actual.add("Album{artist='Abd Elbaset Abd Alsamad', songCount=114, length=102002, imageUrl='https://play-lh.googleusercontent.com/HkH8heEczp9bFoy-aSgAEmaWbe33dtRQwCsju99LS_P84iElihuUFRVUW6GJnMGlk9Y'}");
		actual.add("Album{artist='Fares Abbad', songCount=114, length=81563, imageUrl='https://i.ytimg.com/vi/H9vOrb1vHNs/maxresdefault.jpg'}");

		assertLinesMatch(expexted,actual);


	}

}
