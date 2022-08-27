package com.qiudaozhang.content.service.impl;

import com.qiudaozhang.content.entity.Article;
import com.qiudaozhang.content.mapper.ArticleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiudaozhang.content.service.ArticleService
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
open class ArticleServiceImpl : ServiceImpl<ArticleMapper, Article>(), ArticleService {

}
