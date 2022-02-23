package com.sesac.boot1.domain;

import lombok.Data;
import lombok.ToString;

@Data //get,set자동생성 equals,hashCode,toString,파라미터x생성자 자동생성

@ToString(exclude= {"val3"})
//원하는 속성만 출력되도록 조정함 ->val3 속성은 출력x
/*@Getter
@Setter
*/
public class SampleVO {

	private String val1;
	private String val2;
	private String val3;

}