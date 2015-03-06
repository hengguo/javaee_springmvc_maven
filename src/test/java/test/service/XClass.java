/**   
* @Title: XClass.java 
* @Package test.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Wang.Hengguo  
* @date 2015年2月6日
* @version V1.0   
*/
package test.service;

import java.math.BigDecimal;

/**
 * @Package test.service 
 * @author Wang.Hengguo
 * @date 2015年2月6日下午5:20:37
 */
public class XClass {
	public static void main(String[] args) {
	    BigDecimal a = BigDecimal.valueOf(0).add(BigDecimal.valueOf(168.01).multiply(BigDecimal.valueOf(1)));
	    System.err.println(a);
        BigDecimal b2 = new BigDecimal(String.valueOf(168.01));
        System.out.println(b2);
        BigDecimal bd1 = new BigDecimal("10.123");  
        System.out.println( 1.22+0.89);  

	}

}
