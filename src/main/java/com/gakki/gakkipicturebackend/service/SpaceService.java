package com.gakki.gakkipicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gakki.gakkipicturebackend.model.dto.space.SpaceAddRequest;
import com.gakki.gakkipicturebackend.model.dto.space.SpaceQueryRequest;
import com.gakki.gakkipicturebackend.model.entity.Space;
import com.gakki.gakkipicturebackend.model.entity.User;
import com.gakki.gakkipicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Martinez
 * @description 针对表【space(空间)】的数据库操作Service
 * @createDate 2026-03-04 08:47:06
 */
public interface SpaceService extends IService<Space> {


    /**
     * 创建空间
     *
     * @param spaceAddRequest
     * @param loginUser
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 空间校验
     *
     * @param space
     * @param add   是否为创建时校验
     */
    void validSpace(Space space, boolean add);


    /**
     * 获取空间包装类（单条）
     *
     * @param space
     * @param request
     * @return
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    /**
     * 获取空间包装类（多条）
     *
     * @param spacePage
     * @param request
     * @return
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    /**
     * 获取查询对象
     *
     * @param spaceQueryRequest
     * @return
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);


    /**
     * 根据空间基本填充空间对象
     *
     * @param space
     */
    public void fillSpaceBySpaceLevel(Space space);


    /**
     * 检查空间权限
     *
     * @param loginUser
     * @param space
     */
    void checkSpaceAuth(User loginUser, Space space);


}
