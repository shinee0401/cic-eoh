/**
 * 
 */
package za.co.sindi.cic.service.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author buhake.sindi
 *
 */
public class DateAdapter extends XmlAdapter<String, Date> {

	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	@Override
	public Date unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		synchronized (DATE_FORMAT) {
            return DATE_FORMAT.parse(v);
        }
	}

	@Override
	public String marshal(Date v) throws Exception {
		// TODO Auto-generated method stub
		synchronized (DATE_FORMAT) {
            return DATE_FORMAT.format(v);
        }
	}
}
