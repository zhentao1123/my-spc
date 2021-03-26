package cn.bobz.myspcweb.config;

import feign.Logger.Level;
import feign.Response;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;

import java.util.concurrent.TimeUnit;

public class DefaultFeignConfigHandler implements FeignConfigHandler{

	@Override
	public Level feignLoggerLevel() {
		return Level.FULL;
	}

	@Override
	public ErrorDecoder feignErrorDecoder() {
		return new ErrorDecoder() {
			@Override
			public Exception decode(String methodKey, Response response) {
				try { 
System.out.println("==================================");
System.out.println(response.status());
System.out.println("==================================");					
					if (response.body() != null) { 
//						String body = IOUtils.toString(response.body().asReader());
						String body = "";
System.out.println("==================================");
System.out.println(body!=null ? body : "");
System.out.println("==================================");
//						FeignErr feignErr = JsonUtil.json2obj(body, FeignErr.class);
System.out.println("==================================");
//System.out.println(feignErr!=null ? JsonUtil.obj2json(feignErr) : "");
System.out.println("==================================");						
//						return new ServiceCallException("status : " + feignErr.getStatus() + ", message : " + feignErr.getMessage());
					} 
//					return new HttpRequestException();
				} catch (Exception e) { 
//					return new ServiceCallException(e);
				}
				return new RuntimeException();
			}
		};
	}

	@Override
	public Retryer feignRetryer() {
		 return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 5);
	}

}
