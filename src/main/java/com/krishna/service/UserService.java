package com.krishna.service;

import java.util.List;

import com.krishna.entities.UserAccount;

public interface UserService {
	
	public String saveOrUpdateUser(UserAccount account);
	
	public List<UserAccount> getAllAccounts();
	
	public UserAccount getuser(Integer id);
	
	public boolean deleteUser(Integer id);
	
	public boolean updateAccStatus(Integer id, String status);

}
