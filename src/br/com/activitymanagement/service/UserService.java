package br.com.activitymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.activitymanagement.dao.User;
import br.com.activitymanagement.dao.UserDao;

@Service("usuarioService")
@Transactional
public class UserService {
	
	private UserDao usuarioDao;
	
	@Autowired
	public void setUsuarioDao(UserDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}
			
	public List<User> getAllUsers(){
		return usuarioDao.getUsers();
	}

	public void saveOrUpdate(User user) {
		usuarioDao.saveOrUpdate(user);		
	}

}
