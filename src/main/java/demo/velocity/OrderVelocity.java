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
	 
	 Template t = ve.getTemplate("velocity/order2.vm","UTF-8");
	 VelocityContext ctx = new VelocityContext();
	 ROW row = new ROW();
	 row.setGSXX01("4001");
	 row.setKCLX("0");
	 ROWJQM rowjqm = new ROWJQM();
	 rowjqm.setGSXX01("4001");
	 rowjqm.setJLID("1");
	 ROWJQMMX rowjqmmx = new ROWJQMMX();
	 rowjqmmx.setJQM01("1111111");
	 rowjqmmx.setJLID("1");
	 ROWJQMMX rowjqmmx2 = new ROWJQMMX();
	 rowjqmmx2.setJQM01("1111112");
	 rowjqmmx2.setJLID("1");
	 rowjqm.addRowjqmmx(rowjqmmx);
	 rowjqm.addRowjqmmx(rowjqmmx2);
	 row.addRowjqm(rowjqm);
	 ROWJQM rowjqm2 = new ROWJQM();
	 rowjqm2.setGSXX01("4001");
	 rowjqm2.setJLID("2");
	 ROWJQMMX rowjqmmx3 = new ROWJQMMX();
	 rowjqmmx3.setJQM01("2222221");
	 rowjqmmx3.setJLID("2");
	 ROWJQMMX rowjqmmx4 = new ROWJQMMX();
	 rowjqmmx4.setJQM01("2222222");
	 rowjqmmx4.setJLID("2");
	 rowjqm2.addRowjqmmx(rowjqmmx3);
	 rowjqm2.addRowjqmmx(rowjqmmx4);
	 row.addRowjqm(rowjqm2);

	 ctx.put("rowjqms", row.getRowjqms());
//	 ctx.put("rowjqmmxs", )
	 ctx.put("ROW", row);
	 StringWriter sw = new StringWriter();
	 
	 t.merge(ctx, sw);
	 
	 System.out.println(sw.toString());
	 }
	}