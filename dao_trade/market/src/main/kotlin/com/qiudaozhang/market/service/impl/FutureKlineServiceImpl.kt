package com.qiudaozhang.market.service.impl;

import com.qiudaozhang.market.entity.FutureKline;
import com.qiudaozhang.market.mapper.FutureKlineMapper;
import com.qiudaozhang.market.service.FutureKlineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qiudaozhang
 * @since 2022-08-27
 */
@Service
open class FutureKlineServiceImpl : ServiceImpl<FutureKlineMapper, FutureKline>(), FutureKlineService {

}
