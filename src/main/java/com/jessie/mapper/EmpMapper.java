package com.jessie.mapper;

import com.jessie.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    #{},预编译sql，常用与参数传递
//    ${}，直接拼接在sql语句，存在sql注入问题，常用与表名、列名的动态设置
    @Delete("delete from emp where id = #{id}")
    public void deleteById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id") // 主键返回开启，将新增的主键，保存在id属性中
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

//    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, entrydate = #{entrydate}," +
//            "dept_id = #{deptId}, create_time = #{createTime}, update_time = #{updateTime} where id = #{id}")
    public void update(Emp emp);

//    方案三：开启mybatis的驼峰命名自动映射开关
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

//    数据库属性名和类名不一致
//    方案一：起别名
//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time createTime, update_time updateTime " +
//            "from emp where id = #{id}")
//    public Emp getById(Integer id);

//    方案二：通过@Results，@Result注解手动映射封装
//    @Results({
//            @Result(column = "dept_id", property = "deptId"), // column是数据表的属性名，property是实体属性名
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select * from emp where id = #{id}")
//    public Emp getById(Integer id);


//    这里注意'%${name}%'一定要用$符号，而不是#，#无法转义，但是这种方法不安全，查询时会被看到数值（修改方案在下方）
//    @Select("select * from emp where name like '%${name}%' and gender = #{gender} and entrydate between #{startDate} and #{endDate} order by update_time desc ")
//    public List<Emp> getByCondition (String name, Short gender, LocalDate startDate, LocalDate endDate);

//修改方案：使用concat进行拼接
//    @Select("select * from emp where name like concat('%',#{name}, '%') and gender = #{gender} and entrydate between #{startDate} and #{endDate} order by update_time desc ")
//    public List<Emp> getByCondition (String name, Short gender, LocalDate startDate, LocalDate endDate);


    public List<Emp> getByCondition (String name, Short gender, LocalDate startDate, LocalDate endDate);

    // delete from emp where id in (18,19,20);
    public void deleteByIds(List<Integer> ids);

}
