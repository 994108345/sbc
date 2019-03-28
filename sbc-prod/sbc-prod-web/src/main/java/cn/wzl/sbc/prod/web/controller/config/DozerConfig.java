//package cn.wzl.sbc.prod.web.controller.config;
//
//import org.dozer.DozerBeanMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author wzl
// * @date Created in 2019/3/26 20:36
// */
//@Configuration
//public class DozerConfig {
//
//    @Resource
//    private DozerBeanMapper mapper;
//
//    @Bean
//    public DozerBeanMapper dozerBeanMapper(){
//        List<String> fileNameList = new ArrayList<>();
//        fileNameList.add("dozer/mapping.xml");
//        mapper.setMappingFiles(fileNameList);
//        return mapper;
//    }
//}
