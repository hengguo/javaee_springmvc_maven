package demo.service;

import java.util.List;
import java.util.Map;

import com.gome.common.page.Page;
import demo.domain.Code;

public interface CodeService {
	List<Map<String, Object>> getHxCodePageList(Page page);
	
	List<Map<String, Object>> getHxCodeSettingByCodeId(String codeId);
	
	List<Map<String, String>> getOrgCombobox();

	List<Map<String, String>> getFittingMenu(String fittingPositionId);
}