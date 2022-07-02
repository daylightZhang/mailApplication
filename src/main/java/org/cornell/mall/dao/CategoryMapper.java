package org.cornell.mall.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.cornell.mall.pojo.Category;

//@Mapper 这个可以省略，但是要在主程序当中配置MapperScan

public interface CategoryMapper {
    @Select("select * from mall_category where id = #{id}")
    Category findById(@Param("id")Integer id);
    Category queryById(@Param("id") Integer id);
}
