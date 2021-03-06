package demo.common.bean;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;



import demo.common.Constrants;
import demo.domain.Code;
import demo.mapper.CodeDao;

@Component
public class InitCodeBean implements BeanPostProcessor{
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof CodeDao){
			List<Code> list = ((CodeDao)bean).getAll();
			String temp_id = list.get(0).getCodeId();//上一个id
			Map<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
				public int compare(String o1, String o2) {  
		         	return o1.compareTo(o2);  
		    	}     
			});
			for(int i = 0; i < list.size(); i++){
				if(!list.get(i).getCodeId().equals(temp_id)){
					Constrants.CODEMAP.put(temp_id, map);
					map = new TreeMap<String, String>(new Comparator<String>() {
						public int compare(String o1, String o2) {  
				         	return o1.compareTo(o2);  
				    	}     
					});
					map.put(list.get(i).getCodeKey(), list.get(i).getCodeValue());
					temp_id = list.get(i).getCodeId();
				}else{
					map.put(list.get(i).getCodeKey(), list.get(i).getCodeValue());
					if(i == list.size() - 1){
						Constrants.CODEMAP.put(temp_id, map);
					}
				}
			}
		}
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}
}
