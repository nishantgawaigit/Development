package AutomationCore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PageObjectBase {
	protected static final String propertyPath=System.getProperty("user.dir")+"\\Properties.properties";
	protected Properties properties;
	
	public Properties getBaselinedProperty() {
		System.out.println(propertyPath);
		if (properties == null) {
			try {
				properties.load(new FileInputStream(propertyPath));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			return properties;
		return properties;
	}
	public static void main(String args[]){
		PageObjectBase p = new PageObjectBase();
		p.getBaselinedProperty();
	}
	
	
}
