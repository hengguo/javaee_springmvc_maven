package demo.common;
/**   
* @Title: O2MFactory.java 
* @Package com.gome.o2m.common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Wang.Hengguo  
* @date 2015年3月6日
* @version V1.0   
*/


import javax.sql.DataSource;

/** 
 * @PackageName : com.gome.o2m.common
 * @ClassName: O2MFactory 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Wang.Hengguo
 * @date 2015年3月6日
 *  
 */
public class O2MFactory {

    /** 
     * @Title: getO2MDataSource
     * @Description: (这里用一句话描述这个方法的作用). <br/> 
     * @author Wang.Hengguo
     * @return 
     */
    public static DataSource getO2MDataSource() {
       String a = DataSourceContextHolder.getDataSourceType();
       if("db1".equals(a)){
           System.out.println(a);
       }else if("db2".equals(a)){
           System.out.println(a);
       }
       return null;
    }

}
