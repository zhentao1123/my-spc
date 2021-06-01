package cn.bobz.myspcmybatis.service.impl;

import cn.bobz.myspcmybatis.entity.User;
import cn.bobz.myspcmybatis.mapper.UserMapper;
import cn.bobz.myspcmybatis.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bobz
 * @since 2021-06-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
