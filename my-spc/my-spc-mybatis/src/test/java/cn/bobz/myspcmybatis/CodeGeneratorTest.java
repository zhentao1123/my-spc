package cn.bobz.myspcmybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CodeGeneratorTest {

    @Autowired
    CodeGenerator godeGenerator;

    @Test
    public void testGen(){
        godeGenerator.doGen(null, "user");
    }

}
