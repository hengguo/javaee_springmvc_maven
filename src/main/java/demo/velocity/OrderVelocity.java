package demo.velocity;

/**
 * 
 * 
 * 
 * http://www.blogjava.net/zhuyan/articles/108818.html
 */
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class OrderVelocity {
	 public static void main(String[] args) {
	 VelocityEngine ve = new VelocityEngine();
	 ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	 ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	 
	 ve.init();
	 
	 Template t = ve.getTemplate("velocity/order.vm","UTF-8");
	 VelocityContext ctx = new VelocityContext();
	 Row row = new Row();
	 row.setGSXX01("4001"); row.setKCLX("0");row.setSPFL01("R03"); row.setSPFLMC("空调");
	 row.setCK01("4001BX5BX5BA");row.setCKMC("河北国美石家庄配送3C正常库");row.setZDDM("9999");row.setZDMC("9999测试");
	 Rowjqm rowjqm = new Rowjqm();
	 rowjqm.setGSXX01("4001");
	 rowjqm.setJLID("1");
	 rowjqm.setDWMC("乐金电子(中国）有限公司（LG空调）");rowjqm.setSMSL("3.0000");
	 Rowjqmmx rowjqmmx = new Rowjqmmx();
	 rowjqmmx.setJQM01("1111111");rowjqmmx.setJLID("1");rowjqmmx.setGSXX01("4001");rowjqmmx.setXH("1");rowjqmmx.setCSJQM01("");
	 Rowjqmmx rowjqmmx2 = new Rowjqmmx();
	 rowjqmmx2.setJQM01("1111112");rowjqmmx2.setJLID("1");rowjqmmx2.setGSXX01("4001");rowjqmmx2.setXH("1");rowjqmmx2.setCSJQM01("");
	 Rowjqmmx rowjqmmx3 = new Rowjqmmx();
     rowjqmmx3.setJQM01("1111114");rowjqmmx3.setJLID("1");rowjqmmx3.setGSXX01("4001");rowjqmmx3.setXH("1");rowjqmmx3.setCSJQM01("");

	 rowjqm.addRowjqmmx(rowjqmmx);
	 rowjqm.addRowjqmmx(rowjqmmx2);
	 rowjqm.addRowjqmmx(rowjqmmx3);
	 
	 row.addRowjqm(rowjqm);
	 
	 Rowjqm rowjqm2 = new Rowjqm();
	 rowjqm2.setGSXX01("4001");
	 rowjqm2.setJLID("2");
	 rowjqm2.setDWMC("石家庄美的微波电器销售有限公司");rowjqm2.setSMSL("2.0000");
	 Rowjqmmx rowjqmmx4 = new Rowjqmmx();
     rowjqmmx4.setJQM01("2222221");rowjqmmx4.setJLID("2");rowjqmmx4.setGSXX01("4001");rowjqmmx4.setXH("2");rowjqmmx4.setCSJQM01("");
     Rowjqmmx rowjqmmx5 = new Rowjqmmx();
     rowjqmmx5.setJQM01("2222222");rowjqmmx5.setJLID("2");rowjqmmx5.setGSXX01("4001");rowjqmmx5.setXH("2");rowjqmmx5.setCSJQM01("");

	 rowjqm2.addRowjqmmx(rowjqmmx4);
	 rowjqm2.addRowjqmmx(rowjqmmx5);
	 row.addRowjqm(rowjqm2);

	 ctx.put("row", row);
	 StringWriter sw = new StringWriter();
	 
	 t.merge(ctx, sw);
	 
	 System.out.println(sw.toString());
	 }
	}