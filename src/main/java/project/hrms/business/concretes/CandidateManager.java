package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CandidateService;
import project.hrms.business.abstracts.UserCheckService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CandidateDao;

import project.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService {

	@Autowired
	private CandidateDao _candidateDao;
	
	@Autowired
	private UserCheckService _userCheckService;
	
	
	
	public  CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService) {
		this._candidateDao=candidateDao;
		this._userCheckService=userCheckService;
		
	}
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
	
		return new SuccessDataResult<List<Candidate>>(this._candidateDao.findAll(),"Adaylar listelendi."); 
	}

	@Override
	public Result register(Candidate candidate) {
		
		if(this._userCheckService.checkIfRealPerson(candidate)) {
			if(isCandidateFormValid(candidate)) {
				if(this._candidateDao.existsByEmail(candidate.getEmail()) || this._candidateDao.existsByNationalIdentity(candidate.getNationalIdentity())) {
					return new ErrorResult("Bu email veya tcno ile aynı başka aday bulunmaktadır.");
				}else {
					this._candidateDao.save(candidate);
					return new SuccessResult("Kayıt işlemi başarılı");
				}
				
				
			}else {
				return new ErrorResult("Form verileri boş geçilemez");
			}
			
		}else {
			return new ErrorResult("Mernis bu kullanıcıyı onaylamadı.");
		}
		
	
		
			
	
	}
	
	
	public boolean isCandidateFormValid(Candidate candidate) {
		if((candidate.getFirstName()==null ||candidate.getFirstName().isBlank())&&(candidate.getLastName()==null || candidate.getLastName().isBlank())&&(candidate.getNationalIdentity()==null||candidate.getNationalIdentity().isBlank())
				&&(candidate.getBirthDate()==null)&&(candidate.getEmail()==null||candidate.getEmail().isBlank())&&(candidate.getPassword()==null||candidate.getPassword().isBlank())) {
			return false;
		}else {
			return true;
		}
	}
	
	

}
