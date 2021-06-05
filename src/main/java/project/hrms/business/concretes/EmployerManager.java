package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.EmployerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployerDao;

import project.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService {

	private EmployerDao _employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this._employerDao=employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this._employerDao.findAll(),"Tüm işverenler listelendi");
	}

	@Override
	public Result register(Employer employer) {
		
		if(isEmployerFormValid(employer)) {
			if(this._employerDao.existsByEmail(employer.getEmail())) {
				
					return new ErrorResult("Bu email adresi ile bir kullanıcı zaten bulunmaktadır.");
			}else {
				this._employerDao.save(employer);
				return new SuccessResult("İş veren bilgileri kaydedildi");
			}
			
		}else {
			return new ErrorResult("Form verileri boş geçilemez.");
		}
		
	}
	
	
	
	
	
	public boolean isEmployerFormValid(Employer employer) {
		if((employer.getCompanyName()==null ||employer.getCompanyName().isBlank())&&(employer.getWebAdress()==null || employer.getWebAdress().isBlank())&&(employer.getEmail()==null||employer.getEmail().isBlank())
				&&(employer.getPhoneNumber()==null)&&(employer.getPassword()==null||employer.getPassword().isBlank())) {
			return false;
		}else {
			return true;
		}
	}

}
