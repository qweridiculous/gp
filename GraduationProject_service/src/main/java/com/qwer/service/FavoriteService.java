package com.qwer.service;

import com.qwer.domain.Favorite;

import java.util.List;

public interface FavoriteService {
    public List<Favorite> findMyFav(int uid) throws Exception;
    public boolean removeFav(int bid) throws Exception;

    boolean addFav(Favorite favorite);

    boolean isFav(int bid, int uid);

    int getFavCount(int bid);

    List<Favorite> findFavByCount();

}
