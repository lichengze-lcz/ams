package cn.lczze.ams.service;

import cn.lczze.ams.entity.BadWay;

import java.util.List;

/**
 * Created by lczze on 2021/3/5 18:35
 */
public interface BadWayService {
    List<BadWay> findAll();

    List<BadWay> findAllByStatus();

    List<BadWay> search(BadWay badWay);

    void createBadWay(String badWayCode, String badWayName);

    BadWay findById(Long id);

    void updateBadWayById(BadWay badWay);

    void changeStuById(Long id);

}
