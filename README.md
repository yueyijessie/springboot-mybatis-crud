# springboot-mybatis-crud
Mybatis基础操作+动态SQL

lombok配置快速创建entity
MybatisX插件

> XML配置文件
在Mybatis中使用XML映射文件方式开发，需要符合一定的规范：
1. XML映射文件的名称与Mapper接口名称一致，并且将XML映射文件和Mapper接口放置在相同包下（同包同名）
2. XML映射文件的namespace属性为Mapper接口全限定名一致(copy reference)
3. XML映射文件中sql语句的id与Mapper接口中的方法名一致，并保持返回类型一致(resultType)。

> 动态SQL
- `<if>` 用于判断条件是否成立，如果条件为true，则拼接SQL
- `<where>` where元素只会在子元素有内容的情况下才插入where子句，而且会自动去除子句的开头的AND或OR
- `<set>` 动态地在行首插入 SET 关键字，并会删掉额外的逗号。（用在update语句中）
- ```
  <foreach collection="集合名称" item="集合遍历出来的元素/项" separator="每一次遍历使用的分隔符" open="遍历开始前拼接的片段" close="遍历结束后拼接的片段">
    #{集合遍历出来的元素/项}
  </foreach>
  ```
- `<sql>` 定义可重用的SQL片段
- `<include>` 通过属性refid，指定包含的SQL片段
