/**
* The ProcessReadyForSM is a concrete class to process
*  MAP-READY-FOR-SM request.
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/

package com.trg.demo.map.service;

import org.mobicents.protocols.asn.AsnOutputStream;
import org.restcomm.protocols.ss7.map.api.MAPException;
import org.restcomm.protocols.ss7.map.api.primitives.IMSI;
import org.restcomm.protocols.ss7.map.api.service.sms.AlertReason;
import org.restcomm.protocols.ss7.map.primitives.IMSIImpl;
import org.restcomm.protocols.ss7.map.service.sms.ReadyForSMRequestImpl;
import org.springframework.stereotype.Service;
import com.trg.demo.map.apierror.MapMessageException;
import com.trg.demo.map.model.MapModel;
import com.trg.demo.map.model.MapModelReadyForSM;


@Service 
public class ProcessReadyForSM extends ProcessMapMessage{

	private MapModelReadyForSM param;
	
	@Override
	public void validateMapParameter(MapModel param) throws MapMessageException {
		
		MapModelReadyForSM temp = (MapModelReadyForSM) param;
		
		if (temp.getAlertReason() == null) {
			throw new MapMessageException("Parameter Alert Reason missing");
		}
		
		if (temp.getAlertReason().length() != 1) {
			throw new MapMessageException("Parameter Alert Reason length invalid");
		}
		
		AlertReason ar1 = AlertReason.memoryAvailable;
		String str1 = String.valueOf(ar1.getCode());
		
		AlertReason ar2 = AlertReason.msPresent;
		String str2 = String.valueOf(ar2.getCode());
		
		
		if (!temp.getAlertReason().equals(str1)  &&
				!temp.getAlertReason().equals(str2)) {
			throw new MapMessageException("Parameter Alert Reason incorrect code");
		}
		
		if (temp.getImsi() == null || temp.getImsi().isEmpty()) {
			throw new MapMessageException("Parameter IMSI missing");
		}
		
		this.param = temp;
	}

	@Override
	public void encode() throws Exception {
		
		IMSI imsi = new IMSIImpl(param.getImsi());
        
        AlertReason ar;
        if (param.getAlertReason().equals("1"))
        	ar = AlertReason.memoryAvailable;
        else
        	ar = AlertReason.msPresent;
        
        ReadyForSMRequestImpl impl = new ReadyForSMRequestImpl(imsi, 
        		                                               ar, 
        		                                               false, 
        		                                               null, 
        		                                               false);
        AsnOutputStream asnOS = new AsnOutputStream();

        impl.encodeAll(asnOS);

        byte[] encodedData = asnOS.toByteArray();
        
        param.setEncodedData(super.bytesToHex(encodedData));
	}

	@Override
	public void decoder() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
