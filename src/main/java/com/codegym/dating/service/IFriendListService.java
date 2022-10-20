package com.codegym.dating.service;



public interface IFriendListService {
    String checkFriend(Integer idUser1, Integer idUser2);
    void addRequest(Integer idUser1, Integer idUser2);
    void removeRequest(Integer idUser1, Integer idUser2);

}
