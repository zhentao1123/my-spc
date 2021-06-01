package cn.bobz.myspcmybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class CodeGenerator {

    private String url = "jdbc:mysql://127.0.0.1:3307/mybatis-test";
    private String username = "root";
    private String password = "root";
    private String schema = "mybatis-test";

    private String author = "bobz";

    private String parent = "cn.bobz.myspcmybatis";

    public void doGen(String moduleName, String tables){

        DataSourceConfig dataSourceConfig = new DataSourceConfig
                .Builder(url, username, password)
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler())
                .dbQuery(new MySqlQuery())
                //.schema(schema) //生成entity的时候会带上TableName标签，并在原表名前加上schema
                .build();

        GlobalConfig globalConfig = GeneratorBuilder.globalConfigBuilder()
                .fileOverride()//.openDir(true).enableSwagger()
                .outputDir(System.getProperty("user.dir") + "/src/main/java")
                .author(author).dateType(DateType.TIME_PACK).commentDate("yyyy-MM-dd")
                .build();

        PackageConfig.Builder packageConfigBuilder = new PackageConfig.Builder().parent(parent);
        if(StringUtils.isNotBlank(moduleName)) {
            packageConfigBuilder.moduleName(moduleName);
        }
        PackageConfig packageConfig = packageConfigBuilder.build();

        TemplateConfig templateConfig = new TemplateConfig.Builder().build();

        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .addInclude(tables)
//                .disableSqlFilter() //关闭sql过滤
                .enableCapitalMode()// 是否大写命名
                .entityBuilder()// 实体配置构建者
//                .enableLombok()// 开启lombok模型
                .versionColumnName("version") //乐观锁数据库表字段
                .naming(NamingStrategy.underline_to_camel)// 数据库表映射到实体的命名策略
//                .addTableFills(new Column("create_time", FieldFill.INSERT))	//基于数据库字段填充
//                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))	//基于模型属性填充
                .controllerBuilder() //控制器属性配置构建
//                .restStyle(true)
                .build();

        FreemarkerTemplateEngine templateEngine = new  FreemarkerTemplateEngine();

        new AutoGenerator(dataSourceConfig)
                .global(globalConfig)
                .packageInfo(packageConfig)
                .template(templateConfig)
                .strategy(strategyConfig)
                .execute(templateEngine);

    }
}
