/**
* The ProcessMapAlertServiceCenter is a concrete class to process
* MAP-ALERT-SERVICE-CENTRE request.
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/

package com.trg.demo.map.service;

import org.mobicents.protocols.asn.AsnOutputStream;
import org.restcomm.protocols.ss7.map.api.MAPException;
import org.restcomm.protocols.ss7.map.api.primitives.AddressNature;
import org.restcomm.protocols.ss7.map.api.primitives.AddressString;
import org.restcomm.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.restcomm.protocols.ss7.map.api.primitives.NumberingPlan;
import org.restcomm.protocols.ss7.map.primitives.AddressStringImpl;
import org.restcomm.protocols.ss7.map.primitives.ISDNAddressStringImpl;
import org.restcomm.protocols.ss7.map.service.sms.AlertServiceCentreRequestImpl;
import org.springframework.stereotype.Service;
import com.trg.demo.map.apierror.MapMessageException;
import com.trg.demo.map.model.MapModel;
import com.trg.demo.map.model.MapModelAlertServiceCentre;

@Service 
public class ProcessMapAlertServiceCenter extends ProcessMapMessage {
	
	private MapModelAlertServiceCentre param;
	
	public void validateMapParameter(MapModel param) throws MapMessageException {
		
		MapModelAlertServiceCentre tmp = (MapModelAlertServiceCentre)param;
		
		if (tmp.getMsisdn() == null || tmp.getMsisdn().isEmpty()) {
			throw new MapMessageException("Parameter MSISDN missing");
		}
		
		if (tmp.getSca() == null ||  tmp.getSca().isEmpty()) {
			throw new MapMessageException("Parameter Service Center Address missing");
		}
		
		this.param = tmp;
	}
	
	@Override
	public void encode() throws Exception {
		
		AddressString sca = 
        		new AddressStringImpl(AddressNature.international_number, 
        		            NumberingPlan.ISDN, 
        		            this.param.getSca());
        
		ISDNAddressString msisdn = 
        		new ISDNAddressStringImpl(AddressNature.international_number, 
        				NumberingPlan.ISDN,
                        this.param.getMsisdn());
        
        
        AlertServiceCentreRequestImpl asc = 
        		new AlertServiceCentreRequestImpl(msisdn, sca);

        AsnOutputStream asnOS = new AsnOutputStream();
        asc.encodeAll(asnOS);

        byte[] encodedData = asnOS.toByteArray();
        param.setEncodedData(super.bytesToHex(encodedData));
  }

	@Override
	public void decoder() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
