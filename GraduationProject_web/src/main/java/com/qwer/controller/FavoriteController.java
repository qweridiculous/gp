package com.qwer.controller;

import com.qwer.domain.Favorite;
import com.qwer.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@RequestMapping("/favorite")
@Controller
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/findMyFav.do")
    @ResponseBody
    public List<Favorite> findMyFav(int uid) throws Exception{
        return favoriteService.findMyFav(uid);
    }

    @RequestMapping("/removeFav.do")
    @ResponseBody
    public  boolean removeFav(int bid) throws Exception{
        return favoriteService.removeFav(bid);
    }

    @RequestMapping("/addFav.do")
    @ResponseBody
    public boolean addFav(Favorite favorite) throws Exception{
        favorite.setFavDate(new Date());
        return favoriteService.addFav(favorite);
    }
    @RequestMapping("/isFav.do")
    @ResponseBody
    public boolean isFav(@RequestParam("bid") int bid, @RequestParam("uid") int uid) throws Exception {
        return favoriteService.isFav(bid,uid);
    }

    @RequestMapping("/getFavCount.do")
    @ResponseBody
    public int getFavCount(int bid) throws Exception{
        return favoriteService.getFavCount(bid);
    }

    @RequestMapping("/getFavRank.do")
    @ResponseBody
    public List<Favorite> getFavRank() throws Exception{
        return favoriteService.findFavByCount();
    }
}
