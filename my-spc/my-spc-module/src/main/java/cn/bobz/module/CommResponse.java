package cn.bobz.module;

public class CommResponse<D> {
	
	public static final String CODE_SUCCEED = "0";
	public static final String CODE_FAIL = "1";
	public static final String MESSAGE_SUCCEED = "操作成功";
	public static final String MESSAGE_FAIL = "操作失败";

	private String code;
	private String message;
	private D data;

	public CommResponse(){
		super();
	}

	public CommResponse(String code, String message, D data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public CommResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public static <D> CommResponse<D> getInstances4Succeed(){
		CommResponse<D> instances = new CommResponse<D>(CODE_SUCCEED, MESSAGE_SUCCEED);
		return instances;
	}
	
	public static <D> CommResponse<D> getInstances4Succeed(D data){
		CommResponse<D> instances = new CommResponse<D>(CODE_SUCCEED, MESSAGE_SUCCEED, data);
		return instances;
	}

	public static <D> CommResponse<D> getInstances4Fail(){
		CommResponse<D> instances = new CommResponse<D>(CODE_FAIL, MESSAGE_FAIL);
		return instances;
	}

	public static <D> CommResponse<D> getInstances4Fail(String errMsg){
		CommResponse<D> instances = new CommResponse<D>(CODE_FAIL, errMsg);
		return instances;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}

}
