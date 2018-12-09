package com.meiko.leesite.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * mybatis-plus 代码生成类
 * </p>
 *
 * @author meiko-zahng
 * @since 2018-12-08
 */
public class GeneratorApplication {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    /**
     * 执行代码生成
     *
     * @param args
     */
    public static void main(String[] args) {
        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig()
                .setUrl("jdbc:mysql://192.168.133.128:3306/leesite?useUnicode=true&characterEncoding=utf-8&useSSL=false")
                .setDbType(DbType.MYSQL)  //数据库类型(必须)
//                .setSchemaName("public")  //数据库 schema name
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("123456");

        String projectName=scanner("项目名");
        String modelName=scanner("模块名");

        // 包名配置
        PackageConfig packageConfig = new PackageConfig()
                .setParent("com.meiko.leesite")  //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
                .setModuleName(modelName)  //父包模块名
                .setEntity("domain")  //Entity包名
                .setMapper("mapper")
                .setXml("mapper")
                .setService("service")
                .setController("controller")
//                .setPathInfo() //路径配置信息
                ;

        // 数据库表配置
        StrategyConfig strategyConfig = new StrategyConfig()
                .setCapitalMode(true) //是否大写命名 ORACLE 注意
                .setSkipView(true)  //是否跳过视图
                .setNaming(NamingStrategy.underline_to_camel) //数据库表映射到实体的命名策略
                .setColumnNaming(NamingStrategy.underline_to_camel) //数据库表字段映射到实体的命名策略
                .setTablePrefix(packageConfig.getModuleName() + "_")  //表前缀
//                .setFieldPrefix()  //字段前缀
//                .setSuperEntityClass("")  //自定义继承的Entity类全称，带包名
//                .setSuperEntityColumns("id") //自定义基础的Entity类，公共字段
                .setSuperMapperClass("com.meiko.leesite.generator.base.mapper.SuperMapper")  //自定义继承的Mapper类全称，带包名
//                .setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService")  //自定义继承的Service类全称，带包名
//                .setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl")  //自定义继承的ServiceImpl类全称，带包名
                .setSuperControllerClass("com.baomidou.mybatisplus.extension.api.ApiController")  //自定义继承的Controller类全称，带包名
                .setInclude(scanner("表名"))  //需要包含的表名，允许正则表达式（与exclude二选一配置）
//                .setExclude("")  //需要排除的表名，允许正则表达式
//                .setEntityColumnConstant(false) //【实体】是否生成字段常量（默认 false）
//                .setEntityBuilderModel(false) //【实体】是否为构建者模型（默认 false）
                .setEntityLombokModel(true) //【实体】是否为lombok模型（默认 false）
                .setEntityBooleanColumnRemoveIsPrefix(true) //Boolean类型字段是否移除is前缀（默认 false）
                .setRestControllerStyle(true)  //生成 @RestController 控制器
                .setControllerMappingHyphenStyle(true)  //驼峰转连字符
                .entityTableFieldAnnotationEnable(true)  //是否生成实体时，生成字段注解
//                .setVersionFieldName("")  //乐观锁属性名称
//                .setLogicDeleteFieldName("is_delete") //逻辑删除属性名称
//                .setTableFillList() //表填充字段
                ;

        //模板配置
        TemplateConfig templateConfig = new TemplateConfig()
                .setXml(null)
//                .setEntity("/templates/entity.java.ftl")  //Java 实体类模板
//                .setMapper("/templates/mapper.java.ftl")
//                .setXml("/templates/mapper.xml.ftl")
//                .setService("/templates/service.java.ftl")
//                .setServiceImpl("/templates/serviceImpl.java.ftl")
//                .setController("/templates/controller.java.ftl")
                ;

        // 全局策略配置
        String projectPath = System.getProperty("user.dir"); //自动获取当前项目根目录
        GlobalConfig globalConfig = new GlobalConfig()
                .setOutputDir(projectPath + "/" + projectName + "/src/main/java")  //生成文件的输出目录
                .setFileOverride(true)  // 是否覆盖已有文件
                .setOpen(false)  //是否打开输出目录
//                .setEnableCache(false)   //是否在xml中添加二级缓存配置
                .setAuthor("meiko-zahng")
//                .setKotlin(false)  //开启 Kotlin 模式
                .setSwagger2(true)  //开启 swagger2 模式
                .setActiveRecord(true)  //开启 ActiveRecord 模式
                .setBaseResultMap(true)  //开启 BaseResultMap
                .setBaseColumnList(true)  //开启 baseColumnList
                .setDateType(DateType.ONLY_DATE) //时间类型对应策略 只使用 java.util.date 代替
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController")
                .setIdType(IdType.ID_WORKER_STR)  //指定生成的主键的ID类型

                ;


        // 注入 injectionConfig 配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/" + projectName + "/src/main/resources/mapper/" +
//                        packageConfig.getModuleName() + "/"+
                        tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);


        //执行代码生成器
        new AutoGenerator()
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setCfg(cfg)
                .setStrategy(strategyConfig)
                .setTemplate(templateConfig)
                .setGlobalConfig(globalConfig)
                .execute();
    }
}
