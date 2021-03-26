package cn.bobz.myspcweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Retryer;
import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfig implements RequestInterceptor{
	
	@Value("${spring.application.name}")
	public String appName;
	
	@Bean
	public FeignConfigHandler feignConfigHandler() {
		return new DefaultFeignConfigHandler();
	}
	
	@Autowired
	private FeignConfigHandler feignConfigHandler;
	
	@Bean
    public Logger.Level feignLoggerLevel() {
		return feignConfigHandler.feignLoggerLevel();
    }
	
	/**
	 * 配置重试器
	 * @return
	 */
//	@Bean
//    public Retryer feignRetryer(){
//       return feignConfigHandler.feignRetryer();
//    }
	
	/**
	 * 自定义错误处理器
	 * @return
	 */
	@Bean
	public ErrorDecoder feignErrorDecoder() {
		return feignConfigHandler.feignErrorDecoder();
	}
	
	/**
	 * 可以做些全局处理
	 */
	@Override
	public void apply(RequestTemplate template) {
		template.header(FeignConfigHandler.HEADER_MICRO_SERVICE_ID, appName);
	}

}