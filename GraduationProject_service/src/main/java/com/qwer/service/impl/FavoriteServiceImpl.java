package com.qwer.service.impl;

import com.qwer.domain.Favorite;
import com.qwer.dao.FavoriteDao;
import com.qwer.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteDao favoriteDao;

    @Override
    public List<Favorite> findMyFav(int uid) throws Exception {
        return favoriteDao.findByUid(uid);
    }

    @Override
    public boolean removeFav(int bid) throws Exception {
        return favoriteDao.removeFav(bid);
    }

    @Override
    public boolean addFav(Favorite favorite) {
        return favoriteDao.addFav(favorite);
    }

    @Override
    public boolean isFav(int bid, int uid) {
        Favorite favorite = favoriteDao.findByUB(bid,uid);
        return favorite!=null;
    }

    @Override
    public int getFavCount(int bid) {
        return favoriteDao.getFavCount(bid);
    }

    @Override
    public List<Favorite> findFavByCount() {
        return favoriteDao.findFavByCount();
    }
}
