package project.hrms.adapter;


import java.util.Locale;

import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.UserCheckService;
import project.hrms.entities.concretes.Candidate;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();
		boolean result = false;
		
		try {
			
			result = proxy.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalIdentity()), candidate.getFirstName().toUpperCase(new Locale("tr","TR")), 
					candidate.getLastName().toUpperCase(new Locale("tr", "TR")),candidate.getBirthDate().getYear());
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return result;
	}
	
}
