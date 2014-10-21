package demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * @ClassName JsonDateValueProcessor
 * @Description: 时间转换JSON格式  
 * @author: QIJJ  
 * @since: 2014-3-16 下午4:22:51
 */
public class JsonDateValueProcessor implements JsonValueProcessor {      
    
    private String format = "yyyy-MM-dd HH:mm:ss";      
     
    public JsonDateValueProcessor() {      
     
    }      
     
    public JsonDateValueProcessor(String format) {      
        this.format = format;      
    }      
     
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {      
        String[] obj = {};      
        if (value instanceof Date[]) {      
            SimpleDateFormat sf = new SimpleDateFormat(format);      
            Date[] dates = (Date[]) value;      
            obj = new String[dates.length];      
            for (int i = 0; i < dates.length; i++) {      
                obj[i] = sf.format(dates[i]);      
            }      
        }      
        return obj;      
    }      
     
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {      
        if (value instanceof Date) {      
            String str = new SimpleDateFormat(format).format((Date) value);      
            return str;      
        }      
        return value == null ? null : value.toString();      
    }      
     
    public String getFormat() {      
        return format;      
    }      
     
    public void setFormat(String format) {      
        this.format = format;      
    }      
     
}    