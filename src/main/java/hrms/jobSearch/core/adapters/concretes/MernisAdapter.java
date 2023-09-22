package hrms.jobSearch.core.adapters.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import hrms.jobSearch.core.adapters.abstracts.MernisService;
import hrms.jobSearch.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements MernisService{

	@Override
	public boolean checkPerson(Candidate candidate) {
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

		try {
			return kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),
					candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(),
					candidate.getBirthYear());
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
