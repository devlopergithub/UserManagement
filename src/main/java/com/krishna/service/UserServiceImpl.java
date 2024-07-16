package com.krishna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishna.entities.UserAccount;
import com.krishna.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public String saveOrUpdateUser(UserAccount account) {
		Integer userId= account.getUserId();
		repo.save(account);
		if(userId==null) {
			return "User saved successfully...";
		}
		return "User updated successfully...";
	}

	@Override
	public List<UserAccount> getAllAccounts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public UserAccount getuser(Integer id) {
		// TODO Auto-generated method stub
		Optional<UserAccount> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		boolean existsById = repo.existsById(id);
		if(existsById) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAccStatus(Integer id, String status) {
		// TODO Auto-generated method 
		try {
			repo.updateAccStatus(id, status);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
