package cn.bobz.myspcweb.config;

import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;

public interface FeignConfigHandler {

	public static final String HEADER_MICRO_SERVICE_ID = "MICRO_SERVICE_ID";
	
	public Logger.Level feignLoggerLevel();
	
	public ErrorDecoder feignErrorDecoder();
	
	public Retryer feignRetryer();
	
}
